package com.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.contactusDBUtil;


/**
 * Servlet implementation class contactusinservlet
 */
@WebServlet("/contactusinservlet")
public class contactusinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 
		String name = request.getParameter("name");//save the name that customer entered in variable
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		
		
		boolean isTrue;//catch the return value by the variable
		
		isTrue = contactusDBUtil.insertcontact( name, email, phone, message);
		
		if(isTrue == true) {//check the database connection success or not
			 out.println("<script type=\"text/javascript\">");
			    out.println("alert('User Message successfully Send !');");
			    out.println("window.location.href = 'home.jsp';"); // Redirect to your registration page
			    out.println("</script>");
		} else {
		    // Replace the RequestDispatcher with a JavaScript alert
		   
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('User Message not successfully Send !');");
		    out.println("window.location.href = 'contactus.jsp';"); // Redirect to your registration page
		    out.println("</script>");
		}
		
		
		
		
		
	}

}
