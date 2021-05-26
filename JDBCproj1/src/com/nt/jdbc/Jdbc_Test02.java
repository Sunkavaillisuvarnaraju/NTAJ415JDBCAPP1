package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * This is the second application of Jdbc  
 */
public class Jdbc_Test02 {

	public static void main(String[] args)throws Exception {
		//To Load the OracleDriver class into JVM
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Create connection between Java App and DataBase S/W
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
		 
		//create statement on Connection object To send and execute the sql queries
		
		Statement st =con.createStatement();
		
		//create ResultSet obj and store and display the sql queries returned from statement object
		
		ResultSet rs =st.executeQuery("SELECT *FROM STUDENT");
		// Here we have a spl method in ResultSet Interface "next(-)" to display queries in java App
		//To print multiple lines or queries on console we must place this next(-) method in while loop
		
			System.out.println("The student Details are::");
			//System.out.println();
	while(rs.next()) {
		System.out.println("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	}
       con.close();			
 }

}
