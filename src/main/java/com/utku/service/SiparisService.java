package com.utku.service;

import java.util.List;

import com.utku.dao.SiparisDAO;
import com.utku.model.Siparis;

public class SiparisService {

	private static SiparisDAO SiparisDAO;

	public SiparisService() {
		SiparisDAO = new SiparisDAO();
	}

	public void persist(Siparis entity) {
		SiparisDAO.openCurrentSessionwithTransaction();
		SiparisDAO.persist(entity);
		SiparisDAO.closeCurrentSessionwithTransaction();

	}

	public int update(Siparis entity) {
		SiparisDAO.openCurrentSessionwithTransaction();
		SiparisDAO.update(entity);
		SiparisDAO.closeCurrentSessionwithTransaction();
		return 1;

	}

	public Siparis findById(int id) {
		SiparisDAO.openCurrentSession();
		Siparis siparis = SiparisDAO.findById(id);
		SiparisDAO.closeCurrentSession();
		return siparis;
	}

	public void delete(int id) {
		SiparisDAO.openCurrentSessionwithTransaction();
		Siparis siparis = SiparisDAO.findById(id);
		SiparisDAO.delete(siparis);
		SiparisDAO.closeCurrentSessionwithTransaction();

	}

	public List<Siparis> findAll() {
		SiparisDAO.openCurrentSession();
		List<Siparis> siparisler = SiparisDAO.findAll();
		SiparisDAO.closeCurrentSession();
		return siparisler;
	}

	public void deleteAll() {
		SiparisDAO.openCurrentSessionwithTransaction();
		SiparisDAO.deleteAll();
		SiparisDAO.closeCurrentSessionwithTransaction();

	}

	public SiparisDAO SiparisDAO() {
		return SiparisDAO;
	}

}
