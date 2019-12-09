package tablas;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: tPermiso
 *
 */
@IdClass(tPermisoPK.class)
@Entity

public class tPermiso implements Serializable {

	   
	@Id
	private tRol rolName;   
	@Id
	private String pantalla;
	private boolean acceso;
	private boolean insertar;
	private boolean modificar;
	private boolean borrar;
	private static final long serialVersionUID = 1L;

	public tPermiso() {
		super();
	}   
	public tRol getRolName() {
		return this.rolName;
	}

	public void setRolName(tRol rolName) {
		this.rolName = rolName;
	}   
	public String getPantalla() {
		return this.pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}   
	public boolean getAcceso() {
		return this.acceso;
	}

	public void setAcceso(boolean acceso) {
		this.acceso = acceso;
	}   
	public boolean getInsertar() {
		return this.insertar;
	}

	public void setInsertar(boolean insertar) {
		this.insertar = insertar;
	}   
	public boolean getModificar() {
		return this.modificar;
	}

	public void setModificar(boolean modificar) {
		this.modificar = modificar;
	}   
	public boolean getBorrar() {
		return this.borrar;
	}

	public void setBorrar(boolean borrar) {
		this.borrar = borrar;
	}
   
}
