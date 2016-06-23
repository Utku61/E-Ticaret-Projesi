package com.utku.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.utku.model.Iletisim;
import com.utku.model.Urun;

public class IletisimDAO implements GenericDao<Iletisim,Integer>{

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

	
	public void persist(Iletisim entity) {
		getCurrentSession().save(entity);
	}

	public void update(Iletisim entity) {
		getCurrentSession().update(entity);
	}

	public Iletisim findById(Integer id) {
		Iletisim Iletisim =  getCurrentSession().get(Iletisim.class, id);
		return Iletisim; 
	}

	public void delete(Iletisim entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Iletisim> findAll() {
//		List<Iletisim> Iletisimler = (List<Iletisim>) getCurrentSession().createQuery("from Iletisim s").list();
//		return Iletisimler;
		return (List<Iletisim>) currentSession.createCriteria(Iletisim.class).list();
	}

	public void deleteAll() {
		List<Iletisim> entityList = findAll();
		for (Iletisim entity : entityList) {
			delete(entity);
		}
	}

	
	}

	

