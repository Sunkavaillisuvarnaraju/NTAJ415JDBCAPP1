package com.nt.jdbc.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 *  This App is Developed for Reading the 
 *  default DEPT table information form DB S/W and Displaying on console
 *  Author  & Application Developed BY : S.S.Raju
 */
public class Assignment_Test01 {
	public static void main(String[] args)throws Exception{
		//Loading the class into JVM
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establish the connection to DataBase S/W
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
		 
		//create statement on con object to execute sql queries
		
		Statement st =con.createStatement();
		
		// create ResultSet object to retrive the data from the DB s/w
		ResultSet rs=st.executeQuery("SELECT *FROM DEPT");
		
		System.out.println("\tDepartment Details");
		System.out.println("DEPTNO\t  Dname\t \t\t  Loc");
		while(rs.next()) {
			System.out.println("\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3));
		}
		con.close();
		
	}

}
