package com.qa.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;;

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
		String readStmt = "SELECT * FROM customers;";
		try {
			rows = stat.executeQuery(readStmt);
			while (rows.next()) {
				System.out.println("ID: " + rows.getInt("id"));
				System.out.println("First Name: " + rows.getString("first_name"));
				System.out.println("Surname: " + rows.getString("surname"));
				System.out.println("Sex: " + rows.getString("sex"));
				System.out.println("Age: " + rows.getInt("age"));
			}
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

	public void readById(int readID) {
		String selectRow = "SELECT * FROM customers WHERE id = " + readID + ";";
		try
		{
			rows = stat.executeQuery(selectRow);
			while (rows.next())
			{
				System.out.println("ID: " + rows.getInt("id"));
				System.out.println("First Name: " + rows.getString("first_name"));
				System.out.println("Surname: " + rows.getString("surname"));
				System.out.println("Sex: " + rows.getString("sex"));
				System.out.println("Age: " + rows.getInt("age"));
			}
		}
		catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

	public void readByName(String readName) {
		System.out.println(readName);
		String selectRow = "SELECT * FROM customers WHERE surname = '" + readName + "';";
		try
		{
			rows = stat.executeQuery(selectRow);
			while (rows.next())
			{
				System.out.println("ID: " + rows.getInt("id"));
				System.out.println("First Name: " + rows.getString("first_name"));
				System.out.println("Surname: " + rows.getString("surname"));
				System.out.println("Sex: " + rows.getString("sex"));
				System.out.println("Age: " + rows.getInt("age"));
			}
		}
		catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
		
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
