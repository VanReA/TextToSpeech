/*
 * SOURCE: http://www.tutorialspoint.com/jdbc/jdbc-create-database.htm
 * http://stackoverflow.com/questions/2839321/java-connectivity-with-mysql/2840358#2840358
 */
package dataBase;

import java.sql.*;

public class FirstJDBC {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://198.23.57.16:3308/vanrea_test";
	
	//  Database credentials
	static final String USER = "vanrea_test";
	static final String PASS = "rearea";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection established!");

			
			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while (rs.next()) {
			  System.out.println("\t " + rs.getString(3));
			}
			
			stmt = conn.createStatement();
			String sql = "CREATE TABLE JAVAA " +
	                   "(id INTEGER not NULL, " +
	                   " first VARCHAR(255), " + 
	                   " last VARCHAR(255), " + 
	                   " age INTEGER, " + 
	                   " PRIMARY KEY ( id ))"; 

			stmt.executeUpdate(sql);
//	      
//			System.out.println("Creating database...");
//			stmt = conn.createStatement();
//			String sql = "CREATE DATABASE JAVA";
//			stmt.executeUpdate(sql);
			
		    System.out.println("Database created successfully...");
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main
}	
