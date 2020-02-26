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
import tp.requetes.hibernates_tp03_model.Livre;

/**
 *
 * @author Bruno
 */
public class LivreDao extends GenericDao{
    public Livre insert(Livre livre) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(livre);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return livre;
    }

    /**
     * Finds all types.
     *
     * @return A list containing all the types.
     */
    public List<Livre> findAll() {
        return getEntityManager().createQuery("from livre order by number", Livre.class).getResultList();
    }

    /**
     * Finds a type by its id.
     *
     * @param id
     * @return The matching type, otherwise null.
     */
    public Livre findById(long id) {
        return getEntityManager().find(Livre.class, id);
    }

    public Livre updateStyle(Livre livre) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(livre);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return livre;
    }

    public void deleteLivre(Livre livre) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(livre);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }
    
}
