package tablas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class principal {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipseLinkPersistenceUnit");
	private static EntityManager manager = factory.createEntityManager();
		
	public static void main(String[] args) {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			Solucion sol = new Solucion(11,"hola","oc");
			manager.persist(sol);
			manager.persist(new Muestra(32,"dejate","de sierra",sol)); 
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		manager.close();
		factory.close();
	}
}
