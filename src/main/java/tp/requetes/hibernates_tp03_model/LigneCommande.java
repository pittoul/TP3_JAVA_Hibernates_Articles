/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.hibernates_tp03_model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
public class LigneCommande implements Serializable {

//    Pas besoin de clé primaire, on fait avec la clé composée
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Id
    private long idCommande;

    @Id
    private long idArticle;

    @Column(name = "quantite_")
    private int quantite;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = (int) (61 * hash + this.idCommande);
        hash = (int) (61 * hash + this.idArticle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) { // à quoi sert cette méthode ?
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LigneCommande other = (LigneCommande) obj;
        if (this.idCommande != other.idCommande) {
            return false;
        }
        if (this.idArticle != other.idArticle) {
            return false;
        }
        return true;
    }

    public long getidCommande() {
        return idCommande;
    }

    public void setidCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public long getidArticle() {
        return idArticle;
    }

    public void setidArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}
