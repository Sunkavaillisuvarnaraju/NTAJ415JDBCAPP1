package com.nt.jdbc.postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostGreSQL_Test1 {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");			
		}//try1
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try(
				//establish the connection
				//Connection con= DriverManager.getConnection("jdbc:postgresql:NTAJ415DB","postgres","tiger");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/NTAJ415DB","postgres","tiger");
				
				//Create the statement object
				Statement st=con.createStatement();
				
				//Send and execute the query
				ResultSet rs=st.executeQuery("SELECT PID,PNAME,PRICE,QTY,STATUS FROM PRODUCT");){
			 //PROCESS THE RESULTSET OBJECT
			if(rs!=null) {
				boolean flag=false;
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4)+"  "+rs.getString(5));
				}//while
			}//if
		}//try2
		catch(Exception e) {
			e.printStackTrace();
		}
					
	}//main

}//class
