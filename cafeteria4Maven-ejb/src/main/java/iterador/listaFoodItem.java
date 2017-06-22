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
public class listaFoodItem {
    private List<FoodItem> listaComidas;
    private int posicion;
    
    public listaFoodItem(){
        listaComidas=new ArrayList<FoodItem>();
        this.posicion=0;
    }
    public void agregar(FoodItem comida){
        listaComidas.add(comida);
    }
    
    public listaFoodItemIterador iterador(){
        return new listaFoodItemIterador(listaComidas);
    }
}
