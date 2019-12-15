package tablas;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Solucion
 *
 */
@Entity

public class Solucion implements Serializable {

	   
	@Id
	@GeneratedValue
	private int ID;
	private String Solución;
	private String Uso;
	private static final long serialVersionUID = 1L;

	public Solucion() {
		super();
	}   
	
	public Solucion(String solución, String uso) {
		super();
		Solución = solución;
		Uso = uso;
	}
	
	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}   
	public String getSolución() {
		return this.Solución;
	}

	public void setSolución(String Solución) {
		this.Solución = Solución;
	}   
	public String getUso() {
		return this.Uso;
	}

	public void setUso(String Uso) {
		this.Uso = Uso;
	}

	public static List<Solucion> ListaSolucion() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipseLinkPersistenceUnit");
		EntityManager manager = factory.createEntityManager();
		List<Solucion> resultList = manager.createQuery("SELECT A FROM  Solucion A", Solucion.class)
				.getResultList();
		manager.close();
		factory.close();
		return resultList;
	}
	
   
}
