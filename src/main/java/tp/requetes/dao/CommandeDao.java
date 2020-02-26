/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.requetes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import tp.requete.exception.AlreadyExistsException;
import tp.requetes.databaseHelper.DatabaseHelper;
import tp.requetes.hibernates_tp03_model.Commande;

/**
 *
 * @author Bruno
 */
public class CommandeDao extends GenericDao{
    public Commande insert(Commande commande) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(commande);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return commande;
    }

    /**
     * Finds all types.
     *
     * @return A list containing all the types.
     */
    public List<Commande> findAll() {
        return getEntityManager().createQuery("from commande order by number", Commande.class).getResultList();
    }

    /**
     * Finds a type by its id.
     *
     * @param id
     * @return The matching type, otherwise null.
     */
    public Commande findById(long id) {
        return getEntityManager().find(Commande.class, id);
    }

    public Commande updateStyle(Commande commande) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(commande);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return commande;
    }

    public void deleteCommande(Commande commande) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(commande);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }
    
}
