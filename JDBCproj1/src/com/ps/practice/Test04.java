package com.ps.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test04 {
	private static final String ora_Query="SELECT SNO,SNAME,SCOURSE,SAVG,SCITY FROM STUDENT"; 
	private static final String mysql_query="INSERT INTO JAVASTUDENT VALUES(?,?,?,?,?)";


	public static void main(String[] args) {
		Connection oracon=null,mysqlcon=null;
		Statement st=null;
		ResultSet rs=null;
		PreparedStatement ps=null;


		try {
			//Load the class into JVM
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");


			//Establish the Connection
			oracon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Nani123");
			mysqlcon=DriverManager.getConnection("jdbc:mysql:///student", "root","root");

			//create statement object
			if(oracon!=null)
				st=oracon.createStatement();

			if(mysqlcon!=null)
				ps=mysqlcon.prepareStatement(mysql_query);
			//send and execute  SELECT QUERY in oracle DB/SW and get resultSet object
			if(st!=null)
				rs=st.executeQuery(ora_Query);
			//gather each record of RS object and insert into mysql DB s/w
			if(rs!=null && ps!=null) {
				while(rs.next()) {
					//gather each record from RS
					int no=rs.getInt(1);
					String sname=rs.getString(2);
					String scourse=rs.getString(3);
					int savg=rs.getInt(4);
					String scity=rs.getString(5);
					

					//set values to ps object
					ps.setInt(1, no);
					ps.setString(2, sname);
					ps.setString(3, scourse);
					ps.setString(4, scity);
					ps.setFloat(5, savg);
					ps.executeUpdate();

				}//while
				System.out.println("Records are copied from oracle to mysql sucessfully ");
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
				if(oracon!=null)
					oracon.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(mysqlcon!=null)
					mysqlcon.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

		}//finally

	}//main

}//class
