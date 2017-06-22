/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;
import entities.Completada;
import entities.FoodItem;
import entities.Orden;
import entities.OrdenState;
import entities.Orden;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan Pablo
 */
@Stateless
public class OrdenFacade extends AbstractFacade<Orden> implements OrdenFacadeLocal {

    @EJB
    private FoodItemFacadeLocal foodItemFacade;

    @EJB
    private MenuFacadeLocal menuFacade;

    Orden orden= new Orden();
    
    OrdenState completada;
    
    @PersistenceContext(unitName = "com.mycompany_cafeteria4Maven-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFacade() {
        super(Orden.class);
    }
    
    /**
     *
     * @param id_foodItem
     * @return
     */
    @Override
    public FoodItem consulta(Integer id_foodItem){
        List lista= em.createNativeQuery("SELECT idfood_item FROM food_item WHERE idfood_item="+id_foodItem).getResultList();
        FoodItem elemento= foodItemFacade.find(Integer.parseInt(lista.get(0).toString()));
        return elemento;
    }
    
    @Override
    public String consultarEstado(){
       
        String estado= orden.verEstado();
        return estado;
    }
    @Override
    public void CambiarEstado(){
        completada = new Completada(orden);
        orden.setOrdenState(completada);
    }
    
    @Override
    public void guardarDatosOrden(String idCliente,Integer propina,Integer precioComida,float precioEntrega,String direccionEntrega,String bloque, List<List<String>> foodSeleccionada, String estado,Integer idCafeteria){
        System.out.println("/////////////////"+bloque+"\\\\\\\\\\\\\\\\\\\\\\\\");
        Object ultimoId= em.createNativeQuery("SELECT max(idorden) FROM orden").getSingleResult();
        String numeroUltimoId= ultimoId.toString();
        Integer id_orden= Integer.parseInt(numeroUltimoId)+1;
        Query query =em.createNativeQuery("INSERT INTO orden (idorden, address, payment, price_food, taxes, price_delivery, status, client_idclient, cafeteria_idcafeteria, delivery_iddelivery) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
        query.setParameter(1, id_orden);
        query.setParameter(2, direccionEntrega);
        query.setParameter(3, "efectivo");
        query.setParameter(4, precioComida);
        query.setParameter(5, propina);
        query.setParameter(6, precioEntrega);
        query.setParameter(7, estado);
        query.setParameter(8, idCliente);
        query.setParameter(9, idCafeteria);
        
        if (bloque.isEmpty()){
           query.setParameter(10, 0); 
        }
        else{query.setParameter(10, bloque);}
        query.executeUpdate(); 
        
        
         for(int i=0; i< foodSeleccionada.size(); i++) {
             List<String> comida = foodSeleccionada.get(i);
             String id_comida= comida.get(0);
             Query query2= em.createNativeQuery("INSERT INTO orden_has_food_item (orden_idorden, food_item_idfood_item) VALUES (?, ?)");
             query2.setParameter(1, id_orden);
             query2.setParameter(2, id_comida);
             query2.executeUpdate();
         }
    }
    
    @Override
    public void actualizarStock(List<List<String>> foodSeleccionada){
        
         for(int i=0; i< foodSeleccionada.size(); i++) {
             List<String> comida = foodSeleccionada.get(i);
             String id_comida= comida.get(0);
             Integer stockAnterior=Integer.parseInt(comida.get(3));
             Integer stockActual= stockAnterior-1;
             Query query2= em.createNativeQuery("UPDATE food_item SET stock= ? WHERE idfood_item = ?");
             query2.setParameter(1, stockActual);
             query2.setParameter(2, id_comida);
             query2.executeUpdate();
         }
    }
    
}
