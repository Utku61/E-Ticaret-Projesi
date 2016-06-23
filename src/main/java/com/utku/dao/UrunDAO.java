package com.utku.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.utku.model.Urun;

public class UrunDAO implements GenericDao<Urun,Integer>{

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
	public void persist(Urun entity) {
		getCurrentSession().save(entity);
		
	}

	@Override
	public void update(Urun entity) {
		getCurrentSession().update(entity);
		
	}

	@Override
	public Urun findById(Integer id) {
		Urun urun = getCurrentSession().get(Urun.class, id);
		return urun;
	}

	@Override
	public void delete(Urun entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Urun> findAll() {
//		List<Urun> urunler = (List<Urun>) getCurrentSession().createQuery("from Urun u").list();
//		return urunler;
		return (List<Urun>) currentSession.createCriteria(Urun.class).list();
		
	}

	@Override
	public void deleteAll() {
		List<Urun> entityList = findAll();
		for (Urun entity : entityList) {
			delete(entity);
		}
		
	
}
	}