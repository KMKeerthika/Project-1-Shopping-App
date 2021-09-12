package com.app.service.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.service.Cart;


public class CartImpl implements Cart
{
	Scanner scan = new Scanner(System.in); 
	static CustomerDAO customer = new CustomerDAOImpl();
	
	ArrayList<ArrayList<String>> cart = new ArrayList<>();		
	ArrayList<String> p_lst = new ArrayList<>();
	
	

	
	@Override
	public void addCart(int custId) throws BusinessException 
	{
		char endCart = 0;
		String temp;
		char placeOrder = 0;
		
		//---------------get pid from user------------------------------
		System.out.println(endCart);
		
		do
		{
			System.out.println("Please enter the Pid you want to add in cart");
			temp = scan.next();
			p_lst.add(temp);
			System.out.println("Do you Want To Add Another Product To Cart? (Y/N)");
			endCart = scan.next().charAt(0);
		}
		while((endCart == 'Y')||(endCart == 'y'));
		
		//----------------adding in cart---------------------------------------------
		System.out.println("Do you want to place your order? (Y/N)");
		placeOrder = scan.next().charAt(0);
		
		System.out.println(p_lst.size());
				
		if((placeOrder== 'Y')||(placeOrder == 'y'))
		{			
			customer.addCart(custId,p_lst,cart);
		}
		else
		{
			System.out.println("Cart Empty!");
		}
		
	}

}
