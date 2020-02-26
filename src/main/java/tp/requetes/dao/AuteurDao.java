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
import tp.requetes.hibernates_tp03_model.Auteur;

/**
 *
 * @author Bruno
 */
public class AuteurDao extends GenericDao{
    
    
    public Auteur insert(Auteur auteur) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(auteur);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return auteur;
    }

    /**
     * Finds all types.
     *
     * @return A list containing all the types.
     */
    public List<Auteur> findAll() {
        return getEntityManager().createQuery("from auteur order by number", Auteur.class).getResultList();
    }

    /**
     * Finds a type by its id.
     *
     * @param id
     * @return The matching type, otherwise null.
     */
    public Auteur findById(long id) {
        return getEntityManager().find(Auteur.class, id);
    }

    public Auteur updateStyle(Auteur auteur) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(auteur);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return auteur;
    }

    public void deleteAuteur(Auteur auteur) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(auteur);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }
}
