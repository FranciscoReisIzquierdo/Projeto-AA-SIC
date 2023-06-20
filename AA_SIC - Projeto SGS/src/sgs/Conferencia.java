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

public class Conferencia extends sgs.Evento {
	public Conferencia() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == sgs.ORMConstants.KEY_CONFERENCIA_INSCRITOS) {
			return ORM_inscritos;
		}
		else if (key == sgs.ORMConstants.KEY_CONFERENCIA_PRESENTES) {
			return ORM_presentes;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_inscritos = new java.util.HashSet();
	
	private boolean Livre;
	
	private String Descrição;
	
	private String Orador;
	
	private String Tema;
	
	private java.util.Set ORM_presentes = new java.util.HashSet();
	
	public void setLivre(boolean value) {
		this.Livre = value;
	}
	
	public boolean getLivre() {
		return Livre;
	}
	
	public void setDescrição(String value) {
		this.Descrição = value;
	}
	
	public String getDescrição() {
		return Descrição;
	}
	
	public void setOrador(String value) {
		this.Orador = value;
	}
	
	public String getOrador() {
		return Orador;
	}
	
	public void setTema(String value) {
		this.Tema = value;
	}
	
	public String getTema() {
		return Tema;
	}
	
	private void setORM_Inscritos(java.util.Set value) {
		this.ORM_inscritos = value;
	}
	
	private java.util.Set getORM_Inscritos() {
		return ORM_inscritos;
	}
	
	public final sgs.UtilizadorSetCollection inscritos = new sgs.UtilizadorSetCollection(this, _ormAdapter, sgs.ORMConstants.KEY_CONFERENCIA_INSCRITOS, sgs.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Presentes(java.util.Set value) {
		this.ORM_presentes = value;
	}
	
	private java.util.Set getORM_Presentes() {
		return ORM_presentes;
	}
	
	public final sgs.UtilizadorSetCollection presentes = new sgs.UtilizadorSetCollection(this, _ormAdapter, sgs.ORMConstants.KEY_CONFERENCIA_PRESENTES, sgs.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
