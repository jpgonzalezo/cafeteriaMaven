/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import sessionbeans.FoodItemFacadeLocal;
import entities.FoodItem;
import entities.Menu;
import factory.Factory;
import iterador.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DarkAnimat
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> implements MenuFacadeLocal {

    @EJB
    private FoodItemFacadeLocal foodItemFacade;

    @PersistenceContext(unitName = "com.mycompany_cafeteria4Maven-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }
   
    @Override
    public List<List<String>> consulta(Integer id_menu){
        List lista= em.createNativeQuery("SELECT food_item_idfood_item FROM menu_has_food_item WHERE menu_idmenu="+id_menu).getResultList();       
        listaFoodItem listaFinal = new listaFoodItem();
        List<List<String>> listaFinalString=new ArrayList<List<String>>();
        Iterador iterador;
        Factory fabricaFoodItem;
        for(int i=0; i< lista.size(); i++) {
            FoodItem elemento;
            try {
                fabricaFoodItem=new Factory(((Integer)lista.get(i)));
                elemento= fabricaFoodItem.crearComida();    
            } catch (NullPointerException e) {
                elemento= foodItemFacade.find((Integer)lista.get(i));
            }
            
            if (elemento.getStock()>0){
                listaFinal.agregar(elemento);
            }
        }
        iterador=listaFinal.iterador();
        while(iterador.tieneSiguiente()){
            //acceder al elemento 
            FoodItem auxiliar=iterador.siguiente();
            List<String> listaAux= new ArrayList<String>();
            //Object elemento= em.createNativeQuery("SELECT * FROM food_item WHERE idfood_item="+lista.get(i)).getSingleResult();
            listaAux.add(auxiliar.getIdfoodItem().toString());
            listaAux.add(auxiliar.getName());
            listaAux.add(auxiliar.getPrice().toString());
            listaAux.add(auxiliar.getStock().toString());
            listaAux.add(auxiliar.getIsEspecial().toString());
            listaFinalString.add(listaAux);
        }
      return listaFinalString;
    }

}
