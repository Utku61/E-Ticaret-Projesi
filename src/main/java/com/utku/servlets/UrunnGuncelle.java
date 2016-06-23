package com.utku.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utku.model.AltAltKategori;
import com.utku.model.Urun;
import com.utku.service.UrunService;

@WebServlet("/UrunnGuncelle")
@MultipartConfig(maxFileSize = 16177215)
public class UrunnGuncelle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UrunService us = new UrunService();
		request.setCharacterEncoding("utf-8");
		Urun urun2 = new Urun();

		int urunId = Integer.parseInt(request.getParameter("urunId"));
		urun2 = us.findById(urunId);

		String isim = request.getParameter("urunAd");
		int katId = Integer.parseInt(request.getParameter("formKategori"));

		String aciklama = request.getParameter("urunAciklama");
		int stok = Integer.parseInt(request.getParameter("urunStok"));
		int fiyat = Integer.parseInt(request.getParameter("urunFiyat"));

		if (isim != "" && aciklama != "" && stok != 0 && fiyat != 0) {
			AltAltKategori altaltkategori = new AltAltKategori();
			altaltkategori.setAltaltk_id(katId);

			Urun urun = new Urun();
			urun.setU_id(urunId);
			urun.setAd(isim);
			urun.setAciklama(aciklama);
			urun.setStok(stok);
			urun.setFiyat(fiyat);
			urun.setAltaltkategoriId(altaltkategori);
			urun.setResim(urun2.getResim());

			System.out.println(altaltkategori.toString());

			int eklendiMi = us.update(urun);
			if (eklendiMi != 0) {
				response.sendRedirect("urunAdmin");

			} else {
				System.out.println("Ürün güncellemede hata var");
				response.sendRedirect("urunGuncelle");
			}
		} else {
			System.out.println("hata büyük");
			response.sendRedirect("urunGuncelle");

		}

	}

}
