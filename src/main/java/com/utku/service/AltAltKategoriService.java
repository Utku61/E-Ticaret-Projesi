package com.utku.service;

import java.util.List;

import com.utku.dao.AltAltKategoriDAO;
import com.utku.model.AltAltKategori;

public class AltAltKategoriService {

	private static AltAltKategoriDAO AltAltKategoriDAO;

	public AltAltKategoriService() {
		AltAltKategoriDAO = new AltAltKategoriDAO();
	}

	public void persist(AltAltKategori entity) {
		AltAltKategoriDAO.openCurrentSessionwithTransaction();
		AltAltKategoriDAO.persist(entity);
		AltAltKategoriDAO.closeCurrentSessionwithTransaction();

	}

	public void update(AltAltKategori entity) {
		AltAltKategoriDAO.openCurrentSessionwithTransaction();
		AltAltKategoriDAO.update(entity);
		AltAltKategoriDAO.closeCurrentSessionwithTransaction();

	}

	public AltAltKategori findById(int id) {
		AltAltKategoriDAO.openCurrentSession();
		AltAltKategori kategori = AltAltKategoriDAO.findById(id);
		AltAltKategoriDAO.closeCurrentSession();
		return kategori;
	}

	public void delete(int id) {
		AltAltKategoriDAO.openCurrentSessionwithTransaction();
		AltAltKategori kategori = AltAltKategoriDAO.findById(id);
		AltAltKategoriDAO.delete(kategori);
		AltAltKategoriDAO.closeCurrentSessionwithTransaction();

	}

	public List<AltAltKategori> findAll() {
		AltAltKategoriDAO.openCurrentSession();
		List<AltAltKategori> kategoriler = AltAltKategoriDAO.findAll();
		AltAltKategoriDAO.closeCurrentSession();
		return kategoriler;
	}

	public void deleteAll() {
		AltAltKategoriDAO.openCurrentSessionwithTransaction();
		AltAltKategoriDAO.deleteAll();
		AltAltKategoriDAO.closeCurrentSessionwithTransaction();

	}

	public AltAltKategoriDAO AltAltKategoriDAO() {
		return AltAltKategoriDAO;
	}

}
