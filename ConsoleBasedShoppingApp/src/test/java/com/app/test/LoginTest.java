package com.app.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.dao.LoginDAO;
import com.app.dao.impl.LoginDAOImpl;


class LoginTest 
{
	LoginDAO login = new LoginDAOImpl();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	final void testCheckForRegisteredUser() 
	{
		try {
            boolean result = login.checkForUser("SITA", "efg123");
 
            assertEquals(true, result);
        } 
		catch (Exception e) 
		{
            e.printStackTrace(System.err);
        }
	}
	
	final void testCheckForNONRegisteredUser() 
	{
		try {
            boolean result = login.checkForUser("SIA", "efg123");
 
            assertEquals(false, result);
        } 
		catch (Exception e) 
		{
            e.printStackTrace(System.err);
        }
	}

}
