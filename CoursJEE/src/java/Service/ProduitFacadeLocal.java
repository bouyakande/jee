/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Produit;
import java.util.List;
import java.util.function.Predicate;
import javax.ejb.Local;

/**
 *
 * @author ghost
 */
@Local
public interface ProduitFacadeLocal {
    Produit findProd(Predicate<Produit> pre);

    void create(Produit produit);

    void edit(Produit produit);

    void remove(Produit produit);

    Produit find(Object id);

    List<Produit> findAll();

    List<Produit> findRange(int[] range);

    int count();
    
}
