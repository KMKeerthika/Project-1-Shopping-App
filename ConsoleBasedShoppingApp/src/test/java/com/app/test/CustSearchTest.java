package com.app.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.model.Customers;
import com.app.service.CustomersSearchService;
import com.app.service.impl.CustomersSearchServiceImpl;

class CustSearchTest 
{
	static Customers cust = new Customers();
	static Customers customer = new Customers();
	static CustomersSearchService customersSearchService = new CustomersSearchServiceImpl();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	final void testGetCustomersByCustId() 
	{
		customer.setCustId(2);
		customer.setName("Sita");
		customer.setMailId("sita@gmail.com");
		customer.setUsername("SITA");
		
		try 
		{
			cust = customersSearchService.getCustomersByCustId(2);
		} 
		catch (BusinessException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals(cust.getCustId() , customer.getCustId());
		assertEquals(cust.getName() , customer.getName());
		assertEquals(cust.getMailId() , customer.getMailId());
		assertEquals(cust.getUsername() , customer.getUsername());
		
	}

	@Test
	final void testGetCustomersByName() 
	{
		customer.setCustId(2);
		customer.setName("Sita");
		customer.setMailId("sita@gmail.com");
		customer.setUsername("SITA");
		
		try 
		{
			cust = customersSearchService.getCustomersByName("Sita");
		} 
		catch (BusinessException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals(cust.getCustId() , customer.getCustId());
		assertEquals(cust.getName() , customer.getName());
		assertEquals(cust.getMailId() , customer.getMailId());
		assertEquals(cust.getUsername() , customer.getUsername());
	}

	@Test
	final void testGetCustomersByMailId() 
	{
		customer.setCustId(2);
		customer.setName("Sita");
		customer.setMailId("sita@gmail.com");
		customer.setUsername("SITA");
		
		try 
		{
			cust = customersSearchService.getCustomersByMailId("sita@gmail.com");
		} 
		catch (BusinessException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals(cust.getCustId() , customer.getCustId());
		assertEquals(cust.getName() , customer.getName());
		assertEquals(cust.getMailId() , customer.getMailId());
		assertEquals(cust.getUsername() , customer.getUsername());
	}

	@Test
	final void testGetCustomersByUsername() 
	{
		customer.setCustId(2);
		customer.setName("Sita");
		customer.setMailId("sita@gmail.com");
		customer.setUsername("SITA");
		
		try 
		{
			cust = customersSearchService.getCustomersByUsername("SITA");
		} 
		catch (BusinessException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals(cust.getCustId() , customer.getCustId());
		assertEquals(cust.getName() , customer.getName());
		assertEquals(cust.getMailId() , customer.getMailId());
		assertEquals(cust.getUsername() , customer.getUsername());
	}

}
