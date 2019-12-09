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
			tRol rol = new tRol("oc","ben10 ya",true);
			manager.persist(rol);
			manager.persist(new tUsuario("Amancio","Ortiga",rol));
			Solucion sol = new Solucion(13,"hola","oc");
			manager.persist(sol);
			manager.persist(new Muestra(35,"dejate","de sierra",sol)); 
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		manager.close();
		factory.close();
	}
}
