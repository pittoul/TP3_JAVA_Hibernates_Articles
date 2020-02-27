/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requete.main;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import tp.requetes.hibernates_tp03_model.Article;
import tp.requetes.hibernates_tp03_model.Cd;
import tp.requetes.hibernates_tp03_model.GroupeMusical;
import tp.requetes.hibernates_tp03_model.Personne;

/**
 *
 * @author Bruno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Creatoin de la BDD (voir le fichier persistence.xml)
        Persistence.createEntityManagerFactory("TP03Bdd");
        
        
        
        /**
         *
         *
         * Création du jeu de données
         *
         */

//        3 groupes musicaux:
        GroupeMusical daftPunkt = new GroupeMusical("Daft-Punkt", "", "");
        daftPunkt.setNomDuGroupe("Daft-Punkt");
        GroupeMusical tom = new GroupeMusical("", "Thomas", "Bangalter");
        GroupeMusical guy = new GroupeMusical();
        guy.setPrenom("Guy-Manuel");
        guy.setNom("de Homem-Christo");
        List<GroupeMusical> membresDaftPunk = new ArrayList<>();
        membresDaftPunk.add(tom);
        membresDaftPunk.add(guy);
        daftPunkt.setMembres(membresDaftPunk);
        
        GroupeMusical beatles = new GroupeMusical("The Beatles");
        List<GroupeMusical> membresBeatles = new ArrayList<>();
        Personne john = new GroupeMusical();
        john.setPrenom("John");
        john.setNom("Lennon");
        Personne paul = new GroupeMusical("Mac Cartney", "Paul");
        membresBeatles.add((GroupeMusical) john);
        membresBeatles.add((GroupeMusical) paul);
        beatles.setMembres(membresBeatles);
        
        
        System.out.println("GROUPE ! " + beatles.toString());
        
        
        
        
        
        
        
        
        
        
        
        Article article = new Article();
        article.setTitre("Guitare évasion");
        article.setPrix(5);

        GroupeMusical queen = new GroupeMusical();
        queen.setNom("Mercury");
        queen.setPrenom("Freddy");
        queen.setNom("May");
        queen.setPrenom("Brian");

        Cd albumQueen1 = new Cd();
        albumQueen1.setGroupe(queen);

        Cd albumQueen2 = new Cd();
        albumQueen2.setGroupe(queen);

        System.out.println("album============>" + albumQueen2.getGroupe().getPrenom());

    }

}
