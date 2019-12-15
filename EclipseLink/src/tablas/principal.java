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
			tRol r = new tRol("Usuario","El usuario NO podrá insertar ni borrar ninguna muestra, pero si modificar una ya existente.",false);
			manager.persist(r);
			manager.persist(new tPermiso(r,"Muestras",true,false,false,true));
			
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		manager.close();
		factory.close();
	}
}
