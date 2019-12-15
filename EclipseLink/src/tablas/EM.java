package tablas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class EM {

	private static EntityManagerFactory factory ;
	private static EntityManager manager;
	
	
	public static  Query select(String consulta,Class<?> clase) {
		Query res;
		EM.createEM();
		res = manager.createQuery(consulta,clase);
		EM.closeEM();
		return res;
	}

	public void insert() {
		this.createEM();
		
		
		this.closeEM();
	}
	public void delete() {
		this.createEM();
		
		this.closeEM();
	}
	public void update() {
		this.createEM();
		
		this.closeEM();
	}
	
	private static void createEM() {
		factory = Persistence.createEntityManagerFactory("eclipseLinkPersistenceUnit");
		manager = factory.createEntityManager();
	}
	
	private static void closeEM() {
		manager.close();
		factory.close();
	}
	
	
	
	
	
	
	
	
	
}
