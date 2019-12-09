package tablas;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: tPermiso
 *
 */ 
public class tPermisoPK  implements Serializable {   
   
	         
	private String rolName;         
	private String pantalla;
	private static final long serialVersionUID = 1L;

	public tPermisoPK() {}

	

	public String getRolName() {
		return this.rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}
	

	public String getPantalla() {
		return this.pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof tPermisoPK)) {
			return false;
		}
		tPermisoPK other = (tPermisoPK) o;
		return true
			&& (getRolName() == null ? other.getRolName() == null : getRolName().equals(other.getRolName()))
			&& (getPantalla() == null ? other.getPantalla() == null : getPantalla().equals(other.getPantalla()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getRolName() == null ? 0 : getRolName().hashCode());
		result = prime * result + (getPantalla() == null ? 0 : getPantalla().hashCode());
		return result;
	}
   
   
}
