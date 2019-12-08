package Tablas;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: tUsuario
 *
 */
@Entity

public class tUsuario implements Serializable {

	   
	public tUsuario(String nif, String password, tRol rolName) {
		super();
		this.nif = nif;
		this.password = password;
		this.rolName = rolName;
	}

	@Id
	private String nif;
	private String password;
	private tRol rolName;
	private static final long serialVersionUID = 1L;

	public tUsuario() {
		super();
	} 
	
	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public tRol getRolName() {
		return this.rolName;
	}

	public void setRolName(tRol rolName) {
		this.rolName = rolName;
	}
   
}
