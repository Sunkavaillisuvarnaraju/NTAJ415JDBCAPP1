package com.nt.jdbc.SelectQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * This Application is meant for retriving employee maximum salary from employee database table
 * 							Application developed Date-----MAY-26
 */

public class JDBC_Test8 {

	public static void main(String[] args) {
		Connection con	=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//Load the class into JVM 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establish the connection with database s/w
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");

			//create statement object
			if(con!=null)
				st=con.createStatement();
   //select empno,ename,job,sal from emp where sal=(select max(sal) from emp);
			//process the resultset
			//select suitable query
			String query="select empno,ename,job,sal from emp where sal=(select max(sal) from emp)";
			System.out.println(query);
			if(st!=null) {
				rs=st.executeQuery(query);
			}
			boolean flag=false;
			while(rs.next()) {
				flag=true;
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
			}
           if(flag=false)
        	   System.out.println("No Records Found");

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
			
		}//finally
	}//main


}//class
