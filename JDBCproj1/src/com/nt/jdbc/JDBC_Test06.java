package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*This Application is meant for Reading Department Number from EndUser and Displaying the Department Details
 *  																		Deveoloped on MAY-26
 * 		Author:: S.S.Raju
 */


public class JDBC_Test06 {


	public static void main(String[] args) {

		//To Read Data from the enduser We are using Scanner class 
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		int departmentNumber=0;
		try {
			sc= new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter DepartMent Number ::");
				departmentNumber =sc.nextInt();
			}	
			//Load the class into the JVM
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establish the connection with oracle DB S/W

			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"," system", "Nani123");

			//create statement object
			if(con!=null) {
				st=con.createStatement();
			}
			//process the resultset 
			//Arrange suitable query according to our requirement
			//select deptno,dname,loc from dept where deptno=40;
			String query="select deptno,dname,loc from dept where deptno="+departmentNumber;
			System.out.println(query);
			if(st!=null) {
				rs=st.executeQuery(query);
			}
			System.out.println("The employee Details are::");
			int count=0;
			if(rs.next()) {
				count++;
				System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"   "+rs.getString(3));
			}
			if(count==0) {
				System.out.println("No Records Found::"+count);
			}

		}//try
		catch(SQLException se) {
			if(se.getErrorCode()>=900&&se.getErrorCode()<=999) 
			   System.out.println("Check your column name and Sql query");	
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
			try {
				if(sc!=null)
					sc.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
		}//finally
		
		
	}//main

}//class
