package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//This Application is meant for finding the name of an employee whose name is ending with user choice
public class JDBC_Test05 {

	public static void main(String[] args) {
		Scanner sc=null;
		String empEndingLetter=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Ending Letter from Employee Name::");
				empEndingLetter=sc.next().toUpperCase();//gives S
			}
			//SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE '%K';
			empEndingLetter="'"+"%"+empEndingLetter+"'";

			//Load the class into jvm
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establiish the connection with DataBase S/W
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");

			//create Statement object
			st=con.createStatement();

			//prepare ResultSet
			//prepare SQL query
			String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE "+empEndingLetter;
			System.out.println(query);
			rs=st.executeQuery(query);
			System.out.println("The Employee Details are::");
			int count=0;
			while(rs.next()) {
				count++;
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4)+"  "+rs.getInt(5));
			}//while
			if(count==0) 
				System.out.println("No Records Found");


		}//try
		catch(SQLException se) {
			if(se.getErrorCode()>=900&&se.getErrorCode()<=999)
				System.out.println("Invalid Column name or Table Name or SQL Keywords");
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
