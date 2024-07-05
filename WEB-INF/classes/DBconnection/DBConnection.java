package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {


	//create database connection
		static String url = "jdbc:mysql://localhost:3306/example1";//link database
		static String user = "root";
		static String Pass = "sakila";//database password
		private static Connection con;//save the connection in an object

		public static Connection getConnection() {//return connection

			try {

					Class.forName("com.mysql.jdbc.Driver");

					con = DriverManager.getConnection(url, user, Pass);

				}
			catch (Exception e) {
					System.out.println("Database connection is not success!!!");
			}

			return con;
			
			
}
		
}
