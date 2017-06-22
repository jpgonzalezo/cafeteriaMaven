package managedbeans;

import sessionbeans.CafeteriaFacadeLocal;
import sessionbeans.ClientFacadeLocal;
import sessionbeans.FoodItemFacadeLocal;
import entities.Orden;
import managedbeans.util.JsfUtil;
import managedbeans.util.JsfUtil.PersistAction;
import sessionbeans.OrdenFacadeLocal;
import entities.Client;
import entities.Email;
import entities.FoodItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent; 
import javax.mail.MessagingException;
import managedbeans.LoginController;


@Named("ordenController")
@SessionScoped
public class OrdenController implements Serializable {

    @EJB
    private ClientFacadeLocal cliente;

    @EJB
    private CafeteriaFacadeLocal cafeteria;
    
    @EJB
    private OrdenFacadeLocal ejbFacade;
    
    
    
    private List<Orden> items = null;
    private Orden selected;
    private Integer propina;
    private Integer precioComida=0;
    private String direccionEntrega=new String();
    private Integer precioEntrega=2500;
    private String idCliente;
    private String estado;
    private List<Integer> cantidades;
    private Email correo;
    
    
    List <String>foodAux=null;
    private List<List<String>> foodSeleccionada=null;
    private List<FoodItem> foodItemSeleccionada = new ArrayList<>();
    

    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String opcion; 
    private String bloque="no";  
    private Map<String,String> opciones;
    private Map<String,String> bloques;
     
    public void init() {
        opciones  = new HashMap<String, String>();
        opciones.put("Si", "Si");
        opciones.put("No", "No");
        
        Map<String,String> map = new HashMap<String, String>();
        map.put("12:00-12:15", "1");
        map.put("12:15-12:30", "2");
        map.put("12:30-12:45", "3");
        map.put("12:45-13:00", "4");
        map.put("13:00-13:15", "5");
        map.put("13:15-13:30", "6");
        map.put("13:30-13:45", "7");
        map.put("13:45-14:00", "8");
        data.put("Si", map);
    }
 
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getEstado() {
        return estado;
    }
 
    public void setEstado() {
        this.estado = getFacade().consultarEstado();
        
    }
    
    public String getOpcion() {
        return opcion;
    }
 
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
 
    public String getBloque() {
        return bloque;
    }
 
    public void setBloque(String bloque) {
        this.bloque = bloque;
    }
    
    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }
 
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }
    public Map<String, String> getOpciones() {
        return opciones;
    }
 
    public Map<String, String> getBloques() {
        return bloques;
    }
 
    
    public String guardarOrden(ActionEvent actionEvent){
        Client persona= cliente.find(Integer.parseInt(idCliente));
        String email=persona.getEmail();
        Integer total= precioComida+propina+precioEntrega;
        String listaComidaCorreo="";
        for (int i = 0; i <foodSeleccionada.size(); i++) {
            listaComidaCorreo=listaComidaCorreo+foodSeleccionada.get(i).get(1)+": "+foodSeleccionada.get(i).get(2)+"\n";
        }
        try {
            correo.Enviar("sadcafeteria", "alcidesquispe", email, "Detalle Orden Realizada","Detalle orden Realizada\n"+
                                                                                            "----------------------------"+"\n"+
                                                                                            "Precio Total Comida :"+precioComida+"\n"+
                                                                                            "Precio Entrega :"+precioEntrega+"\n"+
                                                                                            "Propina: "+propina+"\n"+
                                                                                            "Direccion Entrega: "+ direccionEntrega+"\n"+
                                                                                            "Comida seleccionada: \n"+ listaComidaCorreo+"\n"+
                                                                                            "Total: "+ total+"\n"+
                                                                                            "\n"+
                                                                                            "\n"+
                                                                                            "Gracias por su preferencia.");
        } catch (MessagingException ex) {
            Logger.getLogger(OrdenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getFacade().CambiarEstado();
        setEstado();
        Integer idCafeteria= cafeteria.getIdCafeteria();
        getFacade().guardarDatosOrden(idCliente, propina, precioComida,precioEntrega,direccionEntrega,bloque,foodSeleccionada,estado,idCafeteria); 
        getFacade().actualizarStock(foodSeleccionada);
        return "compraTerminada";
    }
    public void onOpcionChange() {
        if(opcion !=null && !opcion.equals(""))
            bloques = data.get(opcion);
        else
            bloques = new HashMap<String, String>();
    }
     
    public void displayLocation() {
        FacesMessage msg;
        if(bloque != null && opcion != null)
            msg = new FacesMessage("Selected", bloque + " of " + opcion);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    

    public float getPrecioEntrega(){
        return this.precioEntrega;
    }
    
    public void setPrecioEntrega(Integer nuevoPrecio){
        this.precioEntrega=nuevoPrecio;
    }
    
    public String getDireccionEntrega(){
        return this.direccionEntrega;
    }
    
    public void setDireccionEntrega(String nuevaDireccion){
        this.direccionEntrega=nuevaDireccion;
    }
    public List<FoodItem> getFoodItemSeleccionada(){
        return this.foodItemSeleccionada;
    }
    
    public List<List<String>> getFoodSeleccionada(){
        return this.foodSeleccionada;
    }
    
    public void setFoodSeleccionada(List<List<String>> foodSeleccionada){
        //this.foodSeleccionada.clear();
        this.foodSeleccionada = foodSeleccionada;
    }
    
    public Integer getPropina(){
        return this.propina;
    }
    
    public void setPropina(Integer nuevaPropina){
        this.propina=nuevaPropina;
    }
    
    public Integer getPrecioComida(){
        return this.precioComida;
    }
    
    public void setPrecioComida(Integer masPrecio){
        this.precioComida=this.precioComida+masPrecio;
    }

    public OrdenController() {
    }

    public Orden getSelected() {
        return selected;
    }

    public void setSelected(Orden selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OrdenFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Orden prepareCreate() {
        selected = new Orden();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("OrdenCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("OrdenUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("OrdenDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Orden> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    public void vaciarFoodItemSeleccionado(){
        precioComida = 0;
        foodItemSeleccionada.clear();
    }
    
    
    public List<FoodItem> createFoodItemSeleccionada(List<List<String>> foodSeleccionada){
        //System.out.println(foodSeleccionada);
        for (int i=0; i<foodSeleccionada.size(); i++) {
            
            FoodItem elemento= ejbFacade.consulta(Integer.parseInt(foodSeleccionada.get(i).get(0)));
            foodItemSeleccionada.add(elemento);
            setPrecioComida(elemento.getPrice().intValue());
        }
        return foodItemSeleccionada;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Orden getOrden(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Orden> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Orden> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Orden.class)
    public static class OrdenControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OrdenController controller = (OrdenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ordenController");
            return controller.getOrden(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Orden) {
                Orden o = (Orden) object;
                return getStringKey(o.getIdorden());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Orden.class.getName()});
                return null;
            }
        }

    }
    
}
