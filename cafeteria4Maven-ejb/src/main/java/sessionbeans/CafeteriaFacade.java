/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Cafeteria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DarkAnimat
 */
@Stateless
public class CafeteriaFacade extends AbstractFacade<Cafeteria> implements CafeteriaFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_cafeteria4Maven-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CafeteriaFacade() {
        super(Cafeteria.class);
    }
    
    @Override
    public Integer getIdCafeteria(){
        Cafeteria caf=Cafeteria.getInstance();
        
        String idCafBD= em.createNativeQuery("SELECT idcafeteria FROM cafeteria").getSingleResult().toString();
        caf.setIdcafeteria(Integer.parseInt(idCafBD));
        Cafeteria caf2=Cafeteria.getInstance();
        caf2.setName("otro nombre");
        Integer idCafeteria=caf.getIdcafeteria();
        System.out.println("///// ID ------------------ //////"+idCafeteria);
        System.out.println("///// NOMBRE ------------------ //////"+caf.getName());
        return idCafeteria;
    }
}