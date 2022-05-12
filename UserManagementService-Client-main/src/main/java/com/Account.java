package com;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



	
	

	public class Account {

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
		
		public String readAccounts()
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
				 		+ "</th><th scope='col'>Premises ID</th>" +
				 "<th scope='col'>Area Office</th>" + 
				 "<th scope='col'>Tariff Type</th>" +
				 "<th scope='col'>Update</th><th>Remove</th></tr>"; 
				 
				 String query = "select * from accdetails"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
				
					 String accountid = Integer.toString(rs.getInt("accountid")); 
					 String accountno = Integer.toString(rs.getInt("accountno"));
					 String premisesid = rs.getString("premisesid"); 
					 String areaoffice = rs.getString("areaoffice"); 
					 String tarifftype = rs.getString("tarifftype"); 
					 
					 // Add into the html table
					 output += "<tr><td><input id='hidAccountIDUpdate' name='hidAccountIDUpdate' type='hidden' value='"+ accountid + "'>" + accountno + "</td>";
					 output += "<td>" + premisesid + "</td>"; 
					 output += "<td>" + areaoffice + "</td>"; 
					 output += "<td>" + tarifftype + "</td>";
					
					 
					 // buttons
					 output += "<td><input name='btnUpdate' id ='" + accountid + " ' type='button' value='Update' class=' btnUpdate btn btn-secondary'></td><td>"
						 		+ "<input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-accountid='"+ accountid + " '>" + "</td></tr>";  
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

		public String insertAccount(String accountno, String premisesid, String areaoffice,String tarifftype) 
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
				 String query = " insert into accdetails (`accountid`,`accountno`,`premisesid`,`areaoffice`,`tarifftype`)"
				 + " values (?, ?, ?, ?, ?)"; 
				 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				 preparedStmt.setInt(1, 0); 
				 preparedStmt.setString(2, accountno); 
				 preparedStmt.setString(3,  premisesid); 
				 preparedStmt.setString(4, areaoffice);  
				 preparedStmt.setString(5, tarifftype);
				 
				 // execute the statement
				
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Electricity Account Details Inserted successfully"; 
			 } 
				
	        	 catch (Exception e) 
			 { 
				 output = "{\"status\":\"error\", \"data\":\"Error while inserting user.\"}";
				 System.err.println(e.getMessage()); 
			 }
			 
			 return output; 
				 
				 
	    
	     
		
	    }
		public String updateAccount(String accountid, String accno, String premisesid, String areaoffice, String tarifftype)
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
			 String query = "UPDATE accdetails SET accountno=?,premisesid=?,areaoffice=?,tarifftype=?"
				 		+ " WHERE accountid=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(accno)); 
			 preparedStmt.setString(2, premisesid); 
			 preparedStmt.setString(3, areaoffice); 
	         preparedStmt.setString(4, tarifftype); 
	         preparedStmt.setInt(5, Integer.parseInt(accountid));
			 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 String newAccounts = readAccounts();
			 output = "{\"status\":\"success\", \"data\": \"" +newAccounts + "\"}";
			
		 } 
		catch (Exception e) 
		 { 
			output = "{\"status\":\"error\", \"data\":\"Error while updating the Account.\"}";
			 System.err.println(e.getMessage()); 
		 } 
		return output; 

					
				 } 
			
				
		

		public String deleteAccount(String accountIDData)
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
					 String query = "delete from accdetails where accountid=?"; 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 // binding values
					 preparedStmt.setInt(1, Integer.parseInt(accountIDData)); 

					 // execute the statement
					 preparedStmt.execute(); 
					 con.close(); 
					
					 String newUsers = readAccounts();
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
	


