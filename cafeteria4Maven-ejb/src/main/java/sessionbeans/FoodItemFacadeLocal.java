/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.FoodItem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Pablo
 */
@Local
public interface FoodItemFacadeLocal {

    void create(FoodItem foodItem);

    void edit(FoodItem foodItem);

    void remove(FoodItem foodItem);

    FoodItem find(Object id);

    List<FoodItem> findAll();

    List<FoodItem> findRange(int[] range);

    int count();
    
}
