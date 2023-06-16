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

public class CursoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression Codigo;
	public final StringExpression Nome;
	public final IntegerExpression Duracao;
	public final StringExpression Descricao;
	
	public CursoDetachedCriteria() {
		super(sgs.Curso.class, sgs.CursoCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Duracao = new IntegerExpression("Duracao", this.getDetachedCriteria());
		Descricao = new StringExpression("Descricao", this.getDetachedCriteria());
	}
	
	public CursoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.CursoCriteria.class);
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Duracao = new IntegerExpression("Duracao", this.getDetachedCriteria());
		Descricao = new StringExpression("Descricao", this.getDetachedCriteria());
	}
	
	public Curso uniqueCurso(PersistentSession session) {
		return (Curso) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Curso[] listCurso(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Curso[]) list.toArray(new Curso[list.size()]);
	}
}

