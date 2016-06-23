package com.utku.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.utku.model.Musteri;
import com.utku.model.Urun;

public class MusteriDAO implements GenericDao<Musteri,Integer>{

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

	@Override
	public void persist(Musteri entity) {
		getCurrentSession().save(entity);
		
	}

	@Override
	public void update(Musteri entity) {
		getCurrentSession().update(entity);
		
	}

	@Override
	public Musteri findById(Integer id) {
		Musteri musteri =  getCurrentSession().get(Musteri.class, id);
		return musteri;
	}

	@Override
	public void delete(Musteri entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Musteri> findAll() {
//		List<Musteri> musteriler = (List<Musteri>) getCurrentSession().createQuery("from Musteri m").list();
//		return musteriler;
		return (List<Musteri>) currentSession.createCriteria(Musteri.class).list();
	}

	@Override
	public void deleteAll() {
		List<Musteri> entityList = findAll();
		for (Musteri entity : entityList) {
			delete(entity);
		}
		
	}

	
	

	
	
	
	
	}