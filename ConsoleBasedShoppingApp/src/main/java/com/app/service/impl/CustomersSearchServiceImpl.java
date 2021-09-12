package com.app.service.impl;

//import java.util.List;

import com.app.dao.CustomerSearchDAO;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customers;
import com.app.service.CustomersSearchService;

public class CustomersSearchServiceImpl implements CustomersSearchService 
{

	private CustomerSearchDAO customerSearchDAO= new CustomerSearchDAOImpl();
	
	@Override
	public Customers getCustomersByCustId(int custId) throws BusinessException 
	{
		Customers customer = null;
		if(custId > 100) 
		{
			throw new BusinessException("Invalid Player Id ");
		}
		else 
		{
			//code here to DAO
			customer = customerSearchDAO.getCustomersByCustId(custId);
			
		}
		return customer;
	}

	@Override
	public Customers getCustomersByName(String name) throws BusinessException 
	{
		Customers customer = null;
		
		if(name==null) 
		{
			throw new BusinessException("Invalid customer name ");
		}
		else 
		{
			//code here to DAO
			customer = customerSearchDAO.getCustomersByName(name);
			
		}
		return customer;
	}

	@Override
	public Customers getCustomersByMailId(String mailId) throws BusinessException 
	{
		Customers customer = null;
		
		if(mailId==null) 
		{
			throw new BusinessException("Invalid  mail ID");
		}
		else 
		{
			//code here to DAO
			customer = customerSearchDAO.getCustomersByMailId(mailId);
			
		}
		return customer;
	}

	@Override
	public Customers getCustomersByUsername(String username) throws BusinessException 
	{
        Customers customer = null;
		
		if(username == null) 
		{
			throw new BusinessException("Invalid Username");
		}
		else 
		{
			//code here to DAO
			customer = customerSearchDAO.getCustomersByUsername(username);
			
		}
		return customer;
		
	}

	

}
