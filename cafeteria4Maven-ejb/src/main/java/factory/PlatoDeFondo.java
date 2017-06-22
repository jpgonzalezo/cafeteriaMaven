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
public class PlatoDeFondo extends FoodItem{
    @EJB
    private FoodItemFacadeLocal foodItemFacade;
    String tipoComida;
    FoodItem platoDeFondo;
    
    public PlatoDeFondo(Integer id){
        this.platoDeFondo=foodItemFacade.find(id);
        this.tipoComida="Plato de Fondo";
    }
    
    public String getTipoComida(){
        return this.tipoComida;
    }
    
    public FoodItem getEnsalada(){
        return this.platoDeFondo;
    }
    
    public void setTipoComida(String nuevaComida){
        tipoComida=nuevaComida;
    }
    
    public void setEnsalada(FoodItem nuevoFondo){
        platoDeFondo=nuevoFondo;
    }
}
