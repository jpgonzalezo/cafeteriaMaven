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
public class ensalada extends FoodItem{
    @EJB
    private FoodItemFacadeLocal foodItemFacade;
    String tipoComida;
    FoodItem ensalada;
    
    public ensalada(Integer id){
        this.ensalada=foodItemFacade.find(id);
        this.tipoComida="Ensalada";
    }
    
    public String getTipoComida(){
        return this.tipoComida;
    }
    
    public FoodItem getEnsalada(){
        return this.ensalada;
    }
    
    public void setTipoComida(String nuevaComida){
        tipoComida=nuevaComida;
    }
    
    public void setEnsalada(FoodItem nuevaEnsalada){
        ensalada=nuevaEnsalada;
    }
    
}
