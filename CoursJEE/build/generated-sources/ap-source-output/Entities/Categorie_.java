package Entities;

import Entities.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-16T20:41:28")
@StaticMetamodel(Categorie.class)
public class Categorie_ { 

    public static volatile ListAttribute<Categorie, Produit> produitList;
    public static volatile SingularAttribute<Categorie, String> numCat;
    public static volatile SingularAttribute<Categorie, Integer> id;
    public static volatile SingularAttribute<Categorie, String> nom;

}