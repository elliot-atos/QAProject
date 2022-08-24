package com.qa.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SQLqueriesTEST {
	
	Customers c = new Customers("F", "S", 1, 'M');
	Customers c2 = new Customers();
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	
	@Before
	public void setUp()
	{
		System.setOut(new PrintStream(outputStream));
	}
	
	@Test
	public void constructorTEST()
	{
		SQLqueries sql = new SQLqueries();
		assertEquals("Connection Successful!", outputStream.toString().trim());
	}
	
	@Test
	public void insertTEST()
	{
		SQLqueries sql = new SQLqueries();
		sql.insert(c);
		assertTrue(outputStream.toString().trim().endsWith("Create statement executed"));
	}
	
	@Test
	public void readTEST()
	{
		SQLqueries sql = new SQLqueries();
		sql.read();
		assertTrue(outputStream.toString().trim().contains("ID: "));
		assertTrue(outputStream.toString().trim().contains("First Name: "));
		assertTrue(outputStream.toString().trim().contains("Surname: "));
		assertTrue(outputStream.toString().trim().contains("Sex: "));
		assertTrue(outputStream.toString().trim().contains("Age: "));
	}
	
	@Test
	public void readGoodIDTEST()
	{
		SQLqueries sql = new SQLqueries();
		sql.readById(1);
		assertTrue(outputStream.toString().trim().contains("ID: "));
		assertTrue(outputStream.toString().trim().contains("First Name: "));
		assertTrue(outputStream.toString().trim().contains("Surname: "));
		assertTrue(outputStream.toString().trim().contains("Sex: "));
		assertTrue(outputStream.toString().trim().contains("Age: "));
	}
	
	@Test
	public void readGoodNameTEST()
	{
		SQLqueries sql = new SQLqueries();
		sql.readByName("S");
		assertTrue(outputStream.toString().trim().contains("ID: "));
		assertTrue(outputStream.toString().trim().contains("First Name: "));
		assertTrue(outputStream.toString().trim().contains("Surname: "));
		assertTrue(outputStream.toString().trim().contains("Sex: "));
		assertTrue(outputStream.toString().trim().contains("Age: "));
	}
	
	@Test
	public void updatefnameTEST()
	{
		SQLqueries sql = new SQLqueries();
		sql.updatefname("old", "new");
		assertTrue(outputStream.toString().trim().endsWith("Update statement executed"));
	}
	
	@Test
	public void deleteTEST()
	{
		SQLqueries sql = new SQLqueries();
		sql.delete("old", "new");
		assertTrue(outputStream.toString().trim().endsWith("Delete statement executed"));
	}
	
	@Test
	public void closeTEST()
	{
		SQLqueries sql = new SQLqueries();
		//System.out.print("\033[H\033[2J");
        //System.out.flush();
		sql.close();
		assertTrue(outputStream.toString().trim().endsWith("Closed!"));
	}
	
	
	
	@After
	public void tearDown() {
	    System.setOut(standardOut);
	}

}
