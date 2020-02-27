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
import javax.persistence.OneToMany;

/**
 *
 * @author Bruno
 */
@Entity
public class Livre extends Article implements Serializable {

    

    @ManyToMany(mappedBy = "listeLivres")
    private List<Auteur> listAuteurs;

    public Livre(String titre, int prix) {
        super(titre, prix);
    }

    public Livre(String titre) {
        super(titre);
    }

    public List<Auteur> getListAuteurs() {
        return listAuteurs;
    }

    public void setListAuteurs(List<Auteur> listAuteurs) {
        this.listAuteurs = listAuteurs;
    }


}
