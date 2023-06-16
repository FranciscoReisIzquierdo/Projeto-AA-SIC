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

public class DocenteDAO {
	public static Docente loadDocenteByORMID(String Email) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadDocenteByORMID(session, Email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente getDocenteByORMID(String Email) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getDocenteByORMID(session, Email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente loadDocenteByORMID(String Email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadDocenteByORMID(session, Email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente getDocenteByORMID(String Email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getDocenteByORMID(session, Email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente loadDocenteByORMID(PersistentSession session, String Email) throws PersistentException {
		try {
			return (Docente) session.load(sgs.Docente.class, Email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente getDocenteByORMID(PersistentSession session, String Email) throws PersistentException {
		try {
			return (Docente) session.get(sgs.Docente.class, Email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente loadDocenteByORMID(PersistentSession session, String Email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Docente) session.load(sgs.Docente.class, Email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente getDocenteByORMID(PersistentSession session, String Email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Docente) session.get(sgs.Docente.class, Email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDocente(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return queryDocente(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDocente(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return queryDocente(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente[] listDocenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listDocenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente[] listDocenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listDocenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDocente(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Docente as Docente");
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
	
	public static List queryDocente(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Docente as Docente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Docente", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente[] listDocenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDocente(session, condition, orderBy);
			return (Docente[]) list.toArray(new Docente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente[] listDocenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDocente(session, condition, orderBy, lockMode);
			return (Docente[]) list.toArray(new Docente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente loadDocenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadDocenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente loadDocenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadDocenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente loadDocenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Docente[] docentes = listDocenteByQuery(session, condition, orderBy);
		if (docentes != null && docentes.length > 0)
			return docentes[0];
		else
			return null;
	}
	
	public static Docente loadDocenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Docente[] docentes = listDocenteByQuery(session, condition, orderBy, lockMode);
		if (docentes != null && docentes.length > 0)
			return docentes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDocenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateDocenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDocenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateDocenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDocenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Docente as Docente");
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
	
	public static java.util.Iterator iterateDocenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Docente as Docente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Docente", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente createDocente() {
		return new sgs.Docente();
	}
	
	public static boolean save(sgs.Docente docente) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().saveObject(docente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sgs.Docente docente) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().deleteObject(docente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sgs.Docente docente) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().refresh(docente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sgs.Docente docente) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().evict(docente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Docente loadDocenteByCriteria(DocenteCriteria docenteCriteria) {
		Docente[] docentes = listDocenteByCriteria(docenteCriteria);
		if(docentes == null || docentes.length == 0) {
			return null;
		}
		return docentes[0];
	}
	
	public static Docente[] listDocenteByCriteria(DocenteCriteria docenteCriteria) {
		return docenteCriteria.listDocente();
	}
}
