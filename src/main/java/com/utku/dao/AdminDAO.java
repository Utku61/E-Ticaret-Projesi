package com.utku.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utku.model.Admin;

public class AdminDAO implements GenericDao<Admin, Integer> {

	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {
		// currentSession = getSessionFactory().openSession();
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		// currentSession = getSessionFactory().openSession();
		currentSession = HibernateUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	/*private static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		return sessionFactory;
	}*/

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	@Override
	public void persist(Admin entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Admin entity) {
		getCurrentSession().update(entity);

	}

	@Override
	public Admin findById(Integer id) {
		Admin admin = getCurrentSession().get(Admin.class, id);
		return admin;
	}

	@Override
	public void delete(Admin entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAll() {
		List<Admin> adminler = (List<Admin>) getCurrentSession().createQuery("from Admin a").list();
		return adminler;
		//return (List<Admin>) currentSession.createCriteria(Admin.class).list();
	}

	@Override
	public void deleteAll() {
		List<Admin> entityList = findAll();
		for (Admin entity : entityList) {
			delete(entity);
		}

	}

}
