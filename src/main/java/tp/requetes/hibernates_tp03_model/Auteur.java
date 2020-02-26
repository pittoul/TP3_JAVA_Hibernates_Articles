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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Bruno
 */
@Entity
public class Auteur extends Personne implements Serializable{

   @OneToMany
    private List<Livre> listeLivre;

    public Auteur(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<Livre> getListeLivre() {
        return listeLivre;
    }

    public void setListeLivre(List<Livre> listeLivre) {
        this.listeLivre = listeLivre;
    }
   
   
    
}
