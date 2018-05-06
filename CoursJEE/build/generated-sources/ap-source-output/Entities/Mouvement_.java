package Entities;

import Entities.Produit;
import Entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-16T20:41:28")
@StaticMetamodel(Mouvement.class)
public class Mouvement_ { 

    public static volatile SingularAttribute<Mouvement, Date> date;
    public static volatile SingularAttribute<Mouvement, Utilisateur> idUser;
    public static volatile SingularAttribute<Mouvement, Integer> qte;
    public static volatile SingularAttribute<Mouvement, Produit> idProd;
    public static volatile SingularAttribute<Mouvement, Integer> qteFinal;
    public static volatile SingularAttribute<Mouvement, Integer> id;
    public static volatile SingularAttribute<Mouvement, String> type;
    public static volatile SingularAttribute<Mouvement, Integer> qteInitial;

}