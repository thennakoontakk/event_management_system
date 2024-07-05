package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.customerDBUtil;


@WebServlet("/customerupdateservlet")
public class customerupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
				//save the details that entered by customer
				String id = request.getParameter("id");//cusid is the name of the input type of CID in updatecustomer.jsp
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				
				boolean isTrue;
				
				isTrue = customerDBUtil.updatecustomer(id, name, address, email, phone, username,password);//parameters used in updatecustomer method in customerDBUtil class
				
				if(isTrue == true) {
			        List<customer> cusDetails = customerDBUtil.getCustomerDetails(id);
			        request.setAttribute("cusDetails", cusDetails);
					
					
					RequestDispatcher dis = request.getRequestDispatcher("userprofile.jsp");/*if customer details successfully updated
					navigate to the user account page with updated details */
					dis.forward(request, response);
				}
				else {
					List<customer> cusDetails = customerDBUtil.getCustomerDetails(id);
					request.setAttribute("cusDetails", cusDetails);
					
					
					RequestDispatcher dis = request.getRequestDispatcher("userprofile.jsp");/*if customer details successfully updated
					navigate to the user account page with current details */
					dis.forward(request, response);
				}
		
		
	}

}
