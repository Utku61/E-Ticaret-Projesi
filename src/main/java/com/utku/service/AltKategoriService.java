package com.utku.service;

import java.util.List;

import com.utku.dao.AltKategoriDAO;
import com.utku.model.AltKategori;

public class AltKategoriService {

	private static AltKategoriDAO AltKategoriDAO;

	public AltKategoriService() {
		AltKategoriDAO = new AltKategoriDAO();
	}

	public void persist(AltKategori entity) {
		AltKategoriDAO.openCurrentSessionwithTransaction();
		AltKategoriDAO.persist(entity);
		AltKategoriDAO.closeCurrentSessionwithTransaction();

	}

	public void update(AltKategori entity) {
		AltKategoriDAO.openCurrentSessionwithTransaction();
		AltKategoriDAO.update(entity);
		AltKategoriDAO.closeCurrentSessionwithTransaction();

	}

	public AltKategori findById(int id) {
		AltKategoriDAO.openCurrentSession();
		AltKategori kategori = AltKategoriDAO.findById(id);
		AltKategoriDAO.closeCurrentSession();
		return kategori;
	}

	public void delete(int id) {
		AltKategoriDAO.openCurrentSessionwithTransaction();
		AltKategori kategori = AltKategoriDAO.findById(id);
		AltKategoriDAO.delete(kategori);
		AltKategoriDAO.closeCurrentSessionwithTransaction();

	}

	public List<AltKategori> findAll() {
		AltKategoriDAO.openCurrentSession();
		List<AltKategori> kategoriler = AltKategoriDAO.findAll();
		AltKategoriDAO.closeCurrentSession();
		return kategoriler;
	}

	public void deleteAll() {
		AltKategoriDAO.openCurrentSessionwithTransaction();
		AltKategoriDAO.deleteAll();
		AltKategoriDAO.closeCurrentSessionwithTransaction();

	}

	public AltKategoriDAO AltKategoriDAO() {
		return AltKategoriDAO;
	}

}
