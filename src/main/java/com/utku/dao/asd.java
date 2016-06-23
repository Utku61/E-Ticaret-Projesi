package com.utku.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.utku.model.Admin;

public class asd {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Admin admin=new Admin();
		admin.setIsim("Utku Malkocoglu");
		admin.setK_adi("utku");
		admin.setSifre("utku6161");
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();
		System.out.println(admin.toString());

	}

}
