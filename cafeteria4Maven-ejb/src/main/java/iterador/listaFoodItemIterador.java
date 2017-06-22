/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterador;
import entities.FoodItem;
import java.util.*;

/**
 *
 * @author Juan Pablo
 */
public class listaFoodItemIterador implements Iterador{
    private List<FoodItem> listaMenu;
    private int posicion;
    
    public listaFoodItemIterador(List<FoodItem> comidasMenu){
            this.listaMenu=comidasMenu;
            this.posicion=0;
    }
    @Override
    public FoodItem siguiente(){
        return listaMenu.get(posicion++);
    }
    @Override
    public boolean tieneSiguiente(){
        if (posicion<listaMenu.size()) {
            return true;
        } 
        else {
            return false;
        }
    }
    
}
