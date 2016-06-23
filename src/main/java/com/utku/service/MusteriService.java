package com.utku.service;

import java.util.List;

import org.hibernate.Query;

import com.utku.dao.MusteriDAO;
import com.utku.model.Musteri;

public class MusteriService {

	private static MusteriDAO MusteriDAO;

	public MusteriService() {
		MusteriDAO = new MusteriDAO();
	}

	public int persist(Musteri entity) {
		MusteriDAO.openCurrentSessionwithTransaction();
		MusteriDAO.persist(entity);
		MusteriDAO.closeCurrentSessionwithTransaction();
		return 1;

	}

	public void update(Musteri entity) {
		MusteriDAO.openCurrentSessionwithTransaction();
		MusteriDAO.update(entity);
		MusteriDAO.closeCurrentSessionwithTransaction();

	}

	public Musteri findById(int id) {
		MusteriDAO.openCurrentSession();
		Musteri musteri = MusteriDAO.findById(id);
		MusteriDAO.closeCurrentSession();
		return musteri;
	}

	public void delete(int id) {
		MusteriDAO.openCurrentSessionwithTransaction();
		Musteri musteri = MusteriDAO.findById(id);
		MusteriDAO.delete(musteri);
		MusteriDAO.closeCurrentSessionwithTransaction();

	}

	public List<Musteri> findAll() {
		MusteriDAO.openCurrentSession();
		List<Musteri> musteriler = MusteriDAO.findAll();
		MusteriDAO.closeCurrentSession();
		return musteriler;
	}

	public void deleteAll() {
		MusteriDAO.openCurrentSessionwithTransaction();
		MusteriDAO.deleteAll();
		MusteriDAO.closeCurrentSessionwithTransaction();

	}

	public Musteri musteriGirisKontrol(String mail, String sifre) {
		Musteri musteri = new Musteri();
		Query query = MusteriDAO.openCurrentSession()
				.createQuery("from Musteri where mail = :eposta and sifre = :sifre");
		query.setParameter("eposta", mail);
		query.setParameter("sifre", sifre);
		@SuppressWarnings("unchecked")
		List<Musteri> liste = query.list();
		if(liste.size()>0){
			musteri.setM_id(liste.get(0).getM_id());
			musteri.setIsim(liste.get(0).getIsim());
			musteri.setMail(liste.get(0).getMail());
			musteri.setSifre(liste.get(0).getSifre());
		}

		MusteriDAO.closeCurrentSession();
		if (liste.isEmpty()) {
			musteri.setIsim("0");
		}
		return musteri;
	}

	public MusteriDAO MusteriDAO() {
		return MusteriDAO;
	}

}
