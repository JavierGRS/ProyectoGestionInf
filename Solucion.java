package tablas;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Solucion
 *
 */
@Entity

public class Solucion implements Serializable {

	   
	@Id
	private int ID;
	private String Solución;
	private String Uso;
	private static final long serialVersionUID = 1L;

	public Solucion() {
		super();
	}   
	
	public Solucion(int iD, String solución, String uso) {
		super();
		ID = iD;
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
	
   
}
