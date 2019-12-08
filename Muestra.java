package tablas;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tablas.Solucion;

/**
 * Entity implementation class for Entity: Muestra
 *
 */
@Entity

public class Muestra implements Serializable {

	   
	@Id
	private int ID;
	private String NIF_Paciente;
	private String Cultivo;
	private Solucion Solucion;
	private static final long serialVersionUID = 1L;

	public Muestra() {
		super();
	}   
	
	public Muestra(int iD, String nIF_Paciente, String cultivo, tablas.Solucion solucion) {
		super();
		ID = iD;
		NIF_Paciente = nIF_Paciente;
		Cultivo = cultivo;
		Solucion = solucion;
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}   
	public String getNIF_Paciente() {
		return this.NIF_Paciente;
	}

	public void setNIF_Paciente(String NIF_Paciente) {
		this.NIF_Paciente = NIF_Paciente;
	}   
	public String getCultivo() {
		return this.Cultivo;
	}

	public void setCultivo(String Cultivo) {
		this.Cultivo = Cultivo;
	}   
	public Solucion getSolucion() {
		return this.Solucion;
	}

	public void setSolucion(Solucion Solucion) {
		this.Solucion = Solucion;
	}
   
}
