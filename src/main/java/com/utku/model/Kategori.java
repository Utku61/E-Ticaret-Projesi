package com.utku.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Kategori implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kat_id;

	@Column(name = "adi")
	private String adi;
//	
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="kategoriId",cascade=CascadeType.ALL)
//	private List<Urun> urunler;


	public int getKat_id() {
		return kat_id;
	}

	public void setKat_id(int kat_id) {
		this.kat_id = kat_id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

//	public List<Urun> getUrunler() {
//		return urunler;
//	}
//
//	public void setUrunler(List<Urun> urunler) {
//		this.urunler = urunler;
//	}

	@Override
	public String toString() {
		return "Kategori [kat_id=" + kat_id + ", adi=" + adi + "]";
	}


}
