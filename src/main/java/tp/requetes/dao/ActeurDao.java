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
import tp.requetes.hibernates_tp03_model.Acteur;

/**
 *
 * @author Bruno
 */
public class ActeurDao extends GenericDao {

    public Acteur findById(long id) {
        return getEntityManager().find(Acteur.class, id);
    }
    
    public Acteur insert(Acteur acteur) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(acteur);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return acteur;
    }
    
    /**
     * Finds all types.
     *
     * @return A list containing all the types.
     */
    public List<Acteur> findAll() {
        return getEntityManager().createQuery("from acteur order by number", Acteur.class).getResultList();
    }

 

    public Acteur updateStyle(Acteur acteur) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(acteur);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return acteur;
    }

    public void deleteActeur(Acteur acteur) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(acteur);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }

    
}
