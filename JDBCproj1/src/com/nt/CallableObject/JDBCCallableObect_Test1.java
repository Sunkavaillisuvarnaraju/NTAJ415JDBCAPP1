package com.nt.CallableObject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class JDBCCallableObect_Test1 {
	private static final String callable_procedure="{CALL first_pro(?,?,?) }";
	
public static void main(String[] args) {
	//read inputs
	int first=0,second=0;
	try(Scanner sc=new Scanner(System.in)){
		if(sc!=null) {
			System.out.println("Enter first value::");
			first=sc.nextInt();
			System.out.println("Enter second value::");
			second=sc.nextInt();
			
		}//if
		
		//establish the connection
		try(Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");
			CallableStatement cs=con.prepareCall(callable_procedure);){
			//register out parameter
			if(con!=null)
				cs.registerOutParameter(3, Types.INTEGER);
			//set values to parameters
			if(cs!=null) {
			cs.setInt(1, first);
			cs.setInt(2, second);
		}//if
			//execute the query
			if(cs!=null)
				cs.execute();
			int result=0;
			if(cs!=null)
				result=cs.getInt(3);
			System.out.println("SUM IS::"+result);
		}//try2
	}//try1
	catch(Exception e) {
		e.printStackTrace();
	}
	}//main
}//class
