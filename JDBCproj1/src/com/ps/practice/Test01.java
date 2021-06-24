package com.ps.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;



public class Test01 {
	private static final String Insert_Query="INSERT INTO STUDENT_INFO_DETAILS VALUES(SID_SEQ.NEXTVAL,?,?,?,?)";

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		Scanner sc=null;
		try {
			String sname=null,sdob=null,sdoj=null,sdom=null;
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Student Name::");
				sname=sc.next();
				System.out.println("Enter Date of Birth::(dd-MM-yyyy)::");
				sdob=sc.next();
				System.out.println("Enter Date of Joining(yyyy-MM-dd)");
				sdoj=sc.next();
				System.out.println("Enter Date of Marriage(MMM-dd-yyyy)");
				sdom=sc.next();
			}//if
			//converting string into java.util.date class object
			SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date udob=sdf1.parse(sdob);
			//convert java.util.date class object into java.util.sql class object
			long ms=udob.getTime();
			java.sql.Date sqdob= new java.sql.Date(ms);
			//converting 2nd string we no need to convert (yyyy-MM-dd) formate into  java.util.date class object becuse data base s/w 
			// containg same pattern implicitly

			java.sql.Date sqdoj=java.sql.Date.valueOf(sdoj);
             //converting 3rd variable into string into java.util.Date class object
			SimpleDateFormat sdf2= new SimpleDateFormat("MMM-dd-yyyy");
			java.util.Date udoj= sdf2.parse(sdom);
			//converting java.util.Date class object into java.sql.Date class object
		      ms=udoj.getTime();
		      java.sql.Date sqdom=new java.sql.Date(ms);
		    //Load the class into JVM
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      //Establish the connection Database s/w
		      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
		      //execute the query
		      ps=con.prepareStatement(Insert_Query);
		      //set the values to the query
		      ps.setString(1, sname);
		      ps.setDate(2, sqdob);
		      ps.setDate(3, sqdoj);
		      ps.setDate(4, sqdom);
		     //process the query
		      int count=0;
		      if(ps!=null)
		    	  count=ps.executeUpdate();
		      if(count==0)
		    	  System.out.println("No Records are Inserted::");
		      else
		    	 System.out.println("Records Inserted sucessfullly::");
				      
      }//try
		catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
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
			}try {
				if(sc!=null)
					sc.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}//finally

	}//main



}//class
