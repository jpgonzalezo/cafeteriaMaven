/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import sessionbeans.FoodItemFacadeLocal;
import entities.FoodItem;
import javax.ejb.EJB;

/**
 *
 * @author Juan Pablo
 */
public class Factory {
    @EJB
    private FoodItemFacadeLocal foodItemFacade;
    public Integer id;
    
    public Factory(Integer idEntrada){
        id=idEntrada;
    }
    
    public FoodItem crearComida(){
        return foodItemFacade.find(id);
    }
}
