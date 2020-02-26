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
import tp.requetes.hibernates_tp03_model.Realisateur;

/**
 *
 * @author Bruno
 */
public class RealisateurDao extends GenericDao{
    public Realisateur insert(Realisateur realisateur) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(realisateur);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return realisateur;
    }

    /**
     * Finds all types.
     *
     * @return A list containing all the types.
     */
    public List<Realisateur> findAll() {
        return getEntityManager().createQuery("from realisateur order by number", Realisateur.class).getResultList();
    }

    /**
     * Finds a type by its id.
     *
     * @param id
     * @return The matching type, otherwise null.
     */
    public Realisateur findById(long id) {
        return getEntityManager().find(Realisateur.class, id);
    }

    public Realisateur updateStyle(Realisateur realisateur) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(realisateur);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return realisateur;
    }

    public void deleteRealisateur(Realisateur realisateur) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(realisateur);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }
}
