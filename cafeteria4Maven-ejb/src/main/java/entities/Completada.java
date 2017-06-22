/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Denisse
 */
public class Completada implements OrdenState{
    Orden orden;
    
     
    
    public Completada(Orden orden2){

        orden = orden2;
    }

 

    @Override
    public String verEstado() {
        //System.out.println("Pendiente");
        return "completada";
        
    }
}
