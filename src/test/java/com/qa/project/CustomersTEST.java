package com.qa.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class CustomersTEST {
	
	Customers c = new Customers("F", "S", 1, 'M');
	
	@Test
    public void constructorTEST()
    {
    	assertEquals("F", c.getFirstName());
    	assertEquals("S", c.getSurName());
    	assertEquals(1, c.getAge());
    	assertEquals('M', c.getSex());
    }
	
	@Test
	public void emptyConstructorTEST()
	{
		Customers cust = new Customers();
		assertNotEquals(null, cust);
	}
	
	@Test
	public void toStringTEST()
	{
		assertEquals("Customer [Name=F, Surname=S, Age=1, Sex=M]", c.toString());
	}
    
    @Test
    public void settersTest()
    {
    	c.setFirstName("First");
    	c.setSurName("Second");
    	c.setAge(100);
    	c.setSex('F');
    	assertEquals("First", c.getFirstName());
    	assertEquals("Second", c.getSurName());
    	assertEquals(100, c.getAge());
    	assertEquals('F', c.getSex());
    }
}
