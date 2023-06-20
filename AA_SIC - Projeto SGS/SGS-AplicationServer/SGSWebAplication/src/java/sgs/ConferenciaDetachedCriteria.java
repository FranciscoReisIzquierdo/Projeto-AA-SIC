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

public class ConferenciaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression Codigo;
	public final StringExpression salaId;
	public final AssociationExpression sala;
	public final LongExpression HoraInicio;
	public final LongExpression HoraFim;
	public final StringExpression Nome;
	public final CollectionExpression inscritos;
	public final BooleanExpression Livre;
	public final StringExpression Descrição;
	public final StringExpression Orador;
	public final StringExpression Tema;
	public final CollectionExpression presentes;
	
	public ConferenciaDetachedCriteria() {
		super(sgs.Conferencia.class, sgs.ConferenciaCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		salaId = new StringExpression("sala.Codigo", this.getDetachedCriteria());
		sala = new AssociationExpression("sala", this.getDetachedCriteria());
		HoraInicio = new LongExpression("HoraInicio", this.getDetachedCriteria());
		HoraFim = new LongExpression("HoraFim", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		inscritos = new CollectionExpression("ORM_Inscritos", this.getDetachedCriteria());
		Livre = new BooleanExpression("Livre", this.getDetachedCriteria());
		Descrição = new StringExpression("Descrição", this.getDetachedCriteria());
		Orador = new StringExpression("Orador", this.getDetachedCriteria());
		Tema = new StringExpression("Tema", this.getDetachedCriteria());
		presentes = new CollectionExpression("ORM_Presentes", this.getDetachedCriteria());
	}
	
	public ConferenciaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.ConferenciaCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		salaId = new StringExpression("sala.Codigo", this.getDetachedCriteria());
		sala = new AssociationExpression("sala", this.getDetachedCriteria());
		HoraInicio = new LongExpression("HoraInicio", this.getDetachedCriteria());
		HoraFim = new LongExpression("HoraFim", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		inscritos = new CollectionExpression("ORM_Inscritos", this.getDetachedCriteria());
		Livre = new BooleanExpression("Livre", this.getDetachedCriteria());
		Descrição = new StringExpression("Descrição", this.getDetachedCriteria());
		Orador = new StringExpression("Orador", this.getDetachedCriteria());
		Tema = new StringExpression("Tema", this.getDetachedCriteria());
		presentes = new CollectionExpression("ORM_Presentes", this.getDetachedCriteria());
	}
	
	public sgs.UtilizadorDetachedCriteria createInscritosCriteria() {
		return new sgs.UtilizadorDetachedCriteria(createCriteria("ORM_Inscritos"));
	}
	
	public sgs.UtilizadorDetachedCriteria createPresentesCriteria() {
		return new sgs.UtilizadorDetachedCriteria(createCriteria("ORM_Presentes"));
	}
	
	public SalaDetachedCriteria createSalaCriteria() {
		return new SalaDetachedCriteria(createCriteria("sala"));
	}
	
	public Conferencia uniqueConferencia(PersistentSession session) {
		return (Conferencia) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Conferencia[] listConferencia(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Conferencia[]) list.toArray(new Conferencia[list.size()]);
	}
}

