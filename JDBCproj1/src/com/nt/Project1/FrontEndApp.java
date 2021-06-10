package com.nt.Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * This Application is meant for Login to one particular Apllication If he is a old customer to that particular Website 
 * 		The Person who is new to this particular Website He Should do Register With that Website
 * 
 * 															Using queries are
 * 		INSERT INTO IRCTC2021 VALUES(01, 'raju',21,9553372344);
 *  
 */




public class FrontEndApp {

	public static void main(String[] args) {
		//To Read Input from EndUser we are using Scanner class
		Scanner sc=null;
		int ch=0;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			sc=new Scanner(System.in);
			System.out.println("1.Register\t         2.Login");
			ch=sc.nextInt();

			//Load the class into JVM
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Create connection Object
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nani123");

			//create Statement Object
			if(con!=null)
				st=con.createStatement();

			//prepare sql query
			//String query="INSERT INTO IRCTC2021 VALUES(1001,'RAJU',21,9533189847,'Nani','hyd'";




			switch(ch){
			case 1 :
				System.out.println("Enter Your AAdhar Number::");
				long cno=sc.nextInt();
				System.out.println("Enter Your Name::");
				String name=sc.next();
				sc.nextLine();
				System.out.println("Enter Your Age::");
				int age=sc.nextInt();
				System.out.println("Enterr your Mobile Number::");
				long mnum=sc.nextLong();
				System.out.println("Create UserName (No special characters are allowed)::");
				String uName=sc.next();
				sc.nextLine();
				System.out.println("Create password");
				String pass=sc.nextLine();

				name="'"+name+"'";//gives 'Nani' 
				uName="'"+uName+"'";
				pass="'"+pass+"'";

				String query="INSERT INTO IRCTC2021 VALUES("+cno+","+name+","+age+","+mnum+","+uName+","+pass+")";
					System.out.println(query);
				int count=0;
				count=st.executeUpdate(query);
				if(count==0)
					System.out.println("Failed to Register");
				else
					System.out.println("Registration sucessfull");
			
			case 2 :
				
				
			}//switch








		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}//class

}//class
