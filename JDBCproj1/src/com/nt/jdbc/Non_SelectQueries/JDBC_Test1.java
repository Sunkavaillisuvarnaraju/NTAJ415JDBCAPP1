package com.nt.jdbc.Non_SelectQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 			In this Non-SelectQueries we are learning DML commands of SQL 
 *    							-> 	DML commands like
 * 							                ->Insert  
 * 											->Update		
 * 											->Delete
 * 
 * 			In this Application we are learning about how to develop delete operation using DML commands
 */
public class JDBC_Test1 {

	public static void main(String[] args) {
								Scanner sc=null;
							Connection con=null;
							Statement st=null;
							String add=null;
							ResultSet rs=null;
				try {
					
					//Read Input values from End-user
					sc=new Scanner(System.in);
					System.out.println("Enter Student Adress ");
					add=sc.next();//gives hyd
					
					
							//Load the class into JVM
					Class.forName("oracle.jdbc.driver.OracleDriver");
				
					//Establish the connection
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Nani123");
					
					//create statement object
					if(con!=null)
						st=con.createStatement();
					
					add="'"+add+"'";//gives'hyd'
					
					//prepare SQL query
						String query="DELETE FROM STUDENT WHERE SCITY="+add;
					System.out.println(query);
	  							
					int count=0;
					if(st!=null)
						count=st.executeUpdate(query);
					if(count==0)
						System.out.println("No Records are deleted");
					else
						System.out.println(count+"Record Deleted Sucessfully");
				
					
				/*	int fS=10000;
					int per=20;
					int tot=fS*per/100+10000;
					System.out.println(tot);
					*/
					
					
				}//try
				catch(SQLException se) {
					se.printStackTrace();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				
				finally {
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
