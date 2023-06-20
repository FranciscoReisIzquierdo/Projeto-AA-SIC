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

public class SalaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression Codigo;
	public final IntegerExpression Capacidade;
	public final StringExpression Localizacao;
	public final IntegerExpression Lotacao;
	public final CollectionExpression eventos;
	
	public SalaDetachedCriteria() {
		super(sgs.Sala.class, sgs.SalaCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		Capacidade = new IntegerExpression("Capacidade", this.getDetachedCriteria());
		Localizacao = new StringExpression("Localizacao", this.getDetachedCriteria());
		Lotacao = new IntegerExpression("Lotacao", this.getDetachedCriteria());
		eventos = new CollectionExpression("ORM_Eventos", this.getDetachedCriteria());
	}
	
	public SalaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.SalaCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		Capacidade = new IntegerExpression("Capacidade", this.getDetachedCriteria());
		Localizacao = new StringExpression("Localizacao", this.getDetachedCriteria());
		Lotacao = new IntegerExpression("Lotacao", this.getDetachedCriteria());
		eventos = new CollectionExpression("ORM_Eventos", this.getDetachedCriteria());
	}
	
	public sgs.EventoDetachedCriteria createEventosCriteria() {
		return new sgs.EventoDetachedCriteria(createCriteria("ORM_Eventos"));
	}
	
	public Sala uniqueSala(PersistentSession session) {
		return (Sala) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sala[] listSala(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sala[]) list.toArray(new Sala[list.size()]);
	}
}

