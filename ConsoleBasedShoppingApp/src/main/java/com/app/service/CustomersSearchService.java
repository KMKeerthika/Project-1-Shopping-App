package com.app.service;

//import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customers;

public interface CustomersSearchService 
{
	public Customers getCustomersByCustId(int id) throws BusinessException;
	public Customers getCustomersByName(String name) throws BusinessException;
	public Customers getCustomersByMailId(String MailId) throws BusinessException;
	public Customers getCustomersByUsername(String username) throws BusinessException;
}
