package com.utku.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Cikis
 */
@WebServlet("/cikis")
public class Cikis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cikis() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("musteri", null);
		request.getSession().setAttribute("cart", null);
		response.sendRedirect("index");
		
	}

}
