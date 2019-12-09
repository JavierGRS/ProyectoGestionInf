package tablas;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: tRol
 *
 */
@Entity

public class tRol implements Serializable {

	   
	public tRol(String rolName, String rolDes, boolean admin) {
		super();
		this.rolName = rolName;
		this.rolDes = rolDes;
		this.admin = admin;
	}

	@Id
	private String rolName;
	@Column(nullable = false)
	private String rolDes;
	private boolean admin;
	private static final long serialVersionUID = 1L;

	public tRol() {
		super();
	}   

	public String getRolName() {
		return this.rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}   
	public String getRolDes() {
		return this.rolDes;
	}

	public void setRolDes(String rolDes) {
		this.rolDes = rolDes;
	}   
	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
   
}
