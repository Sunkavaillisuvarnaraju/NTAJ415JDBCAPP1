package com.nt.PreparedStatementobj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * Surrogate key To generate primary key column values dynamically
 */


public class JDBC_SurrogateKey_test1 {
	
	private final static String query="INSERT INTO STUDENT1 VALUES(SNO_SEQ1.NEXTVAL,?,?,?)";
	
	public static void main(String[] args) {
	  Scanner sc=null;
	  Connection con=null;
	  PreparedStatement ps=null;
	  try {
		  sc= new Scanner(System.in);
		  int count=0;
		  if(sc!=null) {
		  System.out.println("Enter Number of Students::");
		  count =sc.nextInt(); 
		  }
		  
		  //Load the class into jvm
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  
		  //Establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
		  
		  //prepared statement
		  if(con!=null)
		  ps=con.prepareStatement(query);
		  
		  if(ps!=null && sc!=null) {
			  for(int i=1;i<=count;++i) {
					System.out.println("Enter Student Name::");
					String sname=sc.next();
					System.out.println("Enter Student adress ::");
					String sadd=sc.next();
					System.out.println("Enter student avg::");
					float savg=sc.nextFloat();
					
					ps.setString(1, sname); ps.setString(2, sadd);   ps.setFloat(3, savg);
					
					int result=ps.executeUpdate();
					if(result==0)
						System.out.println("No records Inserted");
					else 
						System.out.println("Records Inserted sucessfully");
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
