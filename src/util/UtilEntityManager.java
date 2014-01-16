package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilEntityManager {
	
	protected EntityManager entityManager;
	
	public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MidiaEntityFactory");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
 
        return entityManager;
    }

}
