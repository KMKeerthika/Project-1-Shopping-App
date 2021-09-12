package com.app.dao;

//import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customers;

public interface CustomerSearchDAO {
	public  Customers getCustomersByCustId(int custId) throws BusinessException;
	public  Customers getCustomersByName(String name) throws BusinessException;
	public  Customers getCustomersByMailId(String mailId) throws BusinessException;
	public  Customers getCustomersByUsername(String username) throws BusinessException;
	
	

/*	
	
	public List<Customers> getCustomersByCustId(int custId) throws BusinessException;
	public  List<Customers> getCustomersByName(String name) throws BusinessException;
	public  List<Customers> getCustomersByMailId(String mailId) throws BusinessException;
	
*/
}
