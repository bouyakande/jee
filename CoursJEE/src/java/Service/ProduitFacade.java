/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Produit;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ghost
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> implements ProduitFacadeLocal {

    @PersistenceContext(unitName = "CoursJEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }

    @Override
    public Produit findProd(Predicate<Produit> pre) 
    {
        List<Produit> lp=findAll();
        
        Optional<Produit> p= lp.stream().filter(pre).findAny();
        if(p.isPresent())
        {
            return p.get();
        }
        return null;
    }
    
}
