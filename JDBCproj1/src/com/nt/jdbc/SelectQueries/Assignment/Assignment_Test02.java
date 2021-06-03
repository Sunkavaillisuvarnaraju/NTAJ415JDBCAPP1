package com.nt.jdbc.SelectQueries.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 							Requirement ::
 * 							===========
 * This Application is meant for finding the max and min sal of the employee 
 * And also those values are reading from end user using Scanner class.
 */

public class Assignment_Test02 {

	public static void main(String[] args) throws Exception {
		 Scanner sc = new Scanner(System.in);
		 // Read First Value from endUser startsalary  
		 System.out.println("Enter Starting salary");
		 String startSal =sc.nextLine();
		// Read Second Value from endUser endSalary
		 System.out.println("Enter Ending Salary");
		 String endSalary=sc.nextLine();
		 
		 //Load the OracleDriver class into the jvm
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 
		 //Establish the connection with DataBase S/W
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");

		 //create Statement with Connection object
		 Statement st=con.createStatement();
		 
		 //select empno,ename,job,sal from emp where sal>=3000 and sal<=5000;
		 String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL>="+startSal+"AND SAL<="+endSalary;
		 //prepare ResultSet based on above query 
		 
		 ResultSet rs= st.executeQuery(query);
		 
		 //create while loop to display all results available in the ResultSet
		 System.out.println("Employee Details are::");
		 while(rs.next()) {
			 System.out.println("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
		 }//End of while loop
		 con.close();
	}//Main End
}
