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

public class Utilizador {
	public Utilizador() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Utilizador))
			return false;
		Utilizador utilizador = (Utilizador)aObj;
		if ((getEmail() != null && !getEmail().equals(utilizador.getEmail())) || (getEmail() == null && utilizador.getEmail() != null))
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
	
	private int Idade;
	
	private String Numero;
	
	private String Senha;
	
	private char Genero;
	
	public void setNome(String value) {
		this.Nome = value;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setIdade(int value) {
		this.Idade = value;
	}
	
	public int getIdade() {
		return Idade;
	}
	
	public void setNumero(String value) {
		this.Numero = value;
	}
	
	public String getNumero() {
		return Numero;
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
	
	public void setSenha(String value) {
		this.Senha = value;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setGenero(char value) {
		this.Genero = value;
	}
	
	public char getGenero() {
		return Genero;
	}
	
	public String toString() {
		return String.valueOf(getEmail());
	}
	
}
