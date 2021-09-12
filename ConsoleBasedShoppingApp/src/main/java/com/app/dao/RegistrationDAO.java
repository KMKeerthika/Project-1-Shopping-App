package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customers;

public interface RegistrationDAO 
{
	public Customers register(String name, String mailId, String username, String password) throws BusinessException;
}
