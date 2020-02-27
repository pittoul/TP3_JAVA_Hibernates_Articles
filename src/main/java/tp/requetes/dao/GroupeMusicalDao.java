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
import tp.requetes.hibernates_tp03_model.GroupeMusical;

/**
 *
 * @author Bruno
 */
public class GroupeMusicalDao extends GenericDao{
    
   public GroupeMusical insert(GroupeMusical groupeMusical) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(groupeMusical);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return groupeMusical;
    }

    /**
     * Finds all types.
     *
     * @return A list containing all the types.
     */
    public List<GroupeMusical> findAll() {
        return getEntityManager().createQuery("from groupeMusical", GroupeMusical.class).getResultList();
    }

    /**
     * Finds a type by its id.
     *
     * @param id
     * @return The matching type, otherwise null.
     */
    public GroupeMusical findById(long id) {
        return getEntityManager().find(GroupeMusical.class, id);
    }

    public GroupeMusical updateStyle(GroupeMusical groupeMusical) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(groupeMusical);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return groupeMusical;
    }

    public void deleteGroupeMusical(GroupeMusical groupeMusical) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(groupeMusical);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }
    
}
