package com.utku.service;

import java.util.List;

import com.utku.dao.KategoriDAO;
import com.utku.model.Kategori;

public class KategoriService {

	private static KategoriDAO KategoriDAO;

	public KategoriService() {
		KategoriDAO = new KategoriDAO();
	}

	public void persist(Kategori entity) {
		KategoriDAO.openCurrentSessionwithTransaction();
		KategoriDAO.persist(entity);
		KategoriDAO.closeCurrentSessionwithTransaction();

	}

	public void update(Kategori entity) {
		KategoriDAO.openCurrentSessionwithTransaction();
		KategoriDAO.update(entity);
		KategoriDAO.closeCurrentSessionwithTransaction();

	}

	public Kategori findById(int id) {
		KategoriDAO.openCurrentSession();
		Kategori kategori = KategoriDAO.findById(id);
		KategoriDAO.closeCurrentSession();
		return kategori;
	}

	public void delete(int id) {
		KategoriDAO.openCurrentSessionwithTransaction();
		Kategori kategori = KategoriDAO.findById(id);
		KategoriDAO.delete(kategori);
		KategoriDAO.closeCurrentSessionwithTransaction();

	}

	public List<Kategori> findAll() {
		KategoriDAO.openCurrentSession();
		List<Kategori> kategoriler = KategoriDAO.findAll();
		KategoriDAO.closeCurrentSession();
		return kategoriler;
	}

	public void deleteAll() {
		KategoriDAO.openCurrentSessionwithTransaction();
		KategoriDAO.deleteAll();
		KategoriDAO.closeCurrentSessionwithTransaction();

	}

	public KategoriDAO KategoriDAO() {
		return KategoriDAO;
	}

}
