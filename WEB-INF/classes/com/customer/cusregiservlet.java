package com.customer;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.customerDBUtil;


@WebServlet("/cusregiservlet")
public class cusregiservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		    
		String name = request.getParameter("name");//save the name that customer entered in variable
		
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;//catch the return value by the variable
		
		isTrue = customerDBUtil.insertcustomer(name,address,email, phone, username, password);
		
		if(isTrue == true) {//check the database connection success or not
			 out.println("<script type=\"text/javascript\">");
			    out.println("alert('User account registered successfully!');");
			    out.println("window.location.href = 'logininterface.jsp';"); // Redirect to your registration page
			    out.println("</script>");
		} else {
		    // Replace the RequestDispatcher with a JavaScript alert
		   
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('User account not registered successfully!');");
		    out.println("window.location.href = 'cusregister.jsp';"); // Redirect to your registration page
		    out.println("</script>");
		}
		
		
	}

}
