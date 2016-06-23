package com.utku.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.utku.model.Siparis;
import com.utku.model.Urun;

public class SiparisDAO implements GenericDao<Siparis,Integer>{

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
	public void persist(Siparis entity) {
		getCurrentSession().save(entity);
		
	}

	@Override
	public void update(Siparis entity) {
		getCurrentSession().update(entity);
		
	}

	@Override
	public Siparis findById(Integer id) {
		Siparis siparis =  getCurrentSession().get(Siparis.class, id);
		return siparis; 
	}

	@Override
	public void delete(Siparis entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Siparis> findAll() {
//		List<Siparis> siparisler = (List<Siparis>) getCurrentSession().createQuery("from Siparis s").list();
//		return siparisler;
		return (List<Siparis>) currentSession.createCriteria(Siparis.class).list();
	}

	@Override
	public void deleteAll() {
		List<Siparis> entityList = findAll();
		for (Siparis entity : entityList) {
			delete(entity);
		}
		
	}

	
	
	
	}

	

