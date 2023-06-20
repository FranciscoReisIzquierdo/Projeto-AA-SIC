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

public class DisciplinaDAO {
	public static Disciplina loadDisciplinaByORMID(String Codigo) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadDisciplinaByORMID(session, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina getDisciplinaByORMID(String Codigo) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getDisciplinaByORMID(session, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByORMID(String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadDisciplinaByORMID(session, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina getDisciplinaByORMID(String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getDisciplinaByORMID(session, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByORMID(PersistentSession session, String Codigo) throws PersistentException {
		try {
			return (Disciplina) session.load(sgs.Disciplina.class, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina getDisciplinaByORMID(PersistentSession session, String Codigo) throws PersistentException {
		try {
			return (Disciplina) session.get(sgs.Disciplina.class, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByORMID(PersistentSession session, String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Disciplina) session.load(sgs.Disciplina.class, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina getDisciplinaByORMID(PersistentSession session, String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Disciplina) session.get(sgs.Disciplina.class, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDisciplina(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return queryDisciplina(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDisciplina(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return queryDisciplina(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina[] listDisciplinaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listDisciplinaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina[] listDisciplinaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listDisciplinaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDisciplina(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Disciplina as Disciplina");
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
	
	public static List queryDisciplina(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Disciplina as Disciplina");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Disciplina", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina[] listDisciplinaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDisciplina(session, condition, orderBy);
			return (Disciplina[]) list.toArray(new Disciplina[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina[] listDisciplinaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDisciplina(session, condition, orderBy, lockMode);
			return (Disciplina[]) list.toArray(new Disciplina[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadDisciplinaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadDisciplinaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Disciplina[] disciplinas = listDisciplinaByQuery(session, condition, orderBy);
		if (disciplinas != null && disciplinas.length > 0)
			return disciplinas[0];
		else
			return null;
	}
	
	public static Disciplina loadDisciplinaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Disciplina[] disciplinas = listDisciplinaByQuery(session, condition, orderBy, lockMode);
		if (disciplinas != null && disciplinas.length > 0)
			return disciplinas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDisciplinaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateDisciplinaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDisciplinaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateDisciplinaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDisciplinaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Disciplina as Disciplina");
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
	
	public static java.util.Iterator iterateDisciplinaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Disciplina as Disciplina");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Disciplina", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina createDisciplina() {
		return new sgs.Disciplina();
	}
	
	public static boolean save(sgs.Disciplina disciplina) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().saveObject(disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sgs.Disciplina disciplina) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().deleteObject(disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sgs.Disciplina disciplina) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().refresh(disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sgs.Disciplina disciplina) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().evict(disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByCriteria(DisciplinaCriteria disciplinaCriteria) {
		Disciplina[] disciplinas = listDisciplinaByCriteria(disciplinaCriteria);
		if(disciplinas == null || disciplinas.length == 0) {
			return null;
		}
		return disciplinas[0];
	}
	
	public static Disciplina[] listDisciplinaByCriteria(DisciplinaCriteria disciplinaCriteria) {
		return disciplinaCriteria.listDisciplina();
	}
}
