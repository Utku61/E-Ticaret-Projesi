package com.utku.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utku.service.*;
import com.utku.model.*;

@WebServlet("/SiparissGuncelle")
public class SiparissGuncelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SiparissGuncelle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		SiparisService ss = new SiparisService();
		Siparis siparis = new Siparis();
		Siparis siparis2 = new Siparis();
		int siparisId=Integer.parseInt(request.getParameter("siparisId"));
		String tarih=request.getParameter("siparisTarih");
		int adet=Integer.parseInt(request.getParameter("urunAdet"));
		String siparisDurum=request.getParameter("siparisDurumu");
		System.out.println(siparisDurum);
		siparis = ss.findById(siparisId);
		
		if(siparisDurum!="" && tarih!=""){
			siparis2.setAdet(adet);
			siparis2.setFiyat(siparis.getFiyat());
			siparis2.setMusteriId(siparis.getMusteriId());
			siparis2.setId(siparis.getId());
			siparis2.setSiparis_durumu(siparisDurum);
			siparis2.setTarih(tarih);
			siparis2.setUrunId(siparis.getUrunId());
			
			int EklendiMi=ss.update(siparis2);
			if(EklendiMi!=0){
				
				System.out.println(siparis2.toString());
				
				response.sendRedirect("siparisAdmin");
			}
			else{ System.out.println("Siparis Güncellemede Hata Var");
			}
		}
		else{
			response.sendRedirect("siparisGuncelle");
			
		}
		}
		
		
		
		
		
	}


