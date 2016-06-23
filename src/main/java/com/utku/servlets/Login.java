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

/**
 * Servlet implementation class Login
 */
@WebServlet("/musterilogin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String sifre=request.getParameter("sifre");
		MusteriService ms = new MusteriService();
		if (mail != null && sifre != null) {
			System.out.println(mail+"   "+sifre);
			Musteri musteri = ms.musteriGirisKontrol(mail, sifre);
			if (!musteri.getIsim().equals("0")) {
				ArrayList<Urun> cart = new ArrayList<Urun>();
				
				request.getSession().setAttribute("cart", cart);
				request.getSession().setAttribute("musteri", musteri);				
				response.sendRedirect("index");
			} else {				
				request.setAttribute("status", "E-Posta adresiniz veya Sifre hatali");
				request.getRequestDispatcher("login").forward(request, response);
			}
		} else {
			response.sendRedirect("index");
		}
	}

}
