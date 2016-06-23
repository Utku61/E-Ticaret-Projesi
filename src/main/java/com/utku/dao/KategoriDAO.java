package com.utku.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.utku.model.Kategori;
import com.utku.model.Urun;

public class KategoriDAO implements GenericDao<Kategori, Integer> {

	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {
		//currentSession = getSessionFactory().openSession();
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		//currentSession = getSessionFactory().openSession();
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
//
//	private static SessionFactory getSessionFactory() {
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//
//		return sessionFactory;
//	}

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
	public void persist(Kategori entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Kategori entity) {
		getCurrentSession().update(entity);

	}

	@Override
	public Kategori findById(Integer id) {
		Kategori kategori = getCurrentSession().get(Kategori.class, id);
		return kategori;
	}

	@Override
	public void delete(Kategori entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kategori> findAll() {
//		List<Kategori> kategoriler = (List<Kategori>) getCurrentSession().createQuery("from Kategori k").list();
//		return kategoriler;
		return (List<Kategori>) currentSession.createCriteria(Kategori.class).list();
	}

	@Override
	public void deleteAll() {
		List<Kategori> entityList = findAll();
		for (Kategori entity : entityList) {
			delete(entity);
		}

	}

}
