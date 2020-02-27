/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.hibernates_tp03_model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;

/**
 *
 * @author Bruno
 */
@Entity
public class Acteur extends Personne {

    @ManyToMany
    private List<Dvd> listeDvd;

    public Acteur(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<Dvd> getListeDvd() {
        return listeDvd;
    }

    public void setListeDvd(List<Dvd> listeDvd) {
        this.listeDvd = listeDvd;
    }
   
}
