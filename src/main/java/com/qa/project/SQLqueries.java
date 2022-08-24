package com.qa.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLqueries {

	private Connection conn;
	private Statement stat;
	private ResultSet rows;
	
	public SQLqueries() {
		try {
			conn = DriverManager.getConnection(SQLconfig.URL, SQLconfig.USER, SQLconfig.PASS);
			this.stat = conn.createStatement();// create a statement object to execute sql queries
			System.out.println("Connection Successful!");
		} catch (SQLException e) {
			System.out.println("Incorrect credentials");
			e.printStackTrace();
		}
	}
	
	public void insert(Customers c) {
		String createStmt = "INSERT INTO customers(first_name, surname, sex, age) VALUES('" + c.getFirstName() + "','" + c.getSurName()
		+ "','" + c.getSex() + "'," + c.getAge() + ");";
		
		//"INSERT INTO vehicle(model, mileage, vehicle_type, doors) VALUES('" + v.getModel() + "'," + v.getMileage()
		//+ ",'" + v.getVehicleType() + "'," + v.getDoors() + ");";
		
		try 
		{
			stat.executeUpdate(createStmt);
			System.out.println("Create statement executed");
		}
		catch (SQLException e) 
		{
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	

	public void read() {
		// TODO Auto-generated method stub
		
	}

	public void readById(int readID) {
		// TODO Auto-generated method stub
		
	}

	public void readByName(String readName) {
		// TODO Auto-generated method stub
		
	}

	public void update(int uid, String ufname) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		try {
			conn.close();
			System.out.println("Closed!");
		} catch (SQLException e) {
			System.out.println("Closing connection...");
			e.printStackTrace();
		}
	}

}
