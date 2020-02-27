/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.hibernates_tp03_model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Bruno
 */
@Entity
public class Auteur extends Personne implements Serializable{

   @ManyToMany
   @JoinTable(name = "auteur_livre",
            joinColumns = {
                @JoinColumn(name = "auteur_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "livre_id")})
    private List<Livre> listeLivres;

    public Auteur(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<Livre> getListeLivre() {
        return listeLivres;
    }

    public void setListeLivre(List<Livre> listeLivres) {
        this.listeLivres = listeLivres;
    }
   
   
    
}
