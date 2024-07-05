package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.customerDBUtil;


@WebServlet("/customerdeleteservlet")
public class customerdeleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");//cusis the name of the input type of CID in deletecustomer.jsp
		boolean isTrue;
		
		isTrue = customerDBUtil.deleteCustomer(id);//catch the return value of istrue variable in deletecustomer method in customerDBUtil class
		
		if (isTrue == true) {
			 request.getSession().invalidate(); // Invalidate the session (log out the user)
			 
			// Display a JavaScript message
			    response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println("<html><body>");
			    out.println("<script type='text/javascript'>");
			    out.println("alert('Your account has been deleted. Please create a new account.');");
			    out.println("window.location.href='logininterface.jsp';"); // Redirect to the login page
			    out.println("</script>");
			    out.println("</body></html>");
		}
		else {
			
			List<customer> cusDetails = customerDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			// Display a JavaScript error message
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html><body>");
		    out.println("<script type='text/javascript'>");
		    out.println("alert('Cannot delete user account.');");
		    out.println("window.location.href='userprofile.jsp';"); // Redirect to the user profile page
		    out.println("</script>");
		    out.println("</body></html>");
		}
		
		
		
	    }
	}
		
	


