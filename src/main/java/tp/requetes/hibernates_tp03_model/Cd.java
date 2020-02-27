/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.hibernates_tp03_model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Bruno
 */
@Entity
public class Cd extends Article implements Serializable{
    
    @ManyToOne
    private GroupeMusical groupe;
    
    @OneToOne
    private StyleMusical style;

    public Cd(GroupeMusical groupe, StyleMusical style, String titre, int prix) {
        super(titre, prix);
        this.groupe = groupe;
        this.style = style;
    }

    public StyleMusical getStyle() {
        return style;
    }

    public void setStyle(StyleMusical style) {
        this.style = style;
    }

    public Cd(String titre) {
        super(titre);
    }

    public Cd(GroupeMusical groupe, String titre, int prix) {
        super(titre, prix);
        this.groupe = groupe;
    }

    public Cd(String titre, int prix) {
        super(titre, prix);
    }

    public GroupeMusical getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeMusical groupe) {
        this.groupe = groupe;
    }
    
    
    
}
