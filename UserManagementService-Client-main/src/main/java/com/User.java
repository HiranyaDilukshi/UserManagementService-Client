package com;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Users;

	
	

	public class User {

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
		
		public String readUsers()
		{ 
			String output = ""; 
			 
			 try
			 { 
				 Connection con = connect(); 
				 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for reading."; 
				 } 
				 
				 
				 // Prepare the html table to be displayed
				 output = "<table border='1' class='table'><tr><th>Electricity Account No"
				 		+ "</th><th scope='col'>User Name</th>" +
				 "<th scope='col'>User Email</th>" + 
				 "<th scope='col'>Contact Number</th>" +
				 "<th scope='col'>User Address</th>" +
				 "<th scope='col'>User NIC</th>" +
				 "<th scope='col'>Update</th><th>Remove</th></tr>"; 
				 
				 String query = "select * from cusdetails"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String userid = Integer.toString(rs.getInt("userid")); 
					 String accountno = Integer.toString(rs.getInt("accountno"));
					 String username = rs.getString("username"); 
					 String useremail = rs.getString("useremail"); 
					 String userphone = Integer.toString(rs.getInt("userphone")); 
					 String useraddress = rs.getString("useraddress");
					 String usernic = rs.getString("usernic");
					 
					 // Add into the html table
					 output += "<tr><td><input id='hidUserIDUpdate' name='hidUserIDUpdate' type='hidden' value='"+ userid + "'>" + accountno + "</td>";
					 output += "<td>" + username + "</td>"; 
					 output += "<td>" + useremail + "</td>"; 
					 output += "<td>" + userphone + "</td>";
					 output += "<td>" + useraddress + "</td>"; 
					 output += "<td>" + usernic + "</td>"; 
					 
					 // buttons
					 output += "<td><input name='btnUpdate' id ='" + userid + " ' type='button' value='Update' class=' btnUpdate btn btn-secondary'></td><td>"
						 		+ "<input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-userid='"+ userid + " '>" + "</td></tr>";  
				 }
				 
				 con.close(); 
				 // Complete the html table
				 output += "</table>"; 
			 } 
			 
			 catch (Exception e) 
			 { 
				 output = "Error while reading users."; 
				 System.err.println(e.getMessage()); 
			 }
			 
			 return output; 
		}

		public String insertUser(String accno, String username, String email, String phone,String address,String nic) 
	    {
			 String output = ""; 
			 
			 try
			 { 
				 Connection con = connect();
				 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for inserting."; 
				 } 
				 // create a prepared statement
				 String query = " insert into cusdetails (`userid`,`accountno`,`username`,`useremail`,`userphone`,`useraddress`,`usernic`)"
				 + " values (?, ?, ?, ?, ?,?,?)"; 
				 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				 preparedStmt.setInt(1, 0); 
				 preparedStmt.setString(2, accno); 
				 preparedStmt.setString(3, username); 
				 preparedStmt.setString(4, email);  
				 preparedStmt.setString(5, phone);
				 preparedStmt.setString(6, address);
				 preparedStmt.setString(7, nic);
				 
				 // execute the statement
				
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "User Data Added Successfully"; 
			 } 
				
	        	 catch (Exception e) 
			 { 
				 output = "{\"status\":\"error\", \"data\":\"Error while inserting user.\"}";
				 System.err.println(e.getMessage()); 
			 }
			 
			 return output; 
				 
				 
	    
	     
		
	    }
		public String updateUser(String userid, String accno, String username, String email, String phone,String address,String nic)
		{  
			String output = ""; 
		 
		 try
		 { 
			 Connection con = connect();
			 
			 if (con == null) 
			 {
				 return "Error while connecting to the database for updating."; 
			 } 
			 
			 // create a prepared statement
			 String query = "UPDATE cusdetails SET accountno=?,username=?,useremail=?,userphone=?,useraddress=?,usernic=?"
			 		+ " WHERE userid=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(accno)); 
			 preparedStmt.setString(2, username); 
			 preparedStmt.setString(3, email); 
			 preparedStmt.setInt(4, Integer.parseInt(phone)); 
			 preparedStmt.setString(5, address); 
			 preparedStmt.setString(6, nic); 
			 preparedStmt.setString(7, userid);
			 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 String newUsers = readUsers();
			 output = "{\"status\":\"success\", \"data\": \"" +newUsers + "\"}";
			
		 } 
		catch (Exception e) 
		 { 
			output = "{\"status\":\"error\", \"data\":\"Error while updating the item.\"}";
			 System.err.println(e.getMessage()); 
		 } 
		return output; 

					
				 } 
			
				
		

		public String deleteUser(String userIDData)
		{ 
				String output = ""; 
				try
			    { 
					 Connection con = connect(); 
					 if (con == null) 
					 { 
						 return "Error while connecting to the database for deleting."; 
					 } 
				 // create a prepared statement
					 String query = "delete from cusdetails where userid=?"; 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 // binding values
					 preparedStmt.setInt(1, Integer.parseInt(userIDData)); 

					 // execute the statement
					 preparedStmt.execute(); 
					 con.close(); 
					
					 String newUsers = readUsers();
					 output = "{\"status\":\"success\", \"data\": \"" +
			    newUsers + "\"}";
					 
				} 
				catch (Exception e) 
				{ 
					output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}"; 
					 System.err.println(e.getMessage()); 
			    } 
				return output; 
			}


		
	}
	


