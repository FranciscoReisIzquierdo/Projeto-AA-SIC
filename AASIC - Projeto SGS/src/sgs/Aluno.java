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

public class Aluno extends sgs.Utilizador {
	public Aluno() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == sgs.ORMConstants.KEY_ALUNO_DISCIPLINAS) {
			return ORM_disciplinas;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == sgs.ORMConstants.KEY_ALUNO_CURSO) {
			this.curso = (sgs.Curso) owner;
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
	
	public sgs.Curso curso;
	
	private int Ano;
	
	private java.util.Set ORM_disciplinas = new java.util.HashSet();
	
	public void setAno(int value) {
		this.Ano = value;
	}
	
	public int getAno() {
		return Ano;
	}
	
	public void setCurso(sgs.Curso value) {
		this.curso = value;
	}
	
	public sgs.Curso getCurso() {
		return curso;
	}
	
	private void setORM_Disciplinas(java.util.Set value) {
		this.ORM_disciplinas = value;
	}
	
	private java.util.Set getORM_Disciplinas() {
		return ORM_disciplinas;
	}
	
	public final sgs.DisciplinaSetCollection disciplinas = new sgs.DisciplinaSetCollection(this, _ormAdapter, sgs.ORMConstants.KEY_ALUNO_DISCIPLINAS, sgs.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
