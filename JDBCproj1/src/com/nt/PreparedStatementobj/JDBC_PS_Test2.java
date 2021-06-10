/*
 * This appication is  developed to store Customer Details in Data base software
 */


package com.nt.PreparedStatementobj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_PS_Test2 {

	//TO Modifiy the query esily we are placing pre-compiled sql query on the class level
	private static final String qury="INSERT INTO DMART VALUES(?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con =null;
		PreparedStatement ps=null;
		try {
			sc=new Scanner(System.in);
			int count=0;
			if(sc!=null) {
			System.out.println("Enter Number Customers::");
			count=sc.nextInt();
			}
			//Load the class into JVM
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish the connection with data base software
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
		
			//Prepare statement to send and execute the sql query
			if(con!=null)
			ps=con.prepareStatement(qury);
		if(con!=null && sc!=null) {
			for(int i=1;i<=count;i++) {
				System.out.println("Enter Customer Number::");
				int cno=sc.nextInt();
				System.out.println("Enter Customer Name::");
				String cname=sc.next();
				System.out.println("Enter Customer Adress::");
				String cadd=sc.next();
				
				ps.setInt(1, cno); ps.setString(2, cname);  ps.setString(3, cadd);
				int result=ps.executeUpdate();
				if(result==0)
					System.out.println("Insertion Failed");
				else {
					System.out.println("Insertion Sucessfull");
				}
				}//for
		}//if
									
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			 try {
				 if(ps!=null)
						 ps.close();
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
