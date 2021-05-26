package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Statement;

public class JdbcTest01 {
	public static void main(String[] args)throws Exception{
		//Load the OracleDriver class into JVM 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//create Connection and register with DriverManager service
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
		//create statement
		//Statement st = con.createStatement();
		//create ResultSet object with Statement Object
		if(con!=null) {
			System.out.println("Connection Established");			
		}
		else {
			System.out.println("Connection not Established");
		}
		
	}

}
