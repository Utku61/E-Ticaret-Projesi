package com.utku.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Urun implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int u_id;
	@Column(name = "ad")
	private String ad;
	@Column(name = "aciklama")
	private String aciklama;
	@Column(name = "fiyat")
	private int fiyat;
	@Column(name = "stok")
	private int stok;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "altaltk_id", insertable = true)
	private AltAltKategori altaltkategoriId;
	
	@Column(name = "resim")
	@Lob
	private byte[] resim;

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public int getFiyat() {
		return fiyat;
	}

	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	
	public AltAltKategori getAltaltkategoriId() {
		return altaltkategoriId;
	}

	public void setAltaltkategoriId(AltAltKategori altaltkategoriId) {
		this.altaltkategoriId = altaltkategoriId;
	}

	public byte[] getResim() {
		return resim;
	}

	public void setResim(byte[] resim) {
		this.resim = resim;
	}

	@Override
	public String toString() {
		return "Urun [id=" + u_id + ", ad=" + ad + ", aciklama=" + aciklama + ", fiyat=" + fiyat + ", stok=" + stok
				+ ", kategoriId=" + 1 + ", resim=" + "]";
	}

}
