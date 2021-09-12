package com.app.dao;

import java.util.ArrayList;

import com.app.exception.BusinessException;

public interface staffDAO
{
	public boolean addProduct(String Pid, String Pname, Double Pprice) throws BusinessException;
	public boolean  updateOrder(ArrayList<Integer> o_lst) throws BusinessException;
	
	public void viewProducts() throws BusinessException;
}
