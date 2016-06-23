package com.utku.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory=buildSessionFactory();;
	
	private static SessionFactory buildSessionFactory() {
		try{
			//return new Configuration().configure().buildSessionFactory();
			return new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void shutdown(){
		getSessionFactory().close();
	}
}
