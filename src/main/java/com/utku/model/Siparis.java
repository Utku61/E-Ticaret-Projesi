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
public class Siparis implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "m_id" , updatable = false)
	private Musteri musteriId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "u_id",  updatable = false)
	private Urun urunId;
	@Column(name="tarih")
	private String tarih;
	@Column(name="siparis_durumu")
	private String siparis_durumu;
	@Column(name="adet")
	private int adet;
	@Column(name="fiyat")
	private int fiyat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Musteri getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(Musteri musteriId) {
		this.musteriId = musteriId;
	}

	public Urun getUrunId() {
		return urunId;
	}

	public void setUrunId(Urun urunId) {
		this.urunId = urunId;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getSiparis_durumu() {
		return siparis_durumu;
	}

	public void setSiparis_durumu(String siparis_durumu) {
		this.siparis_durumu = siparis_durumu;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	public int getFiyat() {
		return fiyat;
	}

	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	@Override
	public String toString() {
		return "Siparis [id=" + id + ", musteriId=" + musteriId + ", urunId=" + urunId + ", tarih=" + tarih
				+ ", siparis_durumu=" + siparis_durumu + ", adet=" + adet + ", fiyat=" + fiyat + "]";
	}

}
