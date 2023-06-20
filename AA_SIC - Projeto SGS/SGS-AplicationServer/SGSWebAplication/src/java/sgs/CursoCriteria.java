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

public class CursoCriteria extends AbstractORMCriteria {
	public final StringExpression Codigo;
	public final StringExpression Nome;
	public final IntegerExpression Duracao;
	public final StringExpression Descricao;
	
	public CursoCriteria(Criteria criteria) {
		super(criteria);
		Codigo = new StringExpression("Codigo", this);
		Nome = new StringExpression("Nome", this);
		Duracao = new IntegerExpression("Duracao", this);
		Descricao = new StringExpression("Descricao", this);
	}
	
	public CursoCriteria(PersistentSession session) {
		this(session.createCriteria(Curso.class));
	}
	
	public CursoCriteria() throws PersistentException {
		this(sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession());
	}
	
	public Curso uniqueCurso() {
		return (Curso) super.uniqueResult();
	}
	
	public Curso[] listCurso() {
		java.util.List list = super.list();
		return (Curso[]) list.toArray(new Curso[list.size()]);
	}
}

