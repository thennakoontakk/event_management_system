package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.eventDBUtill;

/**
 * Servlet implementation class eventupdateservlet
 */
@WebServlet("/eventupdateservlet")
public class eventupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//save the details that entered by customer
		String eventid = request.getParameter("eventid");//cusid is the name of the input type of CID in updatecustomer.jsp
		String eventtype = request.getParameter("eventtype");
		String venue = request.getParameter("venue");
		String date = request.getParameter("date");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String additional = request.getParameter("additional");
		String price = request.getParameter("price");
		
		
		boolean isTrue;
		
		isTrue = eventDBUtill.updateevent(eventid, eventtype, venue, date, name, email, contact, additional,price);//parameters used in updatecustomer method in customerDBUtil class
		
		if(isTrue == true) {
	        List<events> eventDetails = eventDBUtill.getEventDetails(eventid);
	        request.setAttribute("eventDetails", eventDetails);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("vieweventdetails.jsp");/*if customer details successfully updated
			navigate to the user account page with updated details */
			dis.forward(request, response);
		}
		else {
			List<events> eventDetails = eventDBUtill.getEventDetails(eventid);
			request.setAttribute("eventDetails", eventDetails);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("vieweventdetails.jsp");/*if customer details successfully updated
			navigate to the user account page with current details */
			dis.forward(request, response);
		}

	}

}
