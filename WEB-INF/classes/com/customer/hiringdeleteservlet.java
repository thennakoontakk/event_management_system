package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.hiringDBUtil;

/**
 * Servlet implementation class hiringdeleteservlet
 */
@WebServlet("/hiringdeleteservlet")
public class hiringdeleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hiringid = request.getParameter("hiringid");
		boolean isTrue;
		
		isTrue = hiringDBUtil.deletehiring(hiringid);//catch the return value of is true variable in deletecontact method in contactDBUtil class
		
		if (isTrue == true) {
			 request.getSession().invalidate(); // Invalidate the session (log out the user)
			 
			// Display a JavaScript message
			    response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println("<html><body>");
			    out.println("<script type='text/javascript'>");
			    out.println("alert('Your event order has been deleted.');");
			    out.println("window.location.href='home.jsp';"); // Redirect to the login page
			    out.println("</script>");
			    out.println("</body></html>");
		}
		else {
			
			List<hiring> hiringDetails = hiringDBUtil.getHiringDetails(hiringid);
			request.setAttribute(" hiringDetails",  hiringDetails);
			
			// Display a JavaScript error message
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html><body>");
		    out.println("<script type='text/javascript'>");
		    out.println("alert('Cannot delete user event order.');");
		    out.println("window.location.href='hiringviewdetails.jsp';"); // Redirect to the user profile page
		    out.println("</script>");
		    out.println("</body></html>");
		}
	}

}
