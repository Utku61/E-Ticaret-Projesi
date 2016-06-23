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
public class AltAltKategori implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int altaltk_id;
	
	@Column(name = "ad")
	private String ad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "altaltk_id",  insertable = false, updatable = false)
	private AltKategori altKategoriId;
	
	
		public int getAltaltk_id() {
		return altaltk_id;
	}


	public void setAltaltk_id(int altaltk_id) {
		this.altaltk_id = altaltk_id;
	}


	public String getAd() {
		return ad;
	}


	public void setAd(String ad) {
		this.ad = ad;
	}


	public AltKategori getAltKategoriId() {
		return altKategoriId;
	}


	public void setAltKategoriId(AltKategori altKategoriId) {
		this.altKategoriId = altKategoriId;
	}


	@Override
	public String toString() {
		return "AltAltKategori [id=" + altaltk_id + ", ad=" + ad + ", altKategoriId=" + altKategoriId + "]";
	}
	

}
