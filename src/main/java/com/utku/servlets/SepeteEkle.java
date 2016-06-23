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

@WebServlet("/sepetekle")
public class SepeteEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("urunID"));
		
		UrunService us = new UrunService();
		if(request.getSession().getAttribute("musteri")!=null){
			@SuppressWarnings("unchecked")
			ArrayList<Urun> sepet = (ArrayList<Urun>) request.getSession().getAttribute("cart");		
			sepet.add(us.findById(id));
			request.getRequestDispatcher("index").forward(request, response);
		}
		else{
			response.sendRedirect("index");
		}
	}
}
