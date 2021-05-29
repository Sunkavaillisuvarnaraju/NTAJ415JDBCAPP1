package com.nt.jdbc;

import java.util.Scanner;

//This Application is meant for to find employee Details using starting and ending name of the employee


public class Jdbc_Test04 {

	public static void main(String[] args) {
			Scanner sc=null;
			String endLetter=null;
			try {
				sc=new Scanner(System.in);
				if(sc!=null) {
					System.out.println("Enter Employee starting Letter::");
				  endLetter=sc.next().toUpperCase();
				}	  
				
			}//try

	}

}
