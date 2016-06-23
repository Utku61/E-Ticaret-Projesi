package com.utku.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utku.service.*;

@WebServlet("/sayigetir")
public class SiparisSayisiGetir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SiparisSayisiGetir() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SiparisService ss= new SiparisService();
		int siparisSayisi=0;
		siparisSayisi=ss.findAll().size();
		out.print(siparisSayisi);
	}

}
