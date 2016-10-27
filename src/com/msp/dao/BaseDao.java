package com.msp.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * BaseDao.java is the base level DAO implementation that holds all the common attributes/methods required by the subclass DAOs.
 * 
 * @author ez7g5mp
 *
 */
public abstract class BaseDao {

	protected SessionFactory sessionFactory;
	
	public BaseDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	public Object getById(Class clazz, Long id) {
		Session session = currentSession();
		return session.get(clazz, id);
	}
	
	
	public void save(Object object, boolean useCurrentTx) throws HibernateException {
		if (useCurrentTx) {
			Session hs = currentSession();
			hs.saveOrUpdate(object);
		}
		else {
			saveAndCommit(object);
		}
	}
	

	private void saveAndCommit(Object object) throws HibernateException {
		Session hs = currentSession();
		Transaction trans = hs.beginTransaction();

		hs.saveOrUpdate(object);
		trans.commit();
	}

	
	public void delete(Object object) throws HibernateException {
		Session hs = currentSession();
		hs.delete(object);
	}
	
	public void close() {
		currentSession().close();
	}
}
