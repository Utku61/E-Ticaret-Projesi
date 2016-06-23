package com.utku.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.utku.model.AltAltKategori;
import com.utku.model.Urun;

public class AltAltKategoriDAO implements GenericDao<AltAltKategori,Integer>{

	private Session currentSession;
	private Transaction currentTransaction;
	
	public Session openCurrentSession() {
//		currentSession = getSessionFactory().openSession();
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
//		currentSession = getSessionFactory().openSession();
		currentSession = HibernateUtil.getSessionFactory().openSession();
		currentTransaction =  currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() 
 {
		currentTransaction.commit();
		currentSession.close();
	}
	
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

	
	public void persist(AltAltKategori entity) {
		getCurrentSession().save(entity);
	}

	public void update(AltAltKategori entity) {
		getCurrentSession().update(entity);
	}

	public AltAltKategori findById(Integer id) {
		AltAltKategori altkategori =  getCurrentSession().get(AltAltKategori.class, id);
		return altkategori; 
	}

	public void delete(AltAltKategori entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<AltAltKategori> findAll() {
//		List<AltAltKategori> altkategoriler = (List<AltAltKategori>) getCurrentSession().createQuery("from AltAltKategori a").list();
//		return altkategoriler;
		return (List<AltAltKategori>) currentSession.createCriteria(AltAltKategori.class).list();
	}

	public void deleteAll() {
		List<AltAltKategori> entityList = findAll();
		for (AltAltKategori entity : entityList) {
			delete(entity);
		}
	}

	
	}

	

