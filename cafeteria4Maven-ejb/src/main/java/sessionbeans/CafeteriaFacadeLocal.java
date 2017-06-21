/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Cafeteria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Pablo
 */
@Local
public interface CafeteriaFacadeLocal {

    void create(Cafeteria cafeteria);

    void edit(Cafeteria cafeteria);

    void remove(Cafeteria cafeteria);

    Cafeteria find(Object id);

    List<Cafeteria> findAll();

    List<Cafeteria> findRange(int[] range);

    int count();
    
    Integer getIdCafeteria();
    
}
