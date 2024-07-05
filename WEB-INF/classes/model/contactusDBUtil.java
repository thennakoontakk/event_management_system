package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.contactus;


import DBconnection.DBConnection;

public class contactusDBUtil {
	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean validatecontact(String email){
			
			
			
			
			
			
			try {
				
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				
			
				String sql = "select * from contactus where email='"+email+"'";//sql query to select the suitable user and get details
				rs = stmt.executeQuery(sql);//run the sql query
				
				if(rs.next()) {//
					isSuccess = true;	
				}
				else {
					isSuccess = false;
				}
				
			}
			catch(Exception e){ 
				e.printStackTrace();
				
			}
			
			return isSuccess;
			
		}
	
	public static List<contactus> getcontactDetails2(String email){
		ArrayList<contactus> contactus = new ArrayList<>();
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from contactus where email='"+email+"'";//sql query to select the suitable user and get details
			rs = stmt.executeQuery(sql);//run the sql query
			
			while(rs.next()) {
				
				 int contactid = rs.getInt(1);
				 String name = rs.getString(2);
				 String eventemail= rs.getString(3);
				 String phone = rs.getString(4);
				 String message = rs.getString(5);
				 

				 
				 contactus cus = new contactus(contactid, name, eventemail,phone, message);
				
				 contactus.add(cus);
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return contactus;
	
}
	//insert data
		public static boolean insertcontact( String name, String email, String phone, String message)  {
			/*connect with database and insert data into database
		that saved in event servlet*/
			
			boolean isSuccess = false;
			
			
			try {//try the content inside block
				
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				
				String sql = "insert into contactus values (0,'"+name+"','"+email+ "','"+phone+"','"+message+"')";//sql query
	    		int rs = stmt.executeUpdate(sql);//store executeUpdate value in integer variable
	    		//executeUpdate statement return 2 values as 0 and 1
	    		//if value 0 unsuccess and if value 1 Success
	    		if(rs > 0) {
	    			isSuccess = true;
	    		} else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch (Exception e) {//catch if there is an error
	    		e.printStackTrace();//print that error
	    	}
			
			
			
			return isSuccess;	
			
		}
		
		//update data
		public static boolean updatecontact(String contactid,   String name, String email, String phone, String message) {//parameters are the variables in updatecustomerServlet class
			
			boolean isSuccess = false;
	try {
	    		
	    		con = DBConnection.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "update contactus set name='"+name+"',email='"+email+"',phone='"+phone+"',message='"+message+"'"
	    				+ "where contactid='"+contactid+"'";
	    		int rs = stmt.executeUpdate(sql);
	    		
	    		if(rs > 0) {
	    			isSuccess = true;//rs=1
	    		}
	    		else {
	    			isSuccess = false;//rs=0 
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
			
			return isSuccess;	
			
		}
		//retrieve data
		public static List<contactus> getcontactDetails(String contactid){//list of customer details
			
			int convertedID = Integer.parseInt(contactid);//convert string value into integer value
			
			ArrayList<contactus> cus = new ArrayList<>();
			
	try {
	    		stmt = con.createStatement();
	    		String sql = "select * from contactus where contactid='"+convertedID+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			int cid = rs.getInt(1);
					 String name = rs.getString(2);
					 String email= rs.getString(3);
					 String phone = rs.getString(4);
					 String message = rs.getString(5);
					
	    			//pass the values to the object in a Customer class through a constructor
					contactus c = new contactus(cid, name, email,phone, message);//parameterize constructor
	    			cus.add(c);//pass the customer object to arraylist object
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
			
			return cus;
		}
		//delete profile
		
		public static boolean deletecontact(String contactid) {
			
			int convId = Integer.parseInt(contactid);
			boolean isSuccess = false;
			    	
			    	try {
			    		
			    		con = DBConnection.getConnection();
			    		stmt = con.createStatement();
			    		String sql = "delete from contactus where contactid='"+convId+"'";
			    		int r = stmt.executeUpdate(sql);//executeUpdate method is use for insert, update, delete
			    		
			    		if (r > 0) {
			    			isSuccess = true;
			    		}
			    		else {
			    			isSuccess = false;
			    		}
			    		
			    	}
			    	catch (Exception e) {
			    		e.printStackTrace();
			    	}
					
					
					return isSuccess;
				}
		
}
