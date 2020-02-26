package tp.requetes.dao;

import javax.persistence.EntityManager;
import tp.requetes.databaseHelper.DatabaseHelper;


public class GenericDao {
	
	private EntityManager entityManager;
	
	public GenericDao() {
		this.entityManager = DatabaseHelper.createEntityManager();
	}
	
	protected EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = DatabaseHelper.createEntityManager();
		}
		return entityManager;
	}
}
