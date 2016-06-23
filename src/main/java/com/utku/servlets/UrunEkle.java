package com.utku.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.utku.model.AltAltKategori;
import com.utku.model.Urun;
import com.utku.service.UrunService;

@WebServlet("/UrunEkle")
@MultipartConfig(maxFileSize = 16177215) 
public class UrunEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UrunService us = new UrunService();
		request.setCharacterEncoding("utf-8");
		String isim = request.getParameter("urunAd");
		int katId=Integer.parseInt(request.getParameter("formKategori"));
		
		String aciklama = request.getParameter("urunAciklama");
		int stok = Integer.parseInt(request.getParameter("urunStok"));
		int fiyat = Integer.parseInt(request.getParameter("urunFiyat"));
		
			
		InputStream resim = null; 
        Part filePart = request.getPart("resim");
        if (filePart != null) {
            resim = filePart.getInputStream();
        }
		
		if(isim!="" && aciklama!="" && stok!=0 && fiyat!=0){
			AltAltKategori altaltkategori = new AltAltKategori();
			altaltkategori.setAltaltk_id(katId);
			
			Urun urun=new Urun();
			urun.setAd(isim);
			urun.setAciklama(aciklama);
			urun.setStok(stok);
			urun.setFiyat(fiyat);
			urun.setAltaltkategoriId(altaltkategori);
			urun.setResim(IOUtils.toByteArray(resim));
			
			System.out.println(altaltkategori.toString());
			
			int eklendiMi = us.persist(urun);
			if(eklendiMi != 0){
				response.sendRedirect("urunAdmin");
				
			}else{	
				System.out.println("Ürün eklemede hata var");
				response.sendRedirect("urunEkle");
			}
		}
		else{			
			System.out.println("hata büyük");
			response.sendRedirect("urunEkle");
			
		}
		

		

		
	}
		
	}


