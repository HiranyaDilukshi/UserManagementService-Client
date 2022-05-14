package com;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


	
	

	public class Login {

		public Connection connect()
		{
		 Connection con = null;

		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid", 
					 "root", ""); 
			 
			 
		 //For testing
		 System.out.print("Successfully connected");
		 }
		 
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

		 return con;
		}
		
		
		
		
		public String login(String un, String pw)
		{
		 String output = "";
		if (!un.equals("admin"))//Hard coded test value
		 {
		 output = "Invalid username";
		 }
		else if (un.equals("admin"))//Hard coded test value
		 {
		 if (!pw.equals("password123"))//Hard coded test value
		 {
		 output = "Invalid password";
		 }
		 else if (pw.equals("password123"))//Hard coded test value
		 {
		 output = "success";
		 }
		 }
		return output;
		}



		
	}
	


