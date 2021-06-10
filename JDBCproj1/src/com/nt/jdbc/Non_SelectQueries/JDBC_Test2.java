package com.nt.jdbc.Non_SelectQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * This Application is Developed to perform Update operation on DataBase
 * 					Developed on-may 27
 *   updating sname,average,adress based on student number;
 */

public class JDBC_Test2 {

	public static void main(String[] args) {
		Scanner sc=null;
		String sname=null;
		int savg=0;
		String sadd=null;
		int sNum=0;
		Connection con=null;
		Statement st=null;

		try {
			sc=new Scanner (System.in);
			System.out.println("Enter Student name:: ");
			sname=sc.nextLine();
			System.out.println("Enter Student Adress");
			sadd=sc.nextLine();
			System.out.println("Enter Student average::");
			savg=sc.nextInt();
			System.out.println("Enter Student Number::");
			sNum=sc.nextInt();

			//Load the class into JVM
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establish the connection to DataBase S/W
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");

			//	Query Requirement 
			sname="'"+sname+"'";
			sadd="'"+sadd+"'";



			//prepare statement object
			if(con!=null)
				st=con.createStatement();

			//query=update student set sname='nani',scity='del',savg=90 where sno=1;

			//prepare sql query  according our requirement
			String query="update student set sname="+sname+","+"scity="+sadd+","+"savg="+savg+"where sno="+sNum;
				System.out.println(query);
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			if(count==0)
				System.out.println("No Records Found");
			else
				System.out.println("Number of Records Get Effected are::"+count);


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
