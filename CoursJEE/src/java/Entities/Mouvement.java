/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ghost
 */
@Entity
@Table(name = "mouvement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mouvement.findAll", query = "SELECT m FROM Mouvement m")
    , @NamedQuery(name = "Mouvement.findById", query = "SELECT m FROM Mouvement m WHERE m.id = :id")
    , @NamedQuery(name = "Mouvement.findByDate", query = "SELECT m FROM Mouvement m WHERE m.date = :date")
    , @NamedQuery(name = "Mouvement.findByQte", query = "SELECT m FROM Mouvement m WHERE m.qte = :qte")
    , @NamedQuery(name = "Mouvement.findByType", query = "SELECT m FROM Mouvement m WHERE m.type = :type")
    , @NamedQuery(name = "Mouvement.findByQteInitial", query = "SELECT m FROM Mouvement m WHERE m.qteInitial = :qteInitial")
    , @NamedQuery(name = "Mouvement.findByQteFinal", query = "SELECT m FROM Mouvement m WHERE m.qteFinal = :qteFinal")})
public class Mouvement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qte")
    private int qte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qteInitial")
    private int qteInitial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qteFinal")
    private int qteFinal;
    @JoinColumn(name = "idProd", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produit idProd;
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utilisateur idUser;

    public Mouvement() {
    }

    public Mouvement(Integer id) {
        this.id = id;
    }

    public Mouvement(Integer id, Date date, int qte, String type, int qteInitial, int qteFinal) {
        this.id = id;
        this.date = date;
        this.qte = qte;
        this.type = type;
        this.qteInitial = qteInitial;
        this.qteFinal = qteFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQteInitial() {
        return qteInitial;
    }

    public void setQteInitial(int qteInitial) {
        this.qteInitial = qteInitial;
    }

    public int getQteFinal() {
        return qteFinal;
    }

    public void setQteFinal(int qteFinal) {
        this.qteFinal = qteFinal;
    }

    public Produit getIdProd() {
        return idProd;
    }

    public void setIdProd(Produit idProd) {
        this.idProd = idProd;
    }

    public Utilisateur getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilisateur idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mouvement)) {
            return false;
        }
        Mouvement other = (Mouvement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Mouvement[ id=" + id + " ]";
    }
    
}
