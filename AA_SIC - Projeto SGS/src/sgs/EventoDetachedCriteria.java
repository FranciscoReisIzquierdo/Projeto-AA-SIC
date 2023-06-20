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

public class EventoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression Codigo;
	public final StringExpression salaId;
	public final AssociationExpression sala;
	public final LongExpression HoraInicio;
	public final LongExpression HoraFim;
	public final StringExpression Nome;
	
	public EventoDetachedCriteria() {
		super(sgs.Evento.class, sgs.EventoCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		salaId = new StringExpression("sala.Codigo", this.getDetachedCriteria());
		sala = new AssociationExpression("sala", this.getDetachedCriteria());
		HoraInicio = new LongExpression("HoraInicio", this.getDetachedCriteria());
		HoraFim = new LongExpression("HoraFim", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
	}
	
	public EventoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.EventoCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		salaId = new StringExpression("sala.Codigo", this.getDetachedCriteria());
		sala = new AssociationExpression("sala", this.getDetachedCriteria());
		HoraInicio = new LongExpression("HoraInicio", this.getDetachedCriteria());
		HoraFim = new LongExpression("HoraFim", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
	}
	
	public SalaDetachedCriteria createSalaCriteria() {
		return new SalaDetachedCriteria(createCriteria("sala"));
	}
	
	public Evento uniqueEvento(PersistentSession session) {
		return (Evento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Evento[] listEvento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Evento[]) list.toArray(new Evento[list.size()]);
	}
}

