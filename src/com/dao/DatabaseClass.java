package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//Class provide the methods for performing different operation on DB
public class DatabaseClass {
	Connection con = null;
	
	//Create the connection
	public void getConnection() {
		try {
			//This loads the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb","root","DeepGar2812#*");
			
			System.out.println("Check if connection is open -: " + con.isValid(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("There has been some problem in creating the connection");
			e.printStackTrace();
		}
	}
	
	public List<GYMMember> getMembers() {
		List<GYMMember> members = new ArrayList<GYMMember>();
		
		if(con==null) {
			this.getConnection();
		}
		
		try {
			String sqlstatement = "SELECT * FROM members;";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sqlstatement);
			
			while(rs.next()) {
				GYMMember gm = new GYMMember(rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
				members.add(gm);
			}
			
		}catch(Exception e) {
			System.out.println("Error while fetching the records");
		}
		
		return members;
	}

}
