/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requete.main;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import tp.requete.exception.AlreadyExistsException;
import tp.requetes.dao.ArticleDao;
import tp.requetes.dao.CdDao;
import tp.requetes.dao.GroupeMusicalDao;
import tp.requetes.dao.PersonneDao;
import tp.requetes.hibernates_tp03_model.Article;
import tp.requetes.hibernates_tp03_model.Auteur;
import tp.requetes.hibernates_tp03_model.Cd;
import tp.requetes.hibernates_tp03_model.GroupeMusical;
import tp.requetes.hibernates_tp03_model.Personne;

/**
 *
 * @author Bruno
 */
public class Main {

    private static CdDao cdDao = new CdDao();
    private static GroupeMusicalDao groupeMusicalDao = new GroupeMusicalDao(); // Nécessaire ? Vu qu'on déjà personneDao ?
    private static PersonneDao personneDao = new PersonneDao();
    private static ArticleDao articleDao = new ArticleDao();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AlreadyExistsException {

//        Creation de la BDD (voir le fichier persistence.xml)
        Persistence.createEntityManagerFactory("TP03Bdd");

        /**
         *
         *
         * Création du jeu de données
         *
         */
// 
// 
// 
//        3 groupes musicaux de type Transient:
// 
// 
// 
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
        Cd daftCd1 = new Cd(daftPunkt, "Homework", 12);
        Cd daftCd2 = new Cd(daftPunkt, "Discovery", 12);
        Cd daftCd3 = new Cd(daftPunkt, "Human after all", 12);

        GroupeMusical beatles = new GroupeMusical("The Beatles");
        List<GroupeMusical> membresBeatles = new ArrayList<>();
        Personne john = new GroupeMusical("Lennon", "John");
        Personne paul = new GroupeMusical("Mac Cartney", "Paul");
        Personne ringo = new GroupeMusical("Starr", "Ringo");
        Personne georges = new GroupeMusical("Harrison", "Georges");
        membresBeatles.add((GroupeMusical) john);
        membresBeatles.add((GroupeMusical) paul);
        membresBeatles.add((GroupeMusical) ringo);
        membresBeatles.add((GroupeMusical) georges);
        beatles.setMembres(membresBeatles);
        Cd beatlesCd1 = new Cd(beatles, "A Hard Day's Night", 12);
        Cd beatlesCd2 = new Cd(beatles, "Yellow Submarine", 12);

        GroupeMusical queen = new GroupeMusical("Queen");
        List<GroupeMusical> membresQueen = new ArrayList<>();
        Personne freddy = new GroupeMusical("Mercury", "Freddy");
        Personne brian = new GroupeMusical("May", "Brian");
        Personne roger = new GroupeMusical("Taylor", "Roger");
        Personne johnD = new GroupeMusical("Deacon", "Johon");
        membresQueen.add((GroupeMusical) freddy);
        membresQueen.add((GroupeMusical) brian);
        membresQueen.add((GroupeMusical) roger);
        membresQueen.add((GroupeMusical) johnD);
        Cd queenCd1 = new Cd(queen, "A Kind of Magic", 12);
        Cd queenCd2 = new Cd(queen, "A Night at the Opera", 14);

//        
//        
//        Auteurs:
//    
//    
//    
        Personne victor = new Auteur("Hugo", "Victor");
        Personne emile = new Auteur("Zola", "Emile");
        Personne albert = new Auteur("Camus", "Albert");

//
//
//
//        INSERTION EN BASE DES INSTANCES DE PERSONNES:
//
//
//
        personneDao.insert(tom);
        personneDao.insert(guy);
        personneDao.insert(john);
        personneDao.insert(paul);
        personneDao.insert(ringo);
        personneDao.insert(georges);
        personneDao.insert(freddy);
        personneDao.insert(brian);
        personneDao.insert(roger);
        personneDao.insert(johnD);

        personneDao.insert(victor);
        personneDao.insert(emile);
        personneDao.insert(albert);

        groupeMusicalDao.insert(daftPunkt);
        groupeMusicalDao.insert(beatles);
        groupeMusicalDao.insert(queen);

//
//
//
//        INSERTION EN BASE D'ARTICLES DE TYPE CD:
//
//
// ... bug insertion des cd's......
        cdDao.insert(daftCd1);
        cdDao.insert(daftCd2);
        cdDao.insert(daftCd3);
        cdDao.insert(beatlesCd1);
        cdDao.insert(beatlesCd2);
        cdDao.insert(queenCd1);
        cdDao.insert(queenCd2);

//        
//        
//        
//        AFFICHAGE D'UN GROUPE:
//
//
// erreur : groupeMusical is not mapped
groupeMusicalDao.findAll().forEach(grp -> {
    System.out.println(grp.getNomDuGroupe());
    List<GroupeMusical> liste =  grp.getMembres();
    liste.forEach(mbr -> {
            System.out.println(mbr.getPrenom()+ " - " + mbr.getNom());
    });
});
System.out.println();


//        
//        
//        
//        AFFICHAGE DE TOUS LES CD DISPONIBLES EN BASE:
//
//
//
        System.out.println("AFFICHER LA LISTE DES CD DISPONIBLES : ");
        cdDao.findAll().forEach(cd -> {
            System.out.println(cd.getTitre() + " - * - * - * - * - * - " + cd.getGroupe().getNomDuGroupe());
            System.out.println();
        });

    }

}
