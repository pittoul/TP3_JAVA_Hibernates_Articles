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
import tp.requetes.hibernates_tp03_model.Personne;

/**
 *
 * @author Bruno
 */
public class PersonneDao extends GenericDao {

    public Personne insert(Personne personne) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(personne);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return personne;
    }

    /**
     * Finds all types.
     *
     * @return A list containing all the types.
     */
    public List<Personne> findAll() {
        return getEntityManager().createQuery("from personne order by number", Personne.class).getResultList();
    }

    /**
     * Finds a type by its id.
     *
     * @param id
     * @return The matching type, otherwise null.
     */
    public Personne findById(long id) {
        return getEntityManager().find(Personne.class, id);
    }

    public Personne updateStyle(Personne personne) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(personne);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return personne;
    }

    public void deletePersonne(Personne personne) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(personne);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }

}
