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

import model.contactusDBUtil;


/**
 * Servlet implementation class contactviewservlet
 */
@WebServlet("/contactviewservlet")
public class contactviewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//if login unsuccess, show javascript error and redirect to the login page
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				
				String email = request.getParameter("email");//catch the event type
				
				boolean isTrue;
				
				isTrue =contactusDBUtil.validatecontact(email);
				
				if(isTrue == true) {
					
					 List<contactus> contactDetails = contactusDBUtil.getcontactDetails2(email);
				     request.setAttribute("contactDetails", contactDetails);
					
					//navigate to another page
					RequestDispatcher dis = request.getRequestDispatcher("contactdetailsview.jsp");
					dis.forward(request, response);
				}
				else
				{
					out.println("<script type='text/javascript'>");
					out.print("alert('Your email is incorrect');");
					out.println("location = 'contactussearch.jsp'");
					out.println("</script>");
				}
	}

}
