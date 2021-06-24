package com.ps.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;



public class Test03 {
	private static final String query="SELECT SID,SNAME,SDOB,SDOJ,SDOM FROM STUDENT_INFO_DETAILS WHERE SDOB>=? AND SDOB<=?";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sdob=null,edob=null;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
		  System.out.println("Enter Starting DOB::");
		   sdob=sc.next();
		  System.out.println("Enter Ending DOB::");
		 edob=sc.next();
			}
			//converting string into java.util.Date obj
			SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
			java.sql.Date ssqdob=new java.sql.Date(sdf1.parse(sdob).getTime());
			java.sql.Date essdob=new java.sql.Date(sdf1.parse(edob).getTime());
			
			
		  //Load the class into jvm
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  
		  //Establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Nani123");
		  
		  //create preparestatement object
		  if(con!=null)
		ps=con.prepareStatement(query);
		
		//set values to the query
		if(ps!=null) {
		ps.setDate(1, ssqdob);
		ps.setDate(2, essdob);
		}
		//execute the query
		if(ps!=null)
		rs=ps.executeQuery();
		
		//process the ResultSet
		if(rs!=null) {
			boolean flag =false;
			while(rs.next()) {
				flag=true;
				int sid=rs.getInt(1);
				String sname=rs.getString(2);
				java.sql.Date sqdob=rs.getDate(3);
				java.sql.Date sqdoj=rs.getDate(4);
				java.sql.Date sqdom=rs.getDate(5);
				
				//converting java.sql.date values into String 
					SimpleDateFormat sdf2=new SimpleDateFormat("dd-MM-yyyy");
				     String dob=sdf2.format(sqdob);
				     String doj =sdf2.format(sqdoj);
				     String dom=sdf2.format(sqdom);
				     System.out.println(sid+"  "+sname+"  "+dob+"  "+doj+"  "+dom);			
				
			}//while
				if(flag==false)
						System.out.println("No Records are available::");
		}//if
		  
						
			
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
	
		
		
		
		
		
		
		
		
		
		
   }//MAIN
	
}//CLASS
