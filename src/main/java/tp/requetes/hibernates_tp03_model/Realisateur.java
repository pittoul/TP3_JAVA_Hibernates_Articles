/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.hibernates_tp03_model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Bruno
 */
@Entity
public class Realisateur extends Personne implements Serializable{
    
    @OneToMany
    private List<Dvd> listeDvd;

    public Realisateur(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<Dvd> getListeDvd() {
        return listeDvd;
    }

    public void setListeDvd(List<Dvd> listeDvd) {
        this.listeDvd = listeDvd;
    }
    
    
    
    
}
