package com.utku.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utku.service.*;


@WebServlet("/musteriSil")
public class musteriSil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public musteriSil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		int silId=Integer.parseInt(request.getParameter("sil"));
		MusteriService ms = new MusteriService();
		ms.delete(silId);
		response.sendRedirect("adminMusteri");
		}
		catch(Exception e){
			System.out.println("Foreign key hatası");
			response.sendRedirect("adminMusteri");
			
		}
	}

}
