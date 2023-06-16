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

public class Sala {
	public Sala() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Sala))
			return false;
		Sala sala = (Sala)aObj;
		if ((getCodigo() != null && !getCodigo().equals(sala.getCodigo())) || (getCodigo() == null && sala.getCodigo() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getCodigo() == null ? 0 : getCodigo().hashCode());
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == sgs.ORMConstants.KEY_SALA_EVENTOS) {
			return ORM_eventos;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String Codigo;
	
	private int Capacidade;
	
	private String Localizacao;
	
	private int Lotacao = 0;
	
	private java.util.Set ORM_eventos = new java.util.HashSet();
	
	public void setCapacidade(int value) {
		this.Capacidade = value;
	}
	
	public int getCapacidade() {
		return Capacidade;
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
	
	public void setLocalizacao(String value) {
		this.Localizacao = value;
	}
	
	public String getLocalizacao() {
		return Localizacao;
	}
	
	public void setLotacao(int value) {
		this.Lotacao = value;
	}
	
	public int getLotacao() {
		return Lotacao;
	}
	
	private void setORM_Eventos(java.util.Set value) {
		this.ORM_eventos = value;
	}
	
	private java.util.Set getORM_Eventos() {
		return ORM_eventos;
	}
	
	public final sgs.EventoSetCollection eventos = new sgs.EventoSetCollection(this, _ormAdapter, sgs.ORMConstants.KEY_SALA_EVENTOS, sgs.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getCodigo());
	}
	
}
