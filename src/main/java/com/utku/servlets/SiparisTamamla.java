package com.utku.servlets;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utku.service.*;
import com.utku.model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/siparisTamamla")
public class SiparisTamamla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SiparisTamamla() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("musteri")!=null){
			Siparis siparis=new Siparis();
			SiparisService ss = new SiparisService();
			Musteri musteri =(Musteri) request.getSession().getAttribute("musteri") ;
			@SuppressWarnings("unchecked")
			ArrayList<Urun> urunler=(ArrayList<Urun>) request.getSession().getAttribute("cart");
			
			 	Date simdikiZaman = new Date();
		        System.out.println(simdikiZaman.toString());
		        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		        System.out.println(df.format(simdikiZaman));
			
			
			for(int i=0;i<urunler.size();i++){
//				musteri.setMusteriId(musteri.getMusteriId());
//				musteri.setMusteriAd(musteri.getMusteriAd());
//				musteri.setMusteriMail(musteri.getMusteriMail());
//				musteri.setMusteriMail(musteri.getMusteriSifre());
				
				siparis.setMusteriId(musteri);
				siparis.setAdet(1);
				siparis.setFiyat(urunler.get(i).getFiyat());
				siparis.setSiparis_durumu("Siparisiniz Hazirlaniyor..");
				siparis.setTarih(df.format(simdikiZaman));
				siparis.setUrunId(urunler.get(i));
				ss.persist(siparis);
				
			}
		}
			
			response.sendRedirect("siparis");
		//doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
		
		
	}

}
