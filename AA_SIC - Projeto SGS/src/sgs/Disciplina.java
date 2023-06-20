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

public class Disciplina {
	public Disciplina() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Disciplina))
			return false;
		Disciplina disciplina = (Disciplina)aObj;
		if ((getCodigo() != null && !getCodigo().equals(disciplina.getCodigo())) || (getCodigo() == null && disciplina.getCodigo() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getCodigo() == null ? 0 : getCodigo().hashCode());
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == sgs.ORMConstants.KEY_DISCIPLINA_INSCRITOS) {
			return ORM_inscritos;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == sgs.ORMConstants.KEY_DISCIPLINA_CURSO) {
			this.curso = (sgs.Curso) owner;
		}
		
		else if (key == sgs.ORMConstants.KEY_DISCIPLINA_DOCENTE) {
			this.docente = (sgs.Docente) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private String Codigo;
	
	private sgs.Docente docente;
	
	public sgs.Curso curso;
	
	private String Nome;
	
	private String Descricao;
	
	private int CargaHoraria;
	
	private java.util.Set ORM_inscritos = new java.util.HashSet();
	
	public void setNome(String value) {
		this.Nome = value;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setDescricao(String value) {
		this.Descricao = value;
	}
	
	public String getDescricao() {
		return Descricao;
	}
	
	public void setCargaHoraria(int value) {
		this.CargaHoraria = value;
	}
	
	public int getCargaHoraria() {
		return CargaHoraria;
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
	
	public void setCurso(sgs.Curso value) {
		this.curso = value;
	}
	
	public sgs.Curso getCurso() {
		return curso;
	}
	
	public void setDocente(sgs.Docente value) {
		this.docente = value;
	}
	
	public sgs.Docente getDocente() {
		return docente;
	}
	
	private void setORM_Inscritos(java.util.Set value) {
		this.ORM_inscritos = value;
	}
	
	private java.util.Set getORM_Inscritos() {
		return ORM_inscritos;
	}
	
	public final sgs.AlunoSetCollection inscritos = new sgs.AlunoSetCollection(this, _ormAdapter, sgs.ORMConstants.KEY_DISCIPLINA_INSCRITOS, sgs.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getCodigo());
	}
	
}
