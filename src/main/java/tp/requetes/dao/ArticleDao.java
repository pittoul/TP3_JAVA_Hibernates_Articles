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
import tp.requetes.hibernates_tp03_model.Article;

/**
 *
 * @author Bruno
 */
public class ArticleDao extends GenericDao{
    
    public Article insert(Article article) throws AlreadyExistsException {
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(article);
        DatabaseHelper.commitTransactionAndClose(entityManager);
        return article;
    }

    /**
     * Finds all types.
     *
     * @return A list containing all the types.
     */
    public List<Article> findAll() {
        return getEntityManager().createQuery("from article order by number", Article.class).getResultList();
    }

    /**
     * Finds a type by its id.
     *
     * @param id
     * @return The matching type, otherwise null.
     */
    public Article findById(long id) {
        return getEntityManager().find(Article.class, id);
    }

    public Article updateStyle(Article article) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.merge(article);
        DatabaseHelper.commitTransactionAndClose(entityManager);

        return article;
    }

    public void deleteArticle(Article article) {
        
        EntityManager entityManager = getEntityManager();

        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(article);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }

    
}
