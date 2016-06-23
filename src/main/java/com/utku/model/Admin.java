package com.utku.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "isim")
	private String isim;
	
	@Column(name = "k_adi")
	private String k_adi;
	
	@Column(name = "sifre")
	private String sifre;

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

	public String getK_adi() {
		return k_adi;
	}

	public void setK_adi(String k_adi) {
		this.k_adi = k_adi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", isim=" + isim + ", k_adi=" + k_adi + ", sifre=" + sifre + "]";
	}
}
