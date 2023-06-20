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

public class AlunoDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public AlunoDetachedCriteria() {
		super(sgs.Aluno.class, sgs.AlunoCriteria.class);
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Idade = new IntegerExpression("Idade", this.getDetachedCriteria());
		Numero = new StringExpression("Numero", this.getDetachedCriteria());
		Senha = new StringExpression("Senha", this.getDetachedCriteria());
		Genero = new CharacterExpression("Genero", this.getDetachedCriteria());
		cursoId = new StringExpression("curso.Codigo", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
		Ano = new IntegerExpression("Ano", this.getDetachedCriteria());
		disciplinas = new CollectionExpression("ORM_Disciplinas", this.getDetachedCriteria());
	}
	
	public AlunoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sgs.AlunoCriteria.class);
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Nome = new StringExpression("Nome", this.getDetachedCriteria());
		Idade = new IntegerExpression("Idade", this.getDetachedCriteria());
		Numero = new StringExpression("Numero", this.getDetachedCriteria());
		Senha = new StringExpression("Senha", this.getDetachedCriteria());
		Genero = new CharacterExpression("Genero", this.getDetachedCriteria());
		cursoId = new StringExpression("curso.Codigo", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
		Ano = new IntegerExpression("Ano", this.getDetachedCriteria());
		disciplinas = new CollectionExpression("ORM_Disciplinas", this.getDetachedCriteria());
	}
	
	public CursoDetachedCriteria createCursoCriteria() {
		return new CursoDetachedCriteria(createCriteria("curso"));
	}
	
	public sgs.DisciplinaDetachedCriteria createDisciplinasCriteria() {
		return new sgs.DisciplinaDetachedCriteria(createCriteria("ORM_Disciplinas"));
	}
	
	public Aluno uniqueAluno(PersistentSession session) {
		return (Aluno) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Aluno[] listAluno(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Aluno[]) list.toArray(new Aluno[list.size()]);
	}
}

