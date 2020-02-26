/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.hibernates_tp03_model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bruno
 */
@Entity
public class Cd extends Article implements Serializable{
    
    @ManyToOne
    private GroupeMusical groupe;

    public GroupeMusical getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeMusical groupe) {
        this.groupe = groupe;
    }
    
    
    
}
