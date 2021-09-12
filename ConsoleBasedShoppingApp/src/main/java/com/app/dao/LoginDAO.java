package com.app.dao;

import com.app.exception.BusinessException;

public interface LoginDAO 
{
	public boolean checkForUser(String username, String password) throws BusinessException;
	
    
	
}
