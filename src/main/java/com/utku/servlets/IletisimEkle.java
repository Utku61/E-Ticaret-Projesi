package com.utku.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utku.model.*;
import com.utku.service.*;


@WebServlet("/iletisimeGec")
public class IletisimEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public IletisimEkle() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IletisimService is = new IletisimService();
		String name = request.getParameter("name");
		String mail = request.getParameter("email");
		String message = request.getParameter("message");
		String subject = request.getParameter("subject");
		if(name!="" && mail!="" && message!="" && subject!=""){
			System.out.println(name +" "+ mail + " "+ message + " "+subject);
			Iletisim iletisim=new Iletisim();
			iletisim.setIsim(name);
			iletisim.setMail(mail);
			iletisim.setMesaj(message);
			iletisim.setKonu(subject);
			int state=is.persist(iletisim);
			if(state==1){
				response.sendRedirect("index");
			}
			else
				response.sendRedirect("contact");
		}
	}

}

