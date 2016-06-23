package com.utku.service;

import java.util.List;

import com.utku.dao.IletisimDAO;
import com.utku.model.Iletisim;

public class IletisimService {

	private static IletisimDAO IletisimDAO;

	public IletisimService() {
		IletisimDAO = new IletisimDAO();
	}

	public int persist(Iletisim entity) {
		IletisimDAO.openCurrentSessionwithTransaction();
		IletisimDAO.persist(entity);
		IletisimDAO.closeCurrentSessionwithTransaction();
		return 1;

	}

	public void update(Iletisim entity) {
		IletisimDAO.openCurrentSessionwithTransaction();
		IletisimDAO.update(entity);
		IletisimDAO.closeCurrentSessionwithTransaction();

	}

	public Iletisim findById(int id) {
		IletisimDAO.openCurrentSession();
		Iletisim Iletisim = IletisimDAO.findById(id);
		IletisimDAO.closeCurrentSession();
		return Iletisim;
	}

	public void delete(int id) {
		IletisimDAO.openCurrentSessionwithTransaction();
		Iletisim Iletisim = IletisimDAO.findById(id);
		IletisimDAO.delete(Iletisim);
		IletisimDAO.closeCurrentSessionwithTransaction();

	}

	public List<Iletisim> findAll() {
		IletisimDAO.openCurrentSession();
		List<Iletisim> Iletisimler = IletisimDAO.findAll();
		IletisimDAO.closeCurrentSession();
		return Iletisimler;
	}

	public void deleteAll() {
		IletisimDAO.openCurrentSessionwithTransaction();
		IletisimDAO.deleteAll();
		IletisimDAO.closeCurrentSessionwithTransaction();

	}

	public IletisimDAO IletisimDAO() {
		return IletisimDAO;
	}

}
