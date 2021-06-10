package com.nt.jdbc.Non_SelectQueries.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * This Application is meant for updating or giving hike to employee in the given range using percentage
 * 			Developed Date may-27 
 *    			using Query
 *    		update emp1 set sal=500 where sal>=1000 and sal<=2000;
 *    Write a JDBC Application to hike employee salary for given percentage for the employees whose salary is in the given range
 */

public class JDBC_Assignment2 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int per=0;
		int result=0;
		try {
			sc=new Scanner(System.in);
			//System.out.println("Enter The Percentage of the salary to give hike::");
			//per=sc.nextInt();



			//Load the class into jvm
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");

			//create statement object
			if(con!=null)
				st=con.createStatement();

			String query="SELECT * FROM EMP1 WHERE SAL>=500 AND SAL<=2500";

			//process the resultset query
			if(st!=null)
				rs=st.executeQuery(query);
			while(rs.next()) {
				result=rs.getInt(4);
				/*//System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4));
				System.out.println(result);
				
				per=result*20%100+result;
				System.out.println(per);*/
				
			//	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
				System.out.println(result);
				

				per=result*20/100+result;
			//	System.out.println(per);
				String query2="UPDATE EMP1 SET SAL ="+per+" WHERE SAL>=500 AND SAL<=1500";
				int count=st.executeUpdate(query2);
				if(count==0)
						System.out.println("No Records are Updated");
				else
					System.out.println(count+"Records are Updated");
							
							
			}//while
			
					
			//process the update query
			
			

			//process the resultset query
			if(st!=null)
				rs=st.executeQuery(query);
			while(rs.next()) {
				result=rs.getInt(4);
				System.out.println(result);
			}
			
			
			
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
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
