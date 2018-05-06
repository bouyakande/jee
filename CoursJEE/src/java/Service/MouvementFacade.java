/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Mouvement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ghost
 */
@Stateless
public class MouvementFacade extends AbstractFacade<Mouvement> implements MouvementFacadeLocal {

    @PersistenceContext(unitName = "CoursJEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MouvementFacade() {
        super(Mouvement.class);
    }
    
}
