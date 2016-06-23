package com.utku.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utku.model.*;
import com.utku.service.*;

@WebServlet("/musterikayit")
public class MusteriEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MusteriEkle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String isim = request.getParameter("adSoyad");
		String mail = request.getParameter("ePosta");
		String sifre = request.getParameter("password");
		MusteriService ms = new MusteriService();
		if(isim!="" && mail!="" && sifre!=""){
			Musteri musteri=new Musteri();
			musteri.setIsim(isim);
			musteri.setMail(mail);
			musteri.setSifre(sifre);
			int eklendiMi = ms.persist(musteri);
			if(eklendiMi != 0){
				ArrayList<Urun> cart = new ArrayList<Urun>();
				request.getSession().setAttribute("cart", cart);
				request.getSession().setAttribute("musteri", musteri);
				response.sendRedirect("index");
				
			}else{				
				request.getRequestDispatcher("index").forward(request, response);
			}
		}
		else{			
			request.getRequestDispatcher("login").forward(request, response);
			
		}
	}

}
