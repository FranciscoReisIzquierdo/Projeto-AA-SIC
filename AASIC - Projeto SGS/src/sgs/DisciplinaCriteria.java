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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DisciplinaCriteria extends AbstractORMCriteria {
	public final StringExpression Codigo;
	public final StringExpression docenteId;
	public final AssociationExpression docente;
	public final StringExpression cursoId;
	public final AssociationExpression curso;
	public final StringExpression Nome;
	public final StringExpression Descricao;
	public final IntegerExpression CargaHoraria;
	public final CollectionExpression inscritos;
	
	public DisciplinaCriteria(Criteria criteria) {
		super(criteria);
		Codigo = new StringExpression("Codigo", this);
		docenteId = new StringExpression("docente.Email", this);
		docente = new AssociationExpression("docente", this);
		cursoId = new StringExpression("curso.Codigo", this);
		curso = new AssociationExpression("curso", this);
		Nome = new StringExpression("Nome", this);
		Descricao = new StringExpression("Descricao", this);
		CargaHoraria = new IntegerExpression("CargaHoraria", this);
		inscritos = new CollectionExpression("ORM_Inscritos", this);
	}
	
	public DisciplinaCriteria(PersistentSession session) {
		this(session.createCriteria(Disciplina.class));
	}
	
	public DisciplinaCriteria() throws PersistentException {
		this(sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession());
	}
	
	public DocenteCriteria createDocenteCriteria() {
		return new DocenteCriteria(createCriteria("docente"));
	}
	
	public CursoCriteria createCursoCriteria() {
		return new CursoCriteria(createCriteria("curso"));
	}
	
	public sgs.AlunoCriteria createInscritosCriteria() {
		return new sgs.AlunoCriteria(createCriteria("ORM_Inscritos"));
	}
	
	public Disciplina uniqueDisciplina() {
		return (Disciplina) super.uniqueResult();
	}
	
	public Disciplina[] listDisciplina() {
		java.util.List list = super.list();
		return (Disciplina[]) list.toArray(new Disciplina[list.size()]);
	}
}

