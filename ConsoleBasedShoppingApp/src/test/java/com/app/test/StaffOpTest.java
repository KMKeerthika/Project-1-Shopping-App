package com.app.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.service.StaffService;
import com.app.service.impl.StaffServiceImpl;

class StaffOpTest 
{
	static CustomerDAO customerDAO = new CustomerDAOImpl();
	static StaffService staffService = new StaffServiceImpl();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	final void testAddProduct() 
	{
        boolean status = false;
		
		try 
		{
			status = staffService.addProduct();
		} 
		catch (BusinessException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals(status, true);
	}

	@Test
	final void testUpdateOrder() 
	{
       boolean status = false;
		
		try 
		{
			status = staffService.updateOrder();
		} 
		catch (BusinessException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals(status, true);
	}

}
