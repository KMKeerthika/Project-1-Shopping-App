package com.app.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Orders;

class CustomerOpTest 
{
	CustomerDAO customerDAO = new CustomerDAOImpl();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	final void testUpdateOrder() 
	{
		boolean exp_order = false;
		
		try 
		{
			exp_order = customerDAO.updateOrder(1,100);
		} 
		catch (BusinessException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals(exp_order, true);
		
	}
	
	@Test
	final void testViewOrderHistory()
	{
		try 
		{
			customerDAO.viewOrderHistory(1);
		} 
		catch (BusinessException e) 
		{
			e.printStackTrace();
		}
	}
}
