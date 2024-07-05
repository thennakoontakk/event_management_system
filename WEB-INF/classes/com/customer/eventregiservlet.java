package com.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.eventDBUtill;


@WebServlet("/eventregiservlet")
public class eventregiservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		    
		String eventtype = request.getParameter("eventtype");
		String venue = request.getParameter("venue");
		String date = request.getParameter("date");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String additional = request.getParameter("additional");
		String price = request.getParameter("price");
		boolean isTrue;//catch the return value by the variable
		
		isTrue = eventDBUtill.insertevent( eventtype, venue, date, name, email,contact, additional,  price);
		
		if(isTrue == true) {//check the database connection success or not
			 out.println("<script type=\"text/javascript\">");
			    out.println("alert('Event add successfully!');");
			    out.println("window.location.href = 'home.jsp';"); // Redirect to your registration page
			    out.println("</script>");
		} else {
		    // Replace the RequestDispatcher with a JavaScript alert
		   
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('event not add successfully!');");
		    out.println("window.location.href = 'home.jsp';"); // Redirect to your registration page
		    out.println("</script>");
		}
		
		
		
	}

}
