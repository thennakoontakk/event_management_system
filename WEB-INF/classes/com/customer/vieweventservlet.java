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

import model.eventDBUtill;

/**
 * Servlet implementation class vieweventservlet
 */
@WebServlet("/vieweventservlet")
public class vieweventservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//if login unsuccess, show javascript error and redirect to the login page
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email = request.getParameter("email");//catch the event type
		
		boolean isTrue;
		
		isTrue =eventDBUtill.validateevent(email);
		
		if(isTrue == true) {
			
			 List<events> eventDetails = eventDBUtill.getEventDetails2(email);
		     request.setAttribute("eventDetails", eventDetails);
			
			//navigate to another page
			RequestDispatcher dis = request.getRequestDispatcher("vieweventdetails.jsp");
			dis.forward(request, response);
		}
		else
		{
			out.println("<script type='text/javascript'>");
			out.print("alert('Your email is incorrect');");
			out.println("location = 'eventsearch.jsp'");
			out.println("</script>");
		}
	}

}
