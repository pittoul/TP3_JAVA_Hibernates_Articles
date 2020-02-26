/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.hibernates_tp03_model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bruno
 */
@Entity
public class Dvd extends Article implements Serializable{
    
    @ManyToMany(mappedBy = "listeDvd")
    private List<Acteur> listActeur;
    

    @ManyToOne
    private Realisateur realisateur;

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }
    

    public List<Acteur> getListActeur() {
        return listActeur;
    }

    public void setListActeur(List<Acteur> listActeur) {
        this.listActeur = listActeur;
    }
    
}
