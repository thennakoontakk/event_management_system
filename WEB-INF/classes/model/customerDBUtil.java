package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.customer.customer;


import DBconnection.DBConnection;


public class customerDBUtil {
	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String userName, String password){/*First validate customer using username and password after 
		get customer details as a list from databse and assign details to the customer class variables*/
			
			//validate
			try {
				
				con = DBConnection.getConnection();//create connection(connection inside try catch is checking errors in db connection)
				stmt = con.createStatement();
				
			
				String sql = "select * from customer where username='"+userName+"' and password='"+password+"'";//sql query to select the suitable user and get details
				rs = stmt.executeQuery(sql);//run the sql query(Using exceptions in sql)
				
				if(rs.next()) {//check the username and password correct or wrong
					isSuccess = true;	
				}
				else {
					isSuccess = false;
				}
				
			}
			catch(Exception e){ //catch the error
				e.printStackTrace();//print the error
				
			}
			
			return isSuccess;
			
		}
	
	public static List<customer> getCustomerDetails2(String userName){
		ArrayList<customer> customer = new ArrayList<>();
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from customer where username='"+userName+"'";//sql query to select the suitable user and get details
			rs = stmt.executeQuery(sql);//run the sql query
			
			while(rs.next()) {
				int id = rs.getInt(1);//if username and password valid take details of that customer to this class
				 String name = rs.getString(2);
				 String address =rs.getString(3);
				 String email= rs.getString(4);
				 String phone= rs.getString(5);
				 String username= rs.getString(6);
				 String userpassword= rs.getString(7);
				 
				customer cus = new customer(id,name,address,email,phone,username,userpassword);
				
				customer.add(cus);
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return customer;
	
}
	//insert data
		public static boolean insertcustomer(String name,String address, String email, String phone, String username, String password)  {
			/*connect with database and insert data into database
		that saved in customerinsert servlet*/
			
			boolean isSuccess = false;
			
			
			try {//try the content inside block
				
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				
				String sql = "insert into customer values (0,'"+name+"','"+address+"',' "+email+ "','"+phone+"','"+username+"','"+password+"')";//sql query
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
		public static boolean updatecustomer(String id, String name, String address, String email, String phone, String username, String password) {//parameters are the variables in updatecustomerServlet class
			
			boolean isSuccess = false;
	try {
	    		
	    		con = DBConnection.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "update customer set name='"+name+"',address='"+address+"',email='"+email+"',phone='"+phone+"',username='"+username+"',password='"+password+"'"
	    				+ "where id='"+id+"'";
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
		public static List<customer> getCustomerDetails(String id){//list of customer details
			
			int convertedID = Integer.parseInt(id);//convert string value into integer value
			
			ArrayList<customer> cus = new ArrayList<>();
			
	try {
	    		stmt = con.createStatement();
	    		String sql = "select * from customer where id='"+convertedID+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			int cid= rs.getInt(1);//if username and password valid take details of that customer to this class
	    			String name = rs.getString(2);
	    			 String address =rs.getString(3);
					 String email= rs.getString(4);
					 String phone= rs.getString(5);
					 String username= rs.getString(6);
					 String userpassword= rs.getString(7);
					
	    			//pass the values to the object in a Customer class through a constructor
					customer c = new customer(cid,name,address,email,phone,username,userpassword);//parameterize constructor
	    			cus.add(c);//pass the customer object to arraylist object
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
			
			return cus;
		}
		
		//delete profile
		
		public static boolean deleteCustomer(String id) {
			
			int convId = Integer.parseInt(id);
			boolean isSuccess = false;
			    	
			    	try {
			    		
			    		con = DBConnection.getConnection();
			    		stmt = con.createStatement();
			    		String sql = "delete from customer where id='"+convId+"'";
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
