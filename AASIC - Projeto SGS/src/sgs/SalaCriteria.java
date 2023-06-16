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

public class SalaCriteria extends AbstractORMCriteria {
	public final StringExpression Codigo;
	public final IntegerExpression Capacidade;
	public final StringExpression Localizacao;
	public final IntegerExpression Lotacao;
	public final CollectionExpression eventos;
	
	public SalaCriteria(Criteria criteria) {
		super(criteria);
		Codigo = new StringExpression("Codigo", this);
		Capacidade = new IntegerExpression("Capacidade", this);
		Localizacao = new StringExpression("Localizacao", this);
		Lotacao = new IntegerExpression("Lotacao", this);
		eventos = new CollectionExpression("ORM_Eventos", this);
	}
	
	public SalaCriteria(PersistentSession session) {
		this(session.createCriteria(Sala.class));
	}
	
	public SalaCriteria() throws PersistentException {
		this(sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession());
	}
	
	public sgs.EventoCriteria createEventosCriteria() {
		return new sgs.EventoCriteria(createCriteria("ORM_Eventos"));
	}
	
	public Sala uniqueSala() {
		return (Sala) super.uniqueResult();
	}
	
	public Sala[] listSala() {
		java.util.List list = super.list();
		return (Sala[]) list.toArray(new Sala[list.size()]);
	}
}

