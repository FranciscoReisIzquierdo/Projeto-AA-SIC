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

public class EventoCriteria extends AbstractORMCriteria {
	public final StringExpression Codigo;
	public final StringExpression salaId;
	public final AssociationExpression sala;
	public final LongExpression HoraInicio;
	public final LongExpression HoraFim;
	public final StringExpression Nome;
	
	public EventoCriteria(Criteria criteria) {
		super(criteria);
		Codigo = new StringExpression("Codigo", this);
		salaId = new StringExpression("sala.Codigo", this);
		sala = new AssociationExpression("sala", this);
		HoraInicio = new LongExpression("HoraInicio", this);
		HoraFim = new LongExpression("HoraFim", this);
		Nome = new StringExpression("Nome", this);
	}
	
	public EventoCriteria(PersistentSession session) {
		this(session.createCriteria(Evento.class));
	}
	
	public EventoCriteria() throws PersistentException {
		this(sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession());
	}
	
	public SalaCriteria createSalaCriteria() {
		return new SalaCriteria(createCriteria("sala"));
	}
	
	public Evento uniqueEvento() {
		return (Evento) super.uniqueResult();
	}
	
	public Evento[] listEvento() {
		java.util.List list = super.list();
		return (Evento[]) list.toArray(new Evento[list.size()]);
	}
}

