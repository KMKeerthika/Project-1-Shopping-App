package com.app.service;

import com.app.exception.BusinessException;

public interface StaffService 
{
	public boolean addProduct() throws BusinessException;
	public boolean  updateOrder() throws BusinessException;
}
