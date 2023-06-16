/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Francisco Izquierdo(Universidade do Minho)
 * License Type: Academic
 */
package sgs;

public class Administrador {
	public Administrador() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Administrador))
			return false;
		Administrador administrador = (Administrador)aObj;
		if ((getEmail() != null && !getEmail().equals(administrador.getEmail())) || (getEmail() == null && administrador.getEmail() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getEmail() == null ? 0 : getEmail().hashCode());
		return hashcode;
	}
	
	private String Email;
	
	private String Nome;
	
	private String Senha;
	
	public void setNome(String value) {
		this.Nome = value;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setSenha(String value) {
		this.Senha = value;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setEmail(String value) {
		this.Email = value;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getORMID() {
		return getEmail();
	}
	
	public String toString() {
		return String.valueOf(getEmail());
	}
	
}
