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

public class AdministradorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression Email;
	public final StringExpression Nome;
	public final StringExpression Senha;
	
	public AdministradorDetachedCriteria() {
		super(sgs.Administrador.class, sgs.AdministradorCriteria.class);
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Senha = new StringExpression("Senha", this.getDetachedCriteria());
	}
	
	public AdministradorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.AdministradorCriteria.class);
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Senha = new StringExpression("Senha", this.getDetachedCriteria());
	}
	
	public Administrador uniqueAdministrador(PersistentSession session) {
		return (Administrador) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Administrador[] listAdministrador(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Administrador[]) list.toArray(new Administrador[list.size()]);
	}
}

