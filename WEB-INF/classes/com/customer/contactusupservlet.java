package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.contactusDBUtil;


/**
 * Servlet implementation class contactusupservlet
 */
@WebServlet("/contactusupservlet")
public class contactusupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//save the details that entered by customer
				String contactid = request.getParameter("contactid");//cusid is the name of the input type of CID in updatecustomer.jsp			
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String message = request.getParameter("message");
				
				
				
				boolean isTrue;
				
				isTrue = contactusDBUtil.updatecontact(contactid, name, email,phone, message);//parameters used in updatecustomer method in customerDBUtil class
				
				if(isTrue == true) {
			        List<contactus> contactDetails = contactusDBUtil.getcontactDetails(contactid);
			        request.setAttribute("contactDetails", contactDetails);
					
					
					RequestDispatcher dis = request.getRequestDispatcher("contactdetailsview.jsp");/*if customer details successfully updated
					navigate to the user account page with updated details */
					dis.forward(request, response);
				}
				else {
					List<contactus> contactDetails = contactusDBUtil.getcontactDetails(contactid);
					request.setAttribute("contactDetails", contactDetails);
					
					
					RequestDispatcher dis = request.getRequestDispatcher("contactdetailsview.jsp");/*if customer details successfully updated
					navigate to the user account page with current details */
					dis.forward(request, response);
				}
	}

}
