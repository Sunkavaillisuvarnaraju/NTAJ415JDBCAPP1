package com.nt.jdbc.SelectQueries.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * This Application is meant for finding the nth highest salary of a employee using dense_rank()
 * 
 * Assignment Date-May 26
 */



public class Assignment_Test07 {

			public static void main(String[] args) {
				Scanner sc=null;
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				int salaryRange=0;
				try {
					sc= new Scanner (System.in);
				    	if(sc!=null) {
				    		System.out.println("Enter the number to find nth highest salary in emp table");
				    		salaryRange=sc.nextInt();//gives 1
				    	}//if
				    	//salaryRange="&n"+salaryRange;
				    	
				    	//Load the class into JVM
				    	Class.forName("oracle.jdbc.driver.OracleDriver");
				    	
				    	//establish the connection 
				    		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
				    		
				    		//create Statement object 
				    	 if(con!=null)
				    		 st=con.createStatement();
				    	 
				    	 //Prepare sql query
				    	 String query="select * from(select ename, sal, dense_rank() over(order by sal desc)r from emp) where r="+salaryRange;
				    	 System.out.println(query);
				    	
				    	 	//process the ResultSet
				    	 if(st!=null)
				    	 rs=st.executeQuery(query);
				    	 boolean flag=false;
				    	 while(rs.next()) {
				    		 flag=true;
				    		 		System.out.println(rs.getString(1)+"   "+rs.getInt(2));
				    		 
				    	 }//while
				    	 if(flag==false)
				    		 System.out.println("No Recors found");
				    	 
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
