package com.nt.jdbc.postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PostGreSQL_Test2 {
   private static final String INSERT_QUERY="INSERT INTO PRODUCT VALUES(NEXTVAL('PID_SEQ'),?,?,?,?)";
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
		}//try1
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		int count =0;
		try (Scanner sc=new Scanner(System.in)){
			if(sc!=null) {
			System.out.println("Enter Number products to Enter::");
			count=sc.nextInt();
			}//if
			//establish the connection 
			try(Connection con=DriverManager.getConnection("jdbc:postgresql:NTAJ415DB","postgres","tiger");
				PreparedStatement ps=con.prepareStatement(INSERT_QUERY);		){
				//read input values from the en user
				if(ps!=null && sc!=null) {
					for(int i=0;i<count;i++) {
					System.out.println("Enter product name::");
					String name=sc.next();
					System.out.println("Enter product price::");
					float price=sc.nextFloat();
					System.out.println("Enter product quantity::");
					float qty=sc.nextFloat();
					System.out.println("Enter product status::");
					String status=sc.next();
					//set values to the prepared statement object
					ps.setString(1, name);  ps.setFloat(2, price);  ps.setFloat(3, qty); ps.setString(4, status);			
					
					int result=ps.executeUpdate();
					if(result==0) 
						System.out.println("No records are inserted::");
					else
						System.out.println("Records are Inserted Sucessfully::");
						
					
					}//for
				}//if
				
				
				
				
			}//try3
			
		
	}//try2
		
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}//main
	
	
}//class
