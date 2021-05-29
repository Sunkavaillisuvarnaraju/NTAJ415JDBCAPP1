package com.nt.jdbc;

//Date MAY- 22nd


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Requirement to get the emp details from emp table based on their designations

public class JDBC_Test03 {

			public static void main(String[] args) {
				Scanner sc=null;
				Connection con =null;
				Statement st =null;
				ResultSet rs=null;
				String desgn1=null,desgn2=null,desgn3=null;
				try {
				    sc=new Scanner(System.in);
				    if(sc!=null) {
				    System.out.println("Enter Desgn 1 ::");
				    desgn1=sc.next().toUpperCase();
				    System.out.println("Enter Desgn 2::");
				    desgn2=sc.next().toUpperCase();
				    System.out.println("Enter Desgn3");
				    desgn3=sc.next().toUpperCase();
				    }//if
					desgn1="'"+desgn1+"'";
					desgn2="'"+desgn2+"'";
					desgn3="'"+desgn3+"'";
					
					//Load the jdbc class into JVM
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//Establish the connection
					 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Nani123");
					 if(con!=null) 
						 st=con.createStatement();	 
					 
					//prepare SQL Query
					 //SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN('CLERK','MANAGER','SALESMAN')ORDER BY JOB;
					 String query ="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN("+desgn1+","+desgn2+","+desgn3+")ORDER BY JOB";
					 System.out.println(query);
					 //send and execute the query
					 
					 if(st!=null)
						 rs=st.executeQuery(query);
					 
					 if(rs!=null)
						 System.out.println("The Employee Details are::");
					 
					 while(rs.next()) {
						 System.out.println(rs.getInt(1)+" \t"+rs.getString(2)+" \t"+rs.getString(3)+" \t"+rs.getFloat(4));
					 }//while
					 
					 
				}//try
				catch(SQLException se) {
					System.out.println(se.toString());
				}
					catch(Exception e) {
					e.printStackTrace();
					
				}finally {
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
					try {
						if(sc!=null) 
							sc.close();
						
						}catch(Exception e) {
							e.printStackTrace();
					}
				}//finally
			}//main
}//class
