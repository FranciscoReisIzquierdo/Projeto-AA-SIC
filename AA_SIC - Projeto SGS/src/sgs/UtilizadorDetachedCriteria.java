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

public class UtilizadorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression Email;
	public final StringExpression Nome;
	public final IntegerExpression Idade;
	public final StringExpression Numero;
	public final StringExpression Senha;
	public final CharacterExpression Genero;
	
	public UtilizadorDetachedCriteria() {
		super(sgs.Utilizador.class, sgs.UtilizadorCriteria.class);
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Idade = new IntegerExpression("Idade", this.getDetachedCriteria());
		Numero = new StringExpression("Numero", this.getDetachedCriteria());
		Senha = new StringExpression("Senha", this.getDetachedCriteria());
		Genero = new CharacterExpression("Genero", this.getDetachedCriteria());
	}
	
	public UtilizadorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.UtilizadorCriteria.class);
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Idade = new IntegerExpression("Idade", this.getDetachedCriteria());
		Numero = new StringExpression("Numero", this.getDetachedCriteria());
		Senha = new StringExpression("Senha", this.getDetachedCriteria());
		Genero = new CharacterExpression("Genero", this.getDetachedCriteria());
	}
	
	public Utilizador uniqueUtilizador(PersistentSession session) {
		return (Utilizador) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Utilizador[] listUtilizador(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Utilizador[]) list.toArray(new Utilizador[list.size()]);
	}
}

