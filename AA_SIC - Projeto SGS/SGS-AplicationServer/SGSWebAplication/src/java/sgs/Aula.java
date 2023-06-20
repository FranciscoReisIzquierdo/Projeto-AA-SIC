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

public class Aula extends sgs.Evento {
	public Aula() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == sgs.ORMConstants.KEY_AULA_PRESENTES) {
			return ORM_presentes;
		}
		else if (key == sgs.ORMConstants.KEY_AULA_INSCRITOS) {
			return ORM_inscritos;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_presentes = new java.util.HashSet();
	
	private sgs.Disciplina disciplina;
	
	private String Turno;
	
	private java.util.Set ORM_inscritos = new java.util.HashSet();
	
	public sgs.Docente docente;
	
	public void setTurno(String value) {
		this.Turno = value;
	}
	
	public String getTurno() {
		return Turno;
	}
	
	public void setDisciplina(sgs.Disciplina value) {
		this.disciplina = value;
	}
	
	public sgs.Disciplina getDisciplina() {
		return disciplina;
	}
	
	private void setORM_Presentes(java.util.Set value) {
		this.ORM_presentes = value;
	}
	
	private java.util.Set getORM_Presentes() {
		return ORM_presentes;
	}
	
	public final sgs.AlunoSetCollection presentes = new sgs.AlunoSetCollection(this, _ormAdapter, sgs.ORMConstants.KEY_AULA_PRESENTES, sgs.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Inscritos(java.util.Set value) {
		this.ORM_inscritos = value;
	}
	
	private java.util.Set getORM_Inscritos() {
		return ORM_inscritos;
	}
	
	public final sgs.AlunoSetCollection inscritos = new sgs.AlunoSetCollection(this, _ormAdapter, sgs.ORMConstants.KEY_AULA_INSCRITOS, sgs.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setDocente(sgs.Docente value) {
		this.docente = value;
	}
	
	public sgs.Docente getDocente() {
		return docente;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
