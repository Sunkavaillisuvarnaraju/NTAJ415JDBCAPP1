package com.nt.jdbc.SelectQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//MAY-24

//This Application is meant for to find employee Details using starting of the employee


public class JDBC_Test4 {

	public static void main(String[] args) {
			Scanner sc=null;
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;		
			String endLetter=null;
			try {
				sc=new Scanner(System.in);
				if(sc!=null) {
					System.out.println("Enter Employee starting Letter::");
				  endLetter=sc.next().toUpperCase();
				}	  
				endLetter="'"+endLetter+"%"+"'";
				//prepare sql query
				//select empno,ename,job,sal,deptno from emp where ename like 'A%';
				String query ="select empno,ename,job,sal,deptno from emp where ename like"+endLetter;
				
				//Load the JDBC class into JVM
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//Establish the connection
				
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
				
				if(con!=null) {
					st=con.createStatement();
				}
				//Prepare ResultSet
				if(st!=null) {
				rs=st.executeQuery(query);
				}
				System.out.println(query);
				System.out.println("The Employee Details are::");
				int count=0;
				while(rs.next()) {
				 count++;
					System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4)+"  "+rs.getInt(5));
				
				}//while
				
				if(count==0) {
					System.out.println("No Records Found::"+count);
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
				try {
					if(sc!=null)
						sc.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}//finally

	}//main

}//class
