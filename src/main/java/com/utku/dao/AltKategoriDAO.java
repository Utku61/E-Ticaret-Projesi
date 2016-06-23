package com.utku.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.utku.model.AltKategori;
import com.utku.model.Urun;

public class AltKategoriDAO implements GenericDao<AltKategori,Integer>{

	private Session currentSession;
	private Transaction currentTransaction;
	
	public Session openCurrentSession() {
		//currentSession = getSessionFactory().openSession();
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

	
	public void persist(AltKategori entity) {
		getCurrentSession().save(entity);
	}

	public void update(AltKategori entity) {
		getCurrentSession().update(entity);
	}

	public AltKategori findById(Integer id) {
		AltKategori altkategori =  getCurrentSession().get(AltKategori.class, id);
		return altkategori; 
	}

	public void delete(AltKategori entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<AltKategori> findAll() {
//		List<AltKategori> altkategoriler = (List<AltKategori>) getCurrentSession().createQuery("from AltKategori a").list();
//		return altkategoriler;
		return (List<AltKategori>) currentSession.createCriteria(AltKategori.class).list();
	}

	public void deleteAll() {
		List<AltKategori> entityList = findAll();
		for (AltKategori entity : entityList) {
			delete(entity);
		}
	}

	
	}

	

