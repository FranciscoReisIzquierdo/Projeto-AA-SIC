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

public class AlunoCriteria extends AbstractORMCriteria {
	public final StringExpression Email;
	public final StringExpression Nome;
	public final IntegerExpression Idade;
	public final StringExpression Numero;
	public final StringExpression Senha;
	public final CharacterExpression Genero;
	public final StringExpression cursoId;
	public final AssociationExpression curso;
	public final IntegerExpression Ano;
	public final CollectionExpression disciplinas;
	
	public AlunoCriteria(Criteria criteria) {
		super(criteria);
		Email = new StringExpression("Email", this);
		Nome = new StringExpression("Nome", this);
		Idade = new IntegerExpression("Idade", this);
		Numero = new StringExpression("Numero", this);
		Senha = new StringExpression("Senha", this);
		Genero = new CharacterExpression("Genero", this);
		cursoId = new StringExpression("curso.Codigo", this);
		curso = new AssociationExpression("curso", this);
		Ano = new IntegerExpression("Ano", this);
		disciplinas = new CollectionExpression("ORM_Disciplinas", this);
	}
	
	public AlunoCriteria(PersistentSession session) {
		this(session.createCriteria(Aluno.class));
	}
	
	public AlunoCriteria() throws PersistentException {
		this(sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession());
	}
	
	public CursoCriteria createCursoCriteria() {
		return new CursoCriteria(createCriteria("curso"));
	}
	
	public sgs.DisciplinaCriteria createDisciplinasCriteria() {
		return new sgs.DisciplinaCriteria(createCriteria("ORM_Disciplinas"));
	}
	
	public Aluno uniqueAluno() {
		return (Aluno) super.uniqueResult();
	}
	
	public Aluno[] listAluno() {
		java.util.List list = super.list();
		return (Aluno[]) list.toArray(new Aluno[list.size()]);
	}
}

