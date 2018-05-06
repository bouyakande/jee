package Entities;

import Entities.Categorie;
import Entities.Mouvement;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-16T20:41:28")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, Categorie> categorie;
    public static volatile SingularAttribute<Produit, Integer> pu;
    public static volatile SingularAttribute<Produit, byte[]> photo;
    public static volatile SingularAttribute<Produit, Integer> id;
    public static volatile SingularAttribute<Produit, String> designation;
    public static volatile ListAttribute<Produit, Mouvement> mouvementList;

}