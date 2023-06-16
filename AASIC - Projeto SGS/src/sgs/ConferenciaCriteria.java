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

public class ConferenciaCriteria extends AbstractORMCriteria {
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
	
	public ConferenciaCriteria(Criteria criteria) {
		super(criteria);
		Codigo = new StringExpression("Codigo", this);
		salaId = new StringExpression("sala.Codigo", this);
		sala = new AssociationExpression("sala", this);
		HoraInicio = new LongExpression("HoraInicio", this);
		HoraFim = new LongExpression("HoraFim", this);
		Nome = new StringExpression("Nome", this);
		inscritos = new CollectionExpression("ORM_Inscritos", this);
		Livre = new BooleanExpression("Livre", this);
		Descrição = new StringExpression("Descrição", this);
		Orador = new StringExpression("Orador", this);
		Tema = new StringExpression("Tema", this);
	}
	
	public ConferenciaCriteria(PersistentSession session) {
		this(session.createCriteria(Conferencia.class));
	}
	
	public ConferenciaCriteria() throws PersistentException {
		this(sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession());
	}
	
	public sgs.UtilizadorCriteria createInscritosCriteria() {
		return new sgs.UtilizadorCriteria(createCriteria("ORM_Inscritos"));
	}
	
	public SalaCriteria createSalaCriteria() {
		return new SalaCriteria(createCriteria("sala"));
	}
	
	public Conferencia uniqueConferencia() {
		return (Conferencia) super.uniqueResult();
	}
	
	public Conferencia[] listConferencia() {
		java.util.List list = super.list();
		return (Conferencia[]) list.toArray(new Conferencia[list.size()]);
	}
}

