package com.utku.service;

import java.util.List;

import org.hibernate.Query;

import com.utku.dao.AdminDAO;

import com.utku.model.Admin;

public class AdminService {

	private static AdminDAO AdminDAO;

	public AdminService() {
		AdminDAO = new AdminDAO();
	}

	public void persist(Admin entity) {
		AdminDAO.openCurrentSessionwithTransaction();
		AdminDAO.persist(entity);
		AdminDAO.closeCurrentSessionwithTransaction();

	}

	public void update(Admin entity) {
		AdminDAO.openCurrentSessionwithTransaction();
		AdminDAO.update(entity);
		AdminDAO.closeCurrentSessionwithTransaction();

	}

	public Admin findById(int id) {
		AdminDAO.openCurrentSession();
		Admin admin = AdminDAO.findById(id);
		AdminDAO.closeCurrentSession();
		return admin;
	}

	public void delete(int id) {
		AdminDAO.openCurrentSessionwithTransaction();
		Admin admin = AdminDAO.findById(id);
		AdminDAO.delete(admin);
		AdminDAO.closeCurrentSessionwithTransaction();

	}

	public List<Admin> findAll() {
		AdminDAO.openCurrentSession();
		List<Admin> adminler = AdminDAO.findAll();
		AdminDAO.closeCurrentSession();
		return adminler;
	}

	public void deleteAll() {
		AdminDAO.openCurrentSessionwithTransaction();
		AdminDAO.deleteAll();
		AdminDAO.closeCurrentSessionwithTransaction();

	}

	public AdminDAO AdminDAO() {
		return AdminDAO;
	}

	public Admin adminGirisKontrol(String k_adi, String sifre) {
		System.out.println(k_adi + " " + sifre);
		Admin admin = new Admin();
		Query query = AdminDAO.openCurrentSession().createQuery("from Admin where k_adi = :eposta and sifre = :sifre");
		query.setParameter("eposta", k_adi);
		query.setParameter("sifre", sifre);
		@SuppressWarnings("unchecked")
		List<Admin> liste = query.list();
		AdminDAO.closeCurrentSession();
		if (liste.size() > 0) {
			admin.setId(liste.get(0).getId());
			admin.setIsim(liste.get(0).getIsim());
			admin.setK_adi(liste.get(0).getK_adi());
			admin.setSifre(liste.get(0).getSifre());
		} else {
			admin.setIsim("0");

		}
		System.out.println(admin.toString());

	
		return admin;
	}
}
