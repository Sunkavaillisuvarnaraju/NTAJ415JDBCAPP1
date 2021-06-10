/*						Using PreparedStatement Object
 *  						============================
 *
 *						 Inserting Students details into Student DB table
 */


package com.nt.PreparedStatementobj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_PS_Test1 {

	private static final String query="INSERT INTO STUDENT VALUES(?,?,?,?,?)";

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			sc=new Scanner(System.in);
			int count=0;
			if(sc!=null) {
				System.out.println("Enter Number of Students::");
				count=sc.nextInt();
			}
			//Load the Class into JVM
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");

			//create prepare statement object
			if(con!=null)
				ps=con.prepareStatement(query);

			if(ps!=null && sc!=null) {
				for(int i=1;i<=count ; i++) {
					System.out.println("Enter Student Number");
					int sno=sc.nextInt();
					System.out.println("Enter Student Name::");
					String sname=sc.next();
					sc.nextLine();
					System.out.println("Enter Scourse");
					String scourse=sc.next();
					sc.nextLine();
					System.out.println("Enter Savg::");
					int savg=sc.nextInt();
					System.out.println("Enter Student City::");
					String scity=sc.next();

					//Add the values to the ps object
					ps.setInt(1, sno); ps.setString(2, sname); ps.setString(3, scourse); ps.setInt(4, savg); ps.setString(5, scity);
					
					int result=ps.executeUpdate();
					if(result==0)
						System.out.println("No Records are Inserted");
					else
						System.out.println("Record Inserted Sucessfully");
					
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
