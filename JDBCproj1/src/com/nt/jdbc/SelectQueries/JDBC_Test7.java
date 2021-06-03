package com.nt.jdbc.SelectQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * This Application is meant for counting number of students available in the Student DataBase table  
 */


public class JDBC_Test7 {

	public static void main(String[] args) {
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;


		try {
			//Load the class into JVM 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establish the connection with database s/w
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");

			//Create  Statement Object
			if(con!=null)
				st=con.createStatement();

			//select the query
			//SELECT COUNT(*) FROM STUDENT;
			String query="select count(*) from student";
			System.out.println(query);
			//proces the resultset
			if(st!=null)
				rs=st.executeQuery(query);

			if(rs!=null) {
				rs.next();
				int count=rs.getInt("count(*)");
				System.out.println("Number of Records in Student DataBase Table::"+count);
			}

		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
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

		}//finally
	}//main



}//class
