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

public abstract class Evento {
	public Evento() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Evento))
			return false;
		Evento evento = (Evento)aObj;
		if ((getCodigo() != null && !getCodigo().equals(evento.getCodigo())) || (getCodigo() == null && evento.getCodigo() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getCodigo() == null ? 0 : getCodigo().hashCode());
		return hashcode;
	}
	
	private String Codigo;
	
	public sgs.Sala sala;
	
	private long HoraInicio;
	
	private long HoraFim;
	
	private String Nome;
	
	public void setHoraInicio(long value) {
		this.HoraInicio = value;
	}
	
	public long getHoraInicio() {
		return HoraInicio;
	}
	
	public void setHoraFim(long value) {
		this.HoraFim = value;
	}
	
	public long getHoraFim() {
		return HoraFim;
	}
	
	public void setNome(String value) {
		this.Nome = value;
	}
	
	public String getNome() {
		return Nome;
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
	
	public void setSala(sgs.Sala value) {
		this.sala = value;
	}
	
	public sgs.Sala getSala() {
		return sala;
	}
	
	public String toString() {
		return String.valueOf(getCodigo());
	}
	
}
