package com.utku.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class AltKategori implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int altk_id;

	@Column(name = "adi")
	private String adi;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "kat_id", insertable = false, updatable = false)
	private Kategori ustKategoriId;


	public int getAltk_id() {
		return altk_id;
	}

	public void setAltk_id(int altk_id) {
		this.altk_id = altk_id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public Kategori getUstKategoriId() {
		return ustKategoriId;
	}

	public void setUstKategoriId(Kategori ustKategoriId) {
		this.ustKategoriId = ustKategoriId;
	}

	@Override
	public String toString() {
		return "AltKategori [id=" + altk_id + ", adi=" + adi + ", ustKategoriId=" + ustKategoriId + "]";
	}

}
