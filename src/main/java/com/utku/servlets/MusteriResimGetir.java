package com.utku.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utku.service.UrunService;


@WebServlet("/resimgetir")
public class MusteriResimGetir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resimId = Integer.parseInt(request.getParameter("urunResim"));
		UrunService us = new UrunService();
		byte[] image = us.findById(resimId).getResim();
		response.setContentType("image/png");
		response.getOutputStream().write(image);
		
	}
}