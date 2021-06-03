package com.nt.jdbc.SelectQueries.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Date -22 MAY
//This Application is meant for to get employee details of given department number ?
// Required query for this Application select empno,ename,job,sal,deptno from emp where deptno=30;
public class Assignment_Test06 {

	public static void main(String[] args) {
       //Scanner class to read the inputs from the EndUser
		Scanner sc=null;
		int empDeptno =0;
		Connection con=null;
		Statement st =null;
		ResultSet rs=null;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Employee Depart Number::");
				empDeptno=sc.nextInt();
			    }
				//Load the Class into JVM
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//Establish the Connection with Oracle Data Base S/W
				
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Nani123");
				
				//Create Statement Object
				if(con!=null)
					st=con.createStatement();
				
				//Prepare for ResultSet
				String query="select empno,ename,job,sal,deptno from emp where deptno="+empDeptno;
				   	if(st!=null)
				   		rs=st.executeQuery(query);
				   	System.out.println(query);
				   	int count=0; 
				   	System.out.println("The Employee Details are::");
				   	while(rs.next()) {
				   		 count++;
				   		 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
				   	 }//while
				   	if(count==0)
				   		System.out.println("Number of Records are::"+count);
				  						
			
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
			try {
				if(sc!=null)
					sc.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}//finally

	}//main

}//class
