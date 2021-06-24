package com.nt.jdbc.postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PostGreSQL_Test3 {

	public static void main(String[] args) {
		String name=null;
		String query=null;
		try(Scanner sc=new Scanner(System.in)){
			if(sc!=null) {
				System.out.println("Enter Product Name::");
				name=sc.next();
			}//if
			name="'"+name+"'";
			query="select status from product where pname="+name;
			try(Connection con=DriverManager.getConnection("jdbc:postgresql:NTAJ415DB","postgres","tiger");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);	){
				//process the ResultSet Object
				if(rs!=null) {
					boolean flag=false;
					while(rs.next()) {
						flag=true;
						System.out.println(rs.getString(1));
					}//while
					if(flag==false) {
						System.out.println("No Records Found::");
					}
				}//if
				
				
			}//try2
						
		}//try1
		catch(Exception e) {
			System.out.println("Error in query");
			e.printStackTrace();
		}
		
		
		

	}//main

}//class
