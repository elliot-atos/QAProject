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
			this.stat = conn.createStatement();
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

	public void updatefname(String oldFName, String newFName) {
		String updateStmt = "UPDATE customers SET first_name = '" + newFName + "' WHERE first_name = '" + oldFName + "';";
		try {
			stat.executeUpdate(updateStmt);
			System.out.println("Update statement executed");
			
		}catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
		
	}

	public void delete(String fname, String surname) {
		String delStmt = "DELETE FROM customers WHERE first_name = '" + fname + "' AND surname = '" + surname +"';";
		try {
			stat.executeUpdate(delStmt);
			System.out.println("Delete statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
		
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
