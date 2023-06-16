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

public class SalaDAO {
	public static Sala loadSalaByORMID(String Codigo) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadSalaByORMID(session, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala getSalaByORMID(String Codigo) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getSalaByORMID(session, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala loadSalaByORMID(String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadSalaByORMID(session, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala getSalaByORMID(String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return getSalaByORMID(session, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala loadSalaByORMID(PersistentSession session, String Codigo) throws PersistentException {
		try {
			return (Sala) session.load(sgs.Sala.class, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala getSalaByORMID(PersistentSession session, String Codigo) throws PersistentException {
		try {
			return (Sala) session.get(sgs.Sala.class, Codigo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala loadSalaByORMID(PersistentSession session, String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sala) session.load(sgs.Sala.class, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala getSalaByORMID(PersistentSession session, String Codigo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sala) session.get(sgs.Sala.class, Codigo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySala(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return querySala(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySala(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return querySala(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala[] listSalaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listSalaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala[] listSalaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return listSalaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySala(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Sala as Sala");
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
	
	public static List querySala(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Sala as Sala");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sala", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala[] listSalaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySala(session, condition, orderBy);
			return (Sala[]) list.toArray(new Sala[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala[] listSalaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySala(session, condition, orderBy, lockMode);
			return (Sala[]) list.toArray(new Sala[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala loadSalaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadSalaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala loadSalaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return loadSalaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala loadSalaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sala[] salas = listSalaByQuery(session, condition, orderBy);
		if (salas != null && salas.length > 0)
			return salas[0];
		else
			return null;
	}
	
	public static Sala loadSalaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sala[] salas = listSalaByQuery(session, condition, orderBy, lockMode);
		if (salas != null && salas.length > 0)
			return salas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSalaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateSalaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSalaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
			return iterateSalaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSalaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Sala as Sala");
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
	
	public static java.util.Iterator iterateSalaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sgs.Sala as Sala");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sala", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala createSala() {
		return new sgs.Sala();
	}
	
	public static boolean save(sgs.Sala sala) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().saveObject(sala);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sgs.Sala sala) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().deleteObject(sala);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sgs.Sala sala) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().refresh(sala);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sgs.Sala sala) throws PersistentException {
		try {
			sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().evict(sala);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sala loadSalaByCriteria(SalaCriteria salaCriteria) {
		Sala[] salas = listSalaByCriteria(salaCriteria);
		if(salas == null || salas.length == 0) {
			return null;
		}
		return salas[0];
	}
	
	public static Sala[] listSalaByCriteria(SalaCriteria salaCriteria) {
		return salaCriteria.listSala();
	}
}
