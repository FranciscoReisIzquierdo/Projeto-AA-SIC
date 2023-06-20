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

public class DocenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression Email;
	public final StringExpression Nome;
	public final IntegerExpression Idade;
	public final StringExpression Numero;
	public final StringExpression Senha;
	public final CharacterExpression Genero;
	public final StringExpression Departamento;
	
	public DocenteDetachedCriteria() {
		super(sgs.Docente.class, sgs.DocenteCriteria.class);
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Idade = new IntegerExpression("Idade", this.getDetachedCriteria());
		Numero = new StringExpression("Numero", this.getDetachedCriteria());
		Senha = new StringExpression("Senha", this.getDetachedCriteria());
		Genero = new CharacterExpression("Genero", this.getDetachedCriteria());
		Departamento = new StringExpression("Departamento", this.getDetachedCriteria());
	}
	
	public DocenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.DocenteCriteria.class);
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Idade = new IntegerExpression("Idade", this.getDetachedCriteria());
		Numero = new StringExpression("Numero", this.getDetachedCriteria());
		Senha = new StringExpression("Senha", this.getDetachedCriteria());
		Genero = new CharacterExpression("Genero", this.getDetachedCriteria());
		Departamento = new StringExpression("Departamento", this.getDetachedCriteria());
	}
	
	public Docente uniqueDocente(PersistentSession session) {
		return (Docente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Docente[] listDocente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Docente[]) list.toArray(new Docente[list.size()]);
	}
}

