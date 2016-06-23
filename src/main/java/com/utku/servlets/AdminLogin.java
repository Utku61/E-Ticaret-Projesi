package com.utku.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utku.service.AdminService;

import com.utku.model.Admin;


@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		String k_adi = request.getParameter("k_adi");
		String sifre=request.getParameter("sifre");
		AdminService adminService=new AdminService();
		if (k_adi != null && sifre != null) {
			Admin admin= new Admin();
			admin = adminService.adminGirisKontrol(k_adi, sifre);			
			if (!admin.getIsim().equals("0") ) {				 
				request.getSession().setAttribute("admin", admin);				
				response.sendRedirect("indexAdmin");
			}
			else{
				response.sendRedirect("admin");
			}
		}
		else{
			response.sendRedirect("admin");
		}
	}

}
