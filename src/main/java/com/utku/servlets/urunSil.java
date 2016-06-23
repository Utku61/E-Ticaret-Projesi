package com.utku.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utku.service.*;


@WebServlet("/urunSil")
public class urunSil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public urunSil() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UrunService us = new UrunService();
		int id = Integer.parseInt(request.getParameter("sil"));
		us.delete(id);
		response.sendRedirect("urunAdmin");
	}

}
