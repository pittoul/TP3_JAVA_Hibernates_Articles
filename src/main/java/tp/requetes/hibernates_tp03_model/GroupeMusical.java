/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.hibernates_tp03_model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Bruno
 */
@Entity
public class GroupeMusical extends Personne implements Serializable{
    
    
    @OneToMany
    private List<Cd> listeCd;
    
    @Column(name = "nom_groupe_", unique = true)
    private String nomDuGroupe;

    @OneToMany
    private List<GroupeMusical> membres;


    public GroupeMusical(String nomDuGroupe, String nom, String prenom) {
        super(nom, prenom);
        this.nomDuGroupe = nomDuGroupe;
    }

    public GroupeMusical(String nom, String prenom) {
        super(nom, prenom);
    }

    public GroupeMusical(String nomDuGroupe) {
        this.nomDuGroupe = nomDuGroupe;
    }

    public GroupeMusical() {
    }


    public void setNomDuGroupe(String nomDuGroupe) {
        this.nomDuGroupe = nomDuGroupe;
    }
    
    
    public String getNomDuGroupe() {
        return nomDuGroupe;
    }
    
    public List<Cd> getListeCd() {
        return listeCd;
    }

    public void setListeCd(List<Cd> listeCd) {
        this.listeCd = listeCd;
    }

    public List<GroupeMusical> getMembres() {
        return membres;
    }

    public void setMembres(List<GroupeMusical> membres) {
        this.membres = membres;
    }

    
    
}
