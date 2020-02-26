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
import tp.requetes.hibernates_tp03_model.StyleMusical;

/**
 *
 * @author Bruno
 */
public class StyleMusicalDao extends GenericDao {

    public StyleMusical insert(StyleMusical style) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        StyleMusical existing = findByLibelle(style.getLibelle());
        if (existing != null) {
            throw new AlreadyExistsException("Le style nommé " + style.getLibelle() + " existe déjà.");
        }

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(style);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return style;
    }

    /**
     * Finds all types.
     *
     * @return A list containing all the types.
     */
    public List<StyleMusical> findAll() {
        return getEntityManager().createQuery("from StyleMusical order by number", StyleMusical.class).getResultList();
    }

    /**
     * Finds a type by its id.
     *
     * @param id
     * @return The matching type, otherwise null.
     */
    public StyleMusical findById(long id) {
        return getEntityManager().find(StyleMusical.class, id);
    }

    /**
     * Finds a type by its name.
     *
     * @param libelle
     * @return The matching type, otherwise null.
     */
    public StyleMusical findByLibelle(String libelle) {
        TypedQuery<StyleMusical> query = getEntityManager().createQuery("from StyleMusical where libelle = :name", StyleMusical.class);
        query.setParameter("name", libelle);
        return query.getSingleResult();
    }

    public StyleMusical updateStyle(StyleMusical style) {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(style);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return style;
    }

}
