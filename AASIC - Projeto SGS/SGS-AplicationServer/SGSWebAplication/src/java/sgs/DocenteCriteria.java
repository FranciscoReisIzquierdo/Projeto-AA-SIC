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

public class DocenteCriteria extends AbstractORMCriteria {
	public final StringExpression Email;
	public final StringExpression Nome;
	public final IntegerExpression Idade;
	public final StringExpression Numero;
	public final StringExpression Senha;
	public final CharacterExpression Genero;
	public final StringExpression Departamento;
	
	public DocenteCriteria(Criteria criteria) {
		super(criteria);
		Email = new StringExpression("Email", this);
		Nome = new StringExpression("Nome", this);
		Idade = new IntegerExpression("Idade", this);
		Numero = new StringExpression("Numero", this);
		Senha = new StringExpression("Senha", this);
		Genero = new CharacterExpression("Genero", this);
		Departamento = new StringExpression("Departamento", this);
	}
	
	public DocenteCriteria(PersistentSession session) {
		this(session.createCriteria(Docente.class));
	}
	
	public DocenteCriteria() throws PersistentException {
		this(sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession());
	}
	
	public Docente uniqueDocente() {
		return (Docente) super.uniqueResult();
	}
	
	public Docente[] listDocente() {
		java.util.List list = super.list();
		return (Docente[]) list.toArray(new Docente[list.size()]);
	}
}

