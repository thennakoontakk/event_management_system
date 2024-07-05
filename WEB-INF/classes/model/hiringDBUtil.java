package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.customer.hiring;

import DBconnection.DBConnection;

public class hiringDBUtil {

	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean validatehiring(String email){
			
			
			
			
			
			
			try {
				
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				
			
				String sql = "select * from hiring where email='"+email+"' ";//sql query to select the suitable user and get details
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
	
	public static List<hiring> gethiringDetails2(String email){
		ArrayList<hiring> hiring = new ArrayList<>();
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from hiring where email='"+email+"'";//sql query to select the suitable user and get details
			rs = stmt.executeQuery(sql);//run the sql query
			
			while(rs.next()) {
				
				 int hiringid = rs.getInt(1);
				 String name = rs.getString(2);
				 String hiringemail= rs.getString(3);
				 String phone = rs.getString(4);
				 String dob = rs.getString(5);
				 String address= rs.getString(6);
				 String dancestyle= rs.getString(7);
				 String experience = rs.getString(8);
			

				 
				hiring cus = new hiring(hiringid,name,hiringemail,phone,dob,address,dancestyle,experience);
				
				hiring.add(cus);
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return hiring;
	
}
	//insert data
		public static boolean inserthiring(String name, String email, String phone, String dob, String address,String dancestyle, String experience)  {
			/*connect with database and insert data into database
		that saved in event servlet*/
			
			boolean isSuccess = false;
			
			
			try {//try the content inside block
				
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				
				String sql = "insert into hiring values (0,'"+name+"','"+email+ "','"+phone+"','"+dob+"','"+address+"','"+dancestyle+"','"+experience+"')";//sql query
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
				public static boolean updatehiring(String hiringid, String name, String email, String phone, String dob, String address,String dancestyle, String experience) {//parameters are the variables in updatecustomerServlet class
					
					boolean isSuccess = false;
			try {
			    		
			    		con = DBConnection.getConnection();
			    		stmt = con.createStatement();
			    		String sql = "update hiring set name='"+name+"',email='"+email+"',phone='"+phone+"',dob='"+dob+"',address='"+address+"',dancestyle='"+dancestyle+"',experience='"+experience+"'"
			    				+ "where hiringid='"+hiringid+"'";
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
				public static List<hiring> getHiringDetails(String hiringid){//list of customer details
					
					int convertedID = Integer.parseInt(hiringid);//convert string value into integer value
					
					ArrayList<hiring> cus = new ArrayList<>();
					
			try {
			    		stmt = con.createStatement();
			    		String sql = "select * from hiring where hiringid='"+convertedID+"'";
			    		rs = stmt.executeQuery(sql);
			    		
			    		while(rs.next()) {
			    			 int id = rs.getInt(1);
							 String name = rs.getString(2);
							 String email= rs.getString(3);
							 String phone = rs.getString(4);
							 String dob = rs.getString(5);
							 String address= rs.getString(6);
							 String dancestyle= rs.getString(7);
							 String experience = rs.getString(8);
							
			    			//pass the values to the object in a Customer class through a constructor
							hiring c = new hiring(id, name, email , phone, dob, address, dancestyle, experience);//parameterize constructor
			    			cus.add(c);//pass the customer object to arraylist object
			    		}
			    		
			    	}
			    	catch(Exception e) {
			    		e.printStackTrace();
			    	}	
					
					return cus;
				}
				
				
				//delete profile
				
				public static boolean deletehiring(String hiringid) {
					
					int convId = Integer.parseInt(hiringid);
					boolean isSuccess = false;
					    	
					    	try {
					    		
					    		con = DBConnection.getConnection();
					    		stmt = con.createStatement();
					    		String sql = "delete from hiring where hiringid='"+convId+"'";
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
