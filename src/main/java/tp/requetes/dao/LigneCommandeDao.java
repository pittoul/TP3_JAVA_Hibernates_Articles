/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import tp.requete.exception.AlreadyExistsException;
import tp.requetes.databaseHelper.DatabaseHelper;
import tp.requetes.hibernates_tp03_model.LigneCommande;

/**
 *
 * @author Bruno
 */
public class LigneCommandeDao extends GenericDao {

    public LigneCommande insert(LigneCommande ligneCommande) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        // Check if number already exists
//        LigneCommande existing = findByNumber(getByCommande(ligneCommande.getFk_id_commande()));
//        if (existing != null) {
//            throw new AlreadyExistsException("Une ligne de commande portant l'indice : " + ligneCommande.getNumber() + " already exists.");
//        }
        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(ligneCommande);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return ligneCommande;
    }

    public LigneCommande update(LigneCommande ligneCommande) {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(ligneCommande);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return ligneCommande;
    }

    public void deleteLigne(LigneCommande ligneCommande) {
        EntityManager entityManager = getEntityManager();
        
        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(ligneCommande);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }
    
    public List<LigneCommande> getByCommande(long commandeId){
        EntityManager entityManager = getEntityManager();
        TypedQuery<LigneCommande> query = entityManager.createQuery("from LigneCommande lc where lc.idCommande = :commandeId", LigneCommande.class);
        query.setParameter("commandeId", commandeId);
        return query.getResultList();
    }

}
