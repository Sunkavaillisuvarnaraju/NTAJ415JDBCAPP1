package com.ps.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Test02 {
	
private static final String query="select sid,sname,sdob,sdoj,sdom from student_info_details";

	public static void main(String[] args) {
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		
		try {
		//Load the class into jvm
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Nani123");
			
			//create prepared statement object
			if(con!=null)
			ps=con.prepareStatement(query);
			
			//execute query
			if(ps!=null)
			rs=ps.executeQuery();
			
			//process the result set object
			if(rs!=null) {
				while(rs.next()) {
					int sid=rs.getInt(1);
					String sname=rs.getString(2);
					java.sql.Date sqbod=rs.getDate(3);
					java.sql.Date sqdoj=rs.getDate(4);
					java.sql.Date sqdom=rs.getDate(5);
					//converting java.sql.Date class object into String 
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String sdob=sdf.format(sqbod);
					String sdoj=sdf.format(sqdoj);
					String sdom=sdf.format(sqdom);
					System.out.println(sid+"  "+sname+"  "+sdob+"  "+sdoj+"  "+sdom  );
					
					
				}//while
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
			
		}//finallly

	}//main

}//class
