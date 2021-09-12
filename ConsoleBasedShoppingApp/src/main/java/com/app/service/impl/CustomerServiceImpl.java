package com.app.service.impl;

import java.util.Scanner;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.service.CustomerService;
import org.apache.log4j.Logger;


public class CustomerServiceImpl implements CustomerService 
{
	static CustomerDAO customerDAO = new CustomerDAOImpl();
	
	private static Logger log = Logger.getLogger(CustomerServiceImpl.class);
	Scanner scan = new Scanner(System.in);

	@Override
	public boolean orderUpdate(int custId) throws BusinessException 
	{
		boolean stat;
		int orderId;
		
		log.info("Enter Order ID to update");
		orderId = scan.nextInt();
		
		stat = customerDAO.updateOrder(custId, orderId);
		
		return stat;

	}

}
