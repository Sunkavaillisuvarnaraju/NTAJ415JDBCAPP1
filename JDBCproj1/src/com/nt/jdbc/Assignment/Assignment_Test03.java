package com.nt.jdbc.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment_Test03 {

	public static void main(String[] args)throws Exception {
	//Importing Scanner class to read the values from enduser
		Scanner sc= new Scanner(System.in);
		//Declare the variables
		System.out.println("Enter MIN AVG Marks of student");
		int minAvg =sc.nextInt();
		System.out.println("Enter Max AVG Marks of student");
		int maxAvg = sc.nextInt();
		//Load the JDBC class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 //establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Nani123");
		//create statement object
		Statement st = con.createStatement();
		//process the ResultSet
		//select one query and store it in one string variable and pass that string variable as parameter to executeQuery(-)
		String query="SELECT SNO,SNAME,SCOURSE,SAVG FROM STUDENT WHERE SAVG>="+minAvg+"AND SAVG<="+maxAvg;
		ResultSet rs =st.executeQuery(query);
		System.out.println("Student details are::");
		int count=0;
        while(rs.next()) {
        	count++;
        	System.out.println("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
        }//while
        if(count==0) {
        	System.out.println("No Records found");
        }//if
        con.close();
	}

}
