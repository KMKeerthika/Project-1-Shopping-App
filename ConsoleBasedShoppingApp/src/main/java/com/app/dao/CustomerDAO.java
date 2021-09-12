package com.app.dao;

import java.util.ArrayList;

import com.app.exception.BusinessException;
import com.app.model.Orders;

public interface CustomerDAO 
{
	public void addCart(int size,ArrayList<String> p_lst, ArrayList<ArrayList<String>> cart) throws BusinessException;
	public void viewOrderHistory(int custId) throws BusinessException;
	public boolean updateOrder(int custId, int orderId) throws BusinessException;
	
	public void viewProducts() throws BusinessException;
	public int getCustId(String usernmae) throws BusinessException;
}
