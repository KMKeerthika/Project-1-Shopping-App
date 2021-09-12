package com.app.service;

import com.app.exception.BusinessException;

public interface Cart 
{
	public void addCart(int custId) throws BusinessException;
}
