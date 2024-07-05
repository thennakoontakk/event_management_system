package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.hiringDBUtil;


@WebServlet("/hiringupdateservlet")
public class hiringupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 
		String hiringid = request.getParameter("hiringid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String dancestyle = request.getParameter("dancestyle");
		String experience = request.getParameter("experience");
		
		
		
		boolean isTrue;
		
		isTrue = hiringDBUtil.updatehiring(hiringid, name, email , phone, dob, address, dancestyle, experience);
		
		if (isTrue == true) {
		    List<hiring> hiringDetails = hiringDBUtil.getHiringDetails(hiringid);
		    request.setAttribute("hiringDetails", hiringDetails);

		    RequestDispatcher dis = request.getRequestDispatcher("hiringviewdetails.jsp");
		    dis.forward(request, response);

		    // Display a success message using JavaScript
		    String successMessage = "Update successful!";
		    out.println("<script type='text/javascript'>");
		    out.println("alert('" + successMessage + "');");
		    out.println("window.location.href='hiringviewdetails.jsp';"); // Redirect to the desired page
		    out.println("</script>");
		} else {
		    List<hiring> hiringDetails = hiringDBUtil.getHiringDetails(hiringid);
		    request.setAttribute("hiringDetails", hiringDetails);

		    RequestDispatcher dis = request.getRequestDispatcher("hiringviewdetails.jsp");
		    dis.forward(request, response);

		    // Display an error message using JavaScript
		    String errorMessage = "Update failed!";
		    out.println("<script type='text/javascript'>");
		    out.println("alert('" + errorMessage + "');");
		    out.println("window.location.href='hiringviewdetails.jsp';"); // Redirect to the desired page
		    out.println("</script>");
		}

	}

}
