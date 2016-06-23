package com.utku.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Musteri implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int m_id;
	
	@Column(name = "isim")
	private String isim;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "sifre")
	private String sifre;

	


	public int getM_id() {
		return m_id;
	}


	public void setM_id(int m_id) {
		this.m_id = m_id;
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


	public String getSifre() {
		return sifre;
	}


	public void setSifre(String sifre) {
		this.sifre = sifre;
	}


	@Override
	public String toString() {
		return "Musteri [id=" + m_id + ", isim=" + isim + ", mail=" + mail + ", sifre=" + sifre + "]";
	}

	
}
