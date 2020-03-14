package br.com.domain.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateUtil {
	private static final EntityManagerFactory EM_FACTORY =
			Persistence.createEntityManagerFactory("todo");	

	public static EntityManager getEntityManager() {
		return EM_FACTORY.createEntityManager();
	}
}
