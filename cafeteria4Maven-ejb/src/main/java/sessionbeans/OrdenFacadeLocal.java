/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.FoodItem;
import entities.Orden;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DarkAnimat
 */
@Local
public interface OrdenFacadeLocal {

    void create(Orden orden);

    void edit(Orden orden);

    void remove(Orden orden);

    Orden find(Object id);

    List<Orden> findAll();

    List<Orden> findRange(int[] range);

    int count();
    
    FoodItem consulta(Integer id_foodItem);
    
    void guardarDatosOrden(String idCliente,Integer propina,Integer precioComida,float precioEntrega,String direccionEntrega,String bloque, List<List<String>> foodSeleccionada, String estado,Integer idCafeteria);
    
    void CambiarEstado();
    
    String consultarEstado();
    
    void actualizarStock(List<List<String>> foodSeleccionada);
}
