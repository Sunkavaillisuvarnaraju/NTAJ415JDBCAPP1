package com.nt.jdbc.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment_Test04 {

	public static void main(String[] args)throws Exception {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter starting Department Number");
      int startDep = sc.nextInt();
      System.out.println("Enter Ending Department Number");
      int endDep=sc.nextInt();
      //Load the class into the jvm
      Class.forName("oracle.jdbc.driver.OracleDriver");
      //Establish the connection
       Connection con=DriverManager.getConnection("jdb:oracle:thin:@localhost:1521:xe","system","Nani123");
       //create Statement object
       Statement st= con.createStatement();
       //select one query according to our requirement
       //select deptno,dname,loc from dept where deptno>=10 and deptno<=30;
       //store this query in one string varible
       String query ="select deptno,dname,loc from dept where deptno>="+startDep+"AND deptno<="+endDep;
       //process the resultset
       ResultSet rs =st.executeQuery(query);
       boolean flag=false;
       while(rs.next()) {
    	   flag=true;
    	   System.out.println("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
       }//while close
       if(flag==false) {
    	   System.out.println("No Records Found");
       }
    	   con.close();
	}

}
