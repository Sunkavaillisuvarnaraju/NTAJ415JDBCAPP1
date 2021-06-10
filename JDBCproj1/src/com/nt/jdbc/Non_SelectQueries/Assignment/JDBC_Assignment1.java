package com.nt.jdbc.Non_SelectQueries.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 
 *  This Application is meant for deleteing the student column from sudent table based student number;
 * 				Developed on may -27
 * 				Using the SQL query is
 *  				query="delete from student where sno=2;" 
 */
public class JDBC_Assignment1 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st =null;
		try {
			sc= new Scanner(System.in);
			System.out.println("Enter Student Number::");
			int snum=sc.nextInt();
			
			//Load the class into jvm
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
			
			//create statement object
			if(con!=null)
				st=con.createStatement();
			
			//process the sql query
			String query="delete from student where sno="+snum;
			System.out.println(query);
			int count=0;
			if(st!=null)
			count=st.executeUpdate(query);
			
			if(count==0)
				System.out.println("No Records Deleted");
			else
				System.out.println("Number Records are get Effected::"+count);
		}//try
		catch(SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
				System.out.println("Mistake in Sql Query");
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(st!=null)
					st.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
		
		
		
		
	}//main
	
	
	
}//class
