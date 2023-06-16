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

public class AulaDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public AulaDetachedCriteria() {
		super(sgs.Aula.class, sgs.AulaCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		salaId = new StringExpression("sala.Codigo", this.getDetachedCriteria());
		sala = new AssociationExpression("sala", this.getDetachedCriteria());
		HoraInicio = new LongExpression("HoraInicio", this.getDetachedCriteria());
		HoraFim = new LongExpression("HoraFim", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		presentes = new CollectionExpression("ORM_Presentes", this.getDetachedCriteria());
		disciplinaId = new StringExpression("disciplina.Codigo", this.getDetachedCriteria());
		disciplina = new AssociationExpression("disciplina", this.getDetachedCriteria());
		Turno = new StringExpression("Turno", this.getDetachedCriteria());
		inscritos = new CollectionExpression("ORM_Inscritos", this.getDetachedCriteria());
		docenteId = new StringExpression("docente.Email", this.getDetachedCriteria());
		docente = new AssociationExpression("docente", this.getDetachedCriteria());
	}
	
	public AulaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.AulaCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		salaId = new StringExpression("sala.Codigo", this.getDetachedCriteria());
		sala = new AssociationExpression("sala", this.getDetachedCriteria());
		HoraInicio = new LongExpression("HoraInicio", this.getDetachedCriteria());
		HoraFim = new LongExpression("HoraFim", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		presentes = new CollectionExpression("ORM_Presentes", this.getDetachedCriteria());
		disciplinaId = new StringExpression("disciplina.Codigo", this.getDetachedCriteria());
		disciplina = new AssociationExpression("disciplina", this.getDetachedCriteria());
		Turno = new StringExpression("Turno", this.getDetachedCriteria());
		inscritos = new CollectionExpression("ORM_Inscritos", this.getDetachedCriteria());
		docenteId = new StringExpression("docente.Email", this.getDetachedCriteria());
		docente = new AssociationExpression("docente", this.getDetachedCriteria());
	}
	
	public sgs.AlunoDetachedCriteria createPresentesCriteria() {
		return new sgs.AlunoDetachedCriteria(createCriteria("ORM_Presentes"));
	}
	
	public DisciplinaDetachedCriteria createDisciplinaCriteria() {
		return new DisciplinaDetachedCriteria(createCriteria("disciplina"));
	}
	
	public sgs.AlunoDetachedCriteria createInscritosCriteria() {
		return new sgs.AlunoDetachedCriteria(createCriteria("ORM_Inscritos"));
	}
	
	public DocenteDetachedCriteria createDocenteCriteria() {
		return new DocenteDetachedCriteria(createCriteria("docente"));
	}
	
	public SalaDetachedCriteria createSalaCriteria() {
		return new SalaDetachedCriteria(createCriteria("sala"));
	}
	
	public Aula uniqueAula(PersistentSession session) {
		return (Aula) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Aula[] listAula(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Aula[]) list.toArray(new Aula[list.size()]);
	}
}

