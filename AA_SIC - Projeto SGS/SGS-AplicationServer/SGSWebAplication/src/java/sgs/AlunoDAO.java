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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class AlunoDAO {
	public static Aluno loadAlunoByORMID(String Email) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadAlunoByORMID(session, Email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno getAlunoByORMID(String Email) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getAlunoByORMID(session, Email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByORMID(String Email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadAlunoByORMID(session, Email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno getAlunoByORMID(String Email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getAlunoByORMID(session, Email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByORMID(PersistentSession session, String Email) throws PersistentException {
		try {
			return (Aluno) session.load(sgs.Aluno.class, Email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno getAlunoByORMID(PersistentSession session, String Email) throws PersistentException {
		try {
			return (Aluno) session.get(sgs.Aluno.class, Email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByORMID(PersistentSession session, String Email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Aluno) session.load(sgs.Aluno.class, Email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno getAlunoByORMID(PersistentSession session, String Email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Aluno) session.get(sgs.Aluno.class, Email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAluno(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return queryAluno(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAluno(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return queryAluno(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno[] listAlunoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listAlunoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno[] listAlunoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listAlunoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAluno(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Aluno as Aluno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAluno(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Aluno as Aluno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Aluno", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno[] listAlunoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAluno(session, condition, orderBy);
			return (Aluno[]) list.toArray(new Aluno[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno[] listAlunoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAluno(session, condition, orderBy, lockMode);
			return (Aluno[]) list.toArray(new Aluno[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadAlunoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadAlunoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Aluno[] alunos = listAlunoByQuery(session, condition, orderBy);
		if (alunos != null && alunos.length > 0)
			return alunos[0];
		else
			return null;
	}
	
	public static Aluno loadAlunoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Aluno[] alunos = listAlunoByQuery(session, condition, orderBy, lockMode);
		if (alunos != null && alunos.length > 0)
			return alunos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAlunoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateAlunoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlunoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateAlunoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlunoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Aluno as Aluno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlunoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Aluno as Aluno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Aluno", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno createAluno() {
		return new sgs.Aluno();
	}
	
	public static boolean save(sgs.Aluno aluno) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().saveObject(aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sgs.Aluno aluno) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().deleteObject(aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sgs.Aluno aluno) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().refresh(aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sgs.Aluno aluno) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().evict(aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByCriteria(AlunoCriteria alunoCriteria) {
		Aluno[] alunos = listAlunoByCriteria(alunoCriteria);
		if(alunos == null || alunos.length == 0) {
			return null;
		}
		return alunos[0];
	}
	
	public static Aluno[] listAlunoByCriteria(AlunoCriteria alunoCriteria) {
		return alunoCriteria.listAluno();
	}
}
