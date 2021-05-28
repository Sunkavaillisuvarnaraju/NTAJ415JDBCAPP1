package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Application is meant for Establishing connecting with the MySql DataBase S/W

public class JDBC_MYSQLTest01 {
				public static void main(String[] args)throws Exception {
						//Load the Class into the JVM
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//Establishing the connection with DriverManager Service
					Connection con = DriverManager.getConnection("jdbc:mysql:///student", "root", "root");
					
					//create the statement object
					Statement st= con.createStatement();
					
					//create ResultSet obj with statement reference variable
					String query ="SELECT *FROM JAVASTUDENT";
					ResultSet rs=st.executeQuery(query);
					System.out.println("The Student Details are::");
					while(rs.next()) {
						System.out.println("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
					}
				}
}
