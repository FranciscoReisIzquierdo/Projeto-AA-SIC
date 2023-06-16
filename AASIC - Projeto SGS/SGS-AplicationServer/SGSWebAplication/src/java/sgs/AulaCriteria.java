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

public class AulaCriteria extends AbstractORMCriteria {
	public final StringExpression Codigo;
	public final StringExpression salaId;
	public final AssociationExpression sala;
	public final LongExpression HoraInicio;
	public final LongExpression HoraFim;
	public final StringExpression Nome;
	public final CollectionExpression presentes;
	public final StringExpression disciplinaId;
	public final AssociationExpression disciplina;
	public final StringExpression Turno;
	public final CollectionExpression inscritos;
	public final StringExpression docenteId;
	public final AssociationExpression docente;
	
	public AulaCriteria(Criteria criteria) {
		super(criteria);
		Codigo = new StringExpression("Codigo", this);
		salaId = new StringExpression("sala.Codigo", this);
		sala = new AssociationExpression("sala", this);
		HoraInicio = new LongExpression("HoraInicio", this);
		HoraFim = new LongExpression("HoraFim", this);
		Nome = new StringExpression("Nome", this);
		presentes = new CollectionExpression("ORM_Presentes", this);
		disciplinaId = new StringExpression("disciplina.Codigo", this);
		disciplina = new AssociationExpression("disciplina", this);
		Turno = new StringExpression("Turno", this);
		inscritos = new CollectionExpression("ORM_Inscritos", this);
		docenteId = new StringExpression("docente.Email", this);
		docente = new AssociationExpression("docente", this);
	}
	
	public AulaCriteria(PersistentSession session) {
		this(session.createCriteria(Aula.class));
	}
	
	public AulaCriteria() throws PersistentException {
		this(sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession());
	}
	
	public sgs.AlunoCriteria createPresentesCriteria() {
		return new sgs.AlunoCriteria(createCriteria("ORM_Presentes"));
	}
	
	public DisciplinaCriteria createDisciplinaCriteria() {
		return new DisciplinaCriteria(createCriteria("disciplina"));
	}
	
	public sgs.AlunoCriteria createInscritosCriteria() {
		return new sgs.AlunoCriteria(createCriteria("ORM_Inscritos"));
	}
	
	public DocenteCriteria createDocenteCriteria() {
		return new DocenteCriteria(createCriteria("docente"));
	}
	
	public SalaCriteria createSalaCriteria() {
		return new SalaCriteria(createCriteria("sala"));
	}
	
	public Aula uniqueAula() {
		return (Aula) super.uniqueResult();
	}
	
	public Aula[] listAula() {
		java.util.List list = super.list();
		return (Aula[]) list.toArray(new Aula[list.size()]);
	}
}

