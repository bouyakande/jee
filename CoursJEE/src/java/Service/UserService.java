/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Utilisateur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ghost
 */
@Stateless
public class UserService implements Iuser{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Utilisateur FindUser(String log, String pass) {
        List<Utilisateur> listU=em.createNamedQuery("Utilisateur.findByGoodUser", Utilisateur.class)
                .setParameter("login", log).setParameter("password", pass).getResultList();
        if(listU.isEmpty())
        {
            return  null;
            
        }
        else 
            return listU.get(0);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
