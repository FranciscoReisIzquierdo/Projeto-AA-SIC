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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DisciplinaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression Codigo;
	public final StringExpression docenteId;
	public final AssociationExpression docente;
	public final StringExpression cursoId;
	public final AssociationExpression curso;
	public final StringExpression Nome;
	public final StringExpression Descricao;
	public final IntegerExpression CargaHoraria;
	public final CollectionExpression inscritos;
	
	public DisciplinaDetachedCriteria() {
		super(sgs.Disciplina.class, sgs.DisciplinaCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		docenteId = new StringExpression("docente.Email", this.getDetachedCriteria());
		docente = new AssociationExpression("docente", this.getDetachedCriteria());
		cursoId = new StringExpression("curso.Codigo", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Descricao = new StringExpression("Descricao", this.getDetachedCriteria());
		CargaHoraria = new IntegerExpression("CargaHoraria", this.getDetachedCriteria());
		inscritos = new CollectionExpression("ORM_Inscritos", this.getDetachedCriteria());
	}
	
	public DisciplinaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.DisciplinaCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		docenteId = new StringExpression("docente.Email", this.getDetachedCriteria());
		docente = new AssociationExpression("docente", this.getDetachedCriteria());
		cursoId = new StringExpression("curso.Codigo", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Descricao = new StringExpression("Descricao", this.getDetachedCriteria());
		CargaHoraria = new IntegerExpression("CargaHoraria", this.getDetachedCriteria());
		inscritos = new CollectionExpression("ORM_Inscritos", this.getDetachedCriteria());
	}
	
	public DocenteDetachedCriteria createDocenteCriteria() {
		return new DocenteDetachedCriteria(createCriteria("docente"));
	}
	
	public CursoDetachedCriteria createCursoCriteria() {
		return new CursoDetachedCriteria(createCriteria("curso"));
	}
	
	public sgs.AlunoDetachedCriteria createInscritosCriteria() {
		return new sgs.AlunoDetachedCriteria(createCriteria("ORM_Inscritos"));
	}
	
	public Disciplina uniqueDisciplina(PersistentSession session) {
		return (Disciplina) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Disciplina[] listDisciplina(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Disciplina[]) list.toArray(new Disciplina[list.size()]);
	}
}

