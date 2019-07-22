package com.hibernate;

import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		
		String url = "jdbc:mysql://localhost:3306/hibernate_db?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {

			DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection Successfull");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
