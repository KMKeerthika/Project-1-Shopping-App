package com.app.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.dao.RegistrationDAO;
import com.app.dao.impl.RegistrationDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customers;

class RegisterTest 
{
	static Customers cust = new Customers();
	static Customers customer = new Customers();
	static RegistrationDAO registration = new RegistrationDAOImpl();

	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
	}

	@Test
	final void testNONRegisterUser() 
	{	
		try 
	      {
			customer.setName("kmk");
			customer.setMailId("kmk@gmail.com");
			customer.setUsername("KMK");
			
			cust = registration.register("kmk","kmk@gmail.com","KMK","kmk123");
			
			assertEquals(cust.getName() , customer.getName());
			assertEquals(cust.getMailId() , customer.getMailId());
			assertEquals(cust.getUsername() , customer.getUsername());
			assertEquals(cust.getPassword() , customer.getPassword());
		     
	      } 
	      catch (BusinessException e1) 
	      {
		     e1.printStackTrace();
	      }
		
	}
	
	

}
