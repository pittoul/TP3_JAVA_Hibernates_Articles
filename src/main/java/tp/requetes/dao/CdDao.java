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
import tp.requetes.hibernates_tp03_model.Cd;

/**
 *
 * @author Bruno
 */
public class CdDao extends GenericDao{
    
 public Cd insert(Cd cd) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();
        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(cd);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return cd;
    }

   /**
    * 
    * @return 
    */
    public List<Cd> findAll() {
        return getEntityManager().createQuery("from cd", Cd.class).getResultList();
    }

    /**
     * Finds a type by its id.
     *
     * @param id
     * @return The matching type, otherwise null.
     */
    public Cd findById(long id) {
        return getEntityManager().find(Cd.class, id);
    }

    public Cd updateStyle(Cd cd) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(cd);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return cd;
    }

    public void deleteCd(Cd cd) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(cd);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }   
}
