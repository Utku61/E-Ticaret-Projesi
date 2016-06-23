package com.utku.service;

import java.util.List;

import org.hibernate.Query;

import com.utku.dao.UrunDAO;
import com.utku.model.Urun;

public class UrunService {

	private static UrunDAO UrunDAO;

	public UrunService() {
		UrunDAO = new UrunDAO();
	}
    
	public int persist(Urun entity) {
		UrunDAO.openCurrentSessionwithTransaction();
		UrunDAO.persist(entity);
		UrunDAO.closeCurrentSessionwithTransaction();
		return 1;

	}

	public int update(Urun entity) {
		UrunDAO.openCurrentSessionwithTransaction();
		UrunDAO.update(entity);
		UrunDAO.closeCurrentSessionwithTransaction();
		return 1;

	}

	public Urun findById(int id) {
		UrunDAO.openCurrentSessionwithTransaction();
		Urun urun = UrunDAO.findById(id);///////////
		UrunDAO.closeCurrentSessionwithTransaction();
		return urun;
	}

	public void delete(int id) {
		UrunDAO.openCurrentSessionwithTransaction();
		Urun urun = UrunDAO.findById(id);
		UrunDAO.delete(urun);
		UrunDAO.closeCurrentSessionwithTransaction();

	}

	public List<Urun> findAll() {
		UrunDAO.openCurrentSessionwithTransaction();
		List<Urun> urunler = UrunDAO.findAll();//////////
		UrunDAO.closeCurrentSessionwithTransaction();
		return urunler;
	}

	public void deleteAll() {
		UrunDAO.openCurrentSessionwithTransaction();
		UrunDAO.deleteAll();
		UrunDAO.closeCurrentSessionwithTransaction();

	}

	public byte[] resimGetir(int urun_id) {

		Query query = UrunDAO.openCurrentSession().createQuery("from Urun where id = :id");
		query.setParameter("id", urun_id);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSessionwithTransaction();;
		byte[] bytesImage = null;
		bytesImage = liste.get(0).getResim();
		
		return bytesImage;
	}

	public UrunDAO UrunDAO() {
		return UrunDAO;
	}
	public List<Urun> erkekTshirtGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",1);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> erkekCeketGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",3);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> erkekKazakGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",4);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> erkekJeanGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",5);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> erkekEsortmanGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",6);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> bayanBluzGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",7);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> bayanElbiseGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",8);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> bayanJeanGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",9);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> bayanEtekGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",10);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> bayanMontGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id = :id");
		query.setParameter("id",2);
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> erkekUstGiyimGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id=1 or altaltk_id=3 or altaltk_id=4");
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> erkekAltGiyimGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id=5 or altaltk_id=6");
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> bayanAltGiyimGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id=9 or altaltk_id=10");
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}
	public List<Urun> bayanUstGiyimGetir(){
		Query query=UrunDAO.openCurrentSession().createQuery("from Urun where altaltk_id=2 or altaltk_id=7 or altaltk_id=8");
		@SuppressWarnings("unchecked")
		List<Urun> liste = query.list();
		UrunDAO.closeCurrentSession();
		return liste;
	}




}
