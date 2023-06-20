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

public class ConferenciaDAO {
	public static Conferencia loadConferenciaByORMID(String Codigo) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadConferenciaByORMID(session, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia getConferenciaByORMID(String Codigo) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getConferenciaByORMID(session, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia loadConferenciaByORMID(String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadConferenciaByORMID(session, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia getConferenciaByORMID(String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getConferenciaByORMID(session, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia loadConferenciaByORMID(PersistentSession session, String Codigo) throws PersistentException {
		try {
			return (Conferencia) session.load(sgs.Conferencia.class, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia getConferenciaByORMID(PersistentSession session, String Codigo) throws PersistentException {
		try {
			return (Conferencia) session.get(sgs.Conferencia.class, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia loadConferenciaByORMID(PersistentSession session, String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Conferencia) session.load(sgs.Conferencia.class, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia getConferenciaByORMID(PersistentSession session, String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Conferencia) session.get(sgs.Conferencia.class, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConferencia(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return queryConferencia(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConferencia(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return queryConferencia(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia[] listConferenciaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listConferenciaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia[] listConferenciaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listConferenciaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConferencia(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Conferencia as Conferencia");
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
	
	public static List queryConferencia(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Conferencia as Conferencia");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Conferencia", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia[] listConferenciaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryConferencia(session, condition, orderBy);
			return (Conferencia[]) list.toArray(new Conferencia[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia[] listConferenciaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryConferencia(session, condition, orderBy, lockMode);
			return (Conferencia[]) list.toArray(new Conferencia[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia loadConferenciaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadConferenciaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia loadConferenciaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadConferenciaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia loadConferenciaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Conferencia[] conferencias = listConferenciaByQuery(session, condition, orderBy);
		if (conferencias != null && conferencias.length > 0)
			return conferencias[0];
		else
			return null;
	}
	
	public static Conferencia loadConferenciaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Conferencia[] conferencias = listConferenciaByQuery(session, condition, orderBy, lockMode);
		if (conferencias != null && conferencias.length > 0)
			return conferencias[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateConferenciaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateConferenciaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateConferenciaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateConferenciaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateConferenciaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Conferencia as Conferencia");
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
	
	public static java.util.Iterator iterateConferenciaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Conferencia as Conferencia");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Conferencia", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia createConferencia() {
		return new sgs.Conferencia();
	}
	
	public static boolean save(sgs.Conferencia conferencia) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().saveObject(conferencia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sgs.Conferencia conferencia) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().deleteObject(conferencia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sgs.Conferencia conferencia) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().refresh(conferencia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sgs.Conferencia conferencia) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().evict(conferencia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Conferencia loadConferenciaByCriteria(ConferenciaCriteria conferenciaCriteria) {
		Conferencia[] conferencias = listConferenciaByCriteria(conferenciaCriteria);
		if(conferencias == null || conferencias.length == 0) {
			return null;
		}
		return conferencias[0];
	}
	
	public static Conferencia[] listConferenciaByCriteria(ConferenciaCriteria conferenciaCriteria) {
		return conferenciaCriteria.listConferencia();
	}
}
