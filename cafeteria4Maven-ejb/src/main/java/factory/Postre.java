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
public class Postre extends FoodItem{
    @EJB
    private FoodItemFacadeLocal foodItemFacade;
    String tipoComida;
    FoodItem postre;
    
    public Postre(Integer id){
        this.postre=foodItemFacade.find(id);
        this.tipoComida="Postre";
    }
    
    public String getTipoComida(){
        return this.tipoComida;
    }
    
    public FoodItem getEnsalada(){
        return this.postre;
    }
    
    public void setTipoComida(String nuevaComida){
        tipoComida=nuevaComida;
    }
    
    public void setEnsalada(FoodItem nuevoPostre){
        postre=nuevoPostre;
    }
    
}
