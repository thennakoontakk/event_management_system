package com.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.hiringDBUtil;

/**
 * Servlet implementation class hiringinsertservlet
 */
@WebServlet("/hiringinsertservlet")
public class hiringinsertservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		    
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String dancestyle = request.getParameter("dancestyle");
		String experience = request.getParameter("experience");
		
		
		boolean isTrue;//catch the return value by the variable
		
		isTrue = hiringDBUtil.inserthiring(name, email , phone, dob, address, dancestyle, experience);
		
		if(isTrue == true) {//check the database connection success or not
			 out.println("<script type=\"text/javascript\">");
			    out.println("alert('Submit successfully!');");
			    out.println("window.location.href = 'home.jsp';"); // Redirect to your registration page
			    out.println("</script>");
		} else {
		    // Replace the RequestDispatcher with a JavaScript alert
		   
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Not submit successfully!');");
		    out.println("window.location.href = 'home.jsp';"); // Redirect to your registration page
		    out.println("</script>");
		}
	}

}
