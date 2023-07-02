package br.com.aganda.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFCreator {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	private EMFCreator() {
	}
	
	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("AgendaDeTrabalho2UP");
			em = emf.createEntityManager();
		}
		return em;
	}
	
	public static void closeEntityManagerFactory() {
		if(emf != null && emf.isOpen()) {
			em.close();
			emf.close();
		}
	}
}
