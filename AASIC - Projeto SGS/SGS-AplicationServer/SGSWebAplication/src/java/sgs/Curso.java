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

public class Curso {
	public Curso() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Curso))
			return false;
		Curso curso = (Curso)aObj;
		if ((getCodigo() != null && !getCodigo().equals(curso.getCodigo())) || (getCodigo() == null && curso.getCodigo() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getCodigo() == null ? 0 : getCodigo().hashCode());
		return hashcode;
	}
	
	private String Codigo;
	
	private String Nome;
	
	private int Duracao;
	
	private String Descricao;
	
	public void setNome(String value) {
		this.Nome = value;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setDuracao(int value) {
		this.Duracao = value;
	}
	
	public int getDuracao() {
		return Duracao;
	}
	
	public void setDescricao(String value) {
		this.Descricao = value;
	}
	
	public String getDescricao() {
		return Descricao;
	}
	
	public void setCodigo(String value) {
		this.Codigo = value;
	}
	
	public String getCodigo() {
		return Codigo;
	}
	
	public String getORMID() {
		return getCodigo();
	}
	
	public String toString() {
		return String.valueOf(getCodigo());
	}
	
}
