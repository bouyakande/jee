/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Mouvement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ghost
 */
@Local
public interface MouvementFacadeLocal {

    void create(Mouvement mouvement);

    void edit(Mouvement mouvement);

    void remove(Mouvement mouvement);

    Mouvement find(Object id);

    List<Mouvement> findAll();

    List<Mouvement> findRange(int[] range);

    int count();
    
}
