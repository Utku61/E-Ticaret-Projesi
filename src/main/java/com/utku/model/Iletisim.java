package com.utku.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Iletisim implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "isim")
	private String isim;
	@Column(name = "mail")
	private String mail;
	@Column(name = "konu")
	private String konu;
	@Column(name = "mesaj")
	private String mesaj;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIsim() {
		return isim;
	}


	public void setIsim(String isim) {
		this.isim = isim;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getKonu() {
		return konu;
	}


	public void setKonu(String konu) {
		this.konu = konu;
	}


	public String getMesaj() {
		return mesaj;
	}


	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}


	@Override
	public String toString() {
		return "Iletisim [id=" + id + ", isim=" + isim + ", mail=" + mail + ", konu=" + konu + ", mesaj=" + mesaj + "]";
	}

}
