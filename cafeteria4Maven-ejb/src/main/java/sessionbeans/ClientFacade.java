/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Client;
import entities.FoodItem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Pablo
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    
    @EJB
    private FoodItemFacadeLocal foodItemFacade;
    @EJB
    private ClientFacadeLocal clientFacade;

    @PersistenceContext(unitName = "com.mycompany_cafeteria4Maven-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ClientFacade() {
        super(Client.class);
    }
    
     /*
    Mostrar ordener realizadas por un cliente en especifico
    entrada: email nos da el id y con el id se obtienen las ordenes 
    salida: lista de ordenes
    */
    public List<List<String>> consultarOrden(String email){
        List lista= em.createNativeQuery("SELECT food_item_idfood_item from orden_has_food_item where orden_idorden=(SELECT idorden from orden where client_idclient= (SELECT idclient FROM client WHERE email='"+email+"' and STATUS='ok'))")
                .getResultList();
        
        
      
       //Object elemento= new FoodItem();
       List<List<String>> listaFinal= new ArrayList<List<String>>();
       for(int i=0; i< lista.size(); i++) {
           FoodItem elemento= foodItemFacade.find((Integer)lista.get(i));
            List<String> listaAux= new ArrayList<String>();
            //Object elemento= em.createNativeQuery("SELECT * FROM food_item WHERE idfood_item="+lista.get(i)).getSingleResult();
            String nombre= elemento.getName();
            String precio= ""+elemento.getPrice();
            String stock= ""+ elemento.getStock();
            String is_especial= ""+ elemento.getIsEspecial();
            listaAux.add(nombre);
            listaAux.add(precio);
            listaAux.add(stock);
            listaAux.add(is_especial);
            listaFinal.add(listaAux);
            
    	}
        
    
      return listaFinal;
    }
    @Override
    public List<String> consultarUser(String mail, String pass){
        List lista= em.createNativeQuery("SELECT idClient FROM client WHERE email ='"+mail+"' and password ='"+pass+"'")
                .getResultList();
        
        List<String> aux = new ArrayList<>();
        
        
        if(lista.isEmpty()){return lista;}
        
        
        Client elemento= clientFacade.find((Integer)lista.get(0));
        String idClient = elemento.getIdclient().toString();
        String nombre = elemento.getName();
        String password = elemento.getPassword();
        String email = elemento.getEmail();
        String address = elemento.getAddress();
            
        aux.add(idClient);
        aux.add(nombre);
        aux.add(password);
        aux.add(email);
        aux.add(address);
            
        return aux;
    }
    
}
