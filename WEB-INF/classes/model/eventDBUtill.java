package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.customer.events;


import DBconnection.DBConnection;

public class eventDBUtill {
	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean validateevent(String email){
			
			
			
			
			
			
			try {
				
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				
			
				String sql = "select * from events where email='"+email+"' ";//sql query to select the suitable user and get details
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
	
	public static List<events> getEventDetails2(String email){
		ArrayList<events> events = new ArrayList<>();
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from events where email='"+email+"'";//sql query to select the suitable user and get details
			rs = stmt.executeQuery(sql);//run the sql query
			
			while(rs.next()) {
				
				 int eventid = rs.getInt(1);
				 String eventtype = rs.getString(2);
				 String venue= rs.getString(3);
				 String date = rs.getString(4);
				 String name = rs.getString(5);
				 String eventemail= rs.getString(6);
				 String contact = rs.getString(7);
				 String additional = rs.getString(8);
				 String price = rs.getString(9);

				 
				events cus = new events(eventid, eventtype,  venue, date, name, eventemail,contact, additional,  price);
				
				events.add(cus);
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return events;
	
}
	//insert data
		public static boolean insertevent( String eventtype, String venue, String date, String name, String email,String contact, String additional, String price)  {
			/*connect with database and insert data into database
		that saved in event servlet*/
			
			boolean isSuccess = false;
			
			
			try {//try the content inside block
				
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				
				String sql = "insert into events values (0,'"+eventtype+"',' "+venue+ "','"+date+"','"+name+"','"+email+"','"+contact+"','"+additional+"','"+price+"')";//sql query
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
				public static boolean updateevent(String eventid,  String eventtype, String venue, String date, String name, String email,String contact, String additional, String price) {//parameters are the variables in updatecustomerServlet class
					
					boolean isSuccess = false;
			try {
			    		
			    		con = DBConnection.getConnection();
			    		stmt = con.createStatement();
			    		String sql = "update events set eventtype='"+eventtype+"',venue='"+venue+"',date='"+date+"',name='"+name+"',email='"+email+"',contact='"+contact+"',additional='"+additional+"',price='"+price+"'"
			    				+ "where eventid='"+eventid+"'";
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
				public static List<events> getEventDetails(String eventid){//list of customer details
					
					int convertedID = Integer.parseInt(eventid);//convert string value into integer value
					
					ArrayList<events> cus = new ArrayList<>();
					
			try {
			    		stmt = con.createStatement();
			    		String sql = "select * from events where eventid='"+convertedID+"'";
			    		rs = stmt.executeQuery(sql);
			    		
			    		while(rs.next()) {
			    			 int eid = rs.getInt(1);
							 String eventtype = rs.getString(2);
							 
							 String venue= rs.getString(3);
							 String date = rs.getString(4);
							 String name = rs.getString(5);
							 String email= rs.getString(6);
							 String contact = rs.getString(7);
							 String additional = rs.getString(8);
							 String price = rs.getString(9);
							
			    			//pass the values to the object in a Customer class through a constructor
							events c = new events(eid,eventtype,  venue, date, name, email,contact, additional,  price);//parameterize constructor
			    			cus.add(c);//pass the customer object to arraylist object
			    		}
			    		
			    	}
			    	catch(Exception e) {
			    		e.printStackTrace();
			    	}	
					
					return cus;
				}
				//delete profile
				
				public static boolean deleteevent(String eventid) {
					
					int convId = Integer.parseInt(eventid);
					boolean isSuccess = false;
					    	
					    	try {
					    		
					    		con = DBConnection.getConnection();
					    		stmt = con.createStatement();
					    		String sql = "delete from events where eventid='"+convId+"'";
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


