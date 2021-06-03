package com.nt.jdbc.SelectQueries.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Date MAY-22

public class Assignment_Test05 {
			
					public static void main(String[] args) {
						//Read the input from the End User
						Scanner sc =null;
						String cityName1=null,cityName2=null,cityName3=null;
						Connection con =null;
						Statement st=null;
						ResultSet rs=null;
						
						  		try {
						  			sc=new Scanner(System.in);
						  			if(sc!=null) {
						  				System.out.println("Enter City 1::");
						  				cityName1=sc.next();
						  				System.out.println("Enter City 2::");
						  				cityName2=sc.next();
						  				System.out.println("Enter City 3:: ");
						  				cityName3=sc.next();
						  			}//if
						  			cityName1="'"+cityName1+"'";
						  			cityName2="'"+cityName2+"'";
						  			cityName3="'"+cityName3+"'";
						  			
						  			//Load the class into JVM
						  			Class.forName("oracle.jdbc.driver.OracleDriver");
						  			
						  			//Establish the connection with DB S/W
						  			
						  			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Nani123");
						  		
						  			//create statement
						  			if(con!=null)
						  				st=con.createStatement();
						  			//prepare a ResultSet  to send and execute sql query
						  			//select sno,sname,scourse,savg,scity from student where scity in('hyd','vizag','kakinada');
						  			String query ="select sno,sname,scourse,savg,scity from student where scity in("+cityName1+","+cityName2+","+cityName3+")";
						  			System.out.println(query);
						  			if(st!=null)
						  				rs=st.executeQuery(query);
						  			 System.out.println("The Student Details are");
						  			 boolean flag =false;
						  			while(rs.next()) {
						  				 flag=true;
						  				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getString(5));
						  				
						  			}//while
						  			if(flag==false) {
						  				System.out.println("No Records Found::");
						  			}
						  		}//try
						  		catch(SQLException se) {
						  			se.printStackTrace();
						  		}//catch
						  		catch(Exception e) {
						  			e.printStackTrace();
						  		}//catch
						  		finally {
						  			try {
						  				if(rs!=null)
						  					rs.close();
						  			}catch(Exception e) {
						  				e.printStackTrace();
						  			}
						  			try {
						  				if(st!=null)
						  					rs.close();
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
