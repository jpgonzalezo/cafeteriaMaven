/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.FoodItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DarkAnimat
 */
@Stateless
public class FoodItemFacade extends AbstractFacade<FoodItem> implements FoodItemFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_cafeteria4Maven-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FoodItemFacade() {
        super(FoodItem.class);
    }
    
}