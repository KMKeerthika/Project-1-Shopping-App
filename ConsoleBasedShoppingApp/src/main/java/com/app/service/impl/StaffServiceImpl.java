package com.app.service.impl;

import com.app.dao.staffDAO;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.dao.impl.StaffDAOImpl;
import com.app.exception.BusinessException;
import com.app.service.StaffService;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class StaffServiceImpl implements StaffService 
{
    Scanner scan = new Scanner(System.in);
    Logger log = Logger.getLogger(StaffServiceImpl.class);
    
    static staffDAO staff = new StaffDAOImpl();
    
    
	@Override
	public boolean addProduct() throws BusinessException 
	{
		boolean stat = false;
		
		log.info("Please Enter The Product Details To Add The Product");
		log.info("Enter Product id: ");
		String Pid = scan.next();
		log.info("Enter Product Name: ");
		String Pname = scan.next();
		log.info("Enter Product Price: ");
		double Pprice = scan.nextDouble();
			
		stat = staff.addProduct(Pid, Pname, Pprice);
		return stat;
			
	}

	@Override
	public boolean updateOrder() throws BusinessException 
	{
		char ch = 'y';
		Integer orderId;
		boolean stat;
		ArrayList<Integer> o_lst = new ArrayList<>();
		
		while((ch == 'y')||(ch == 'Y'))
		{
		    log.info("Enter order ID: ");
			orderId = scan.nextInt();	
			
			o_lst.add(orderId);
			
			log.info("Do you want to update another order? (Y/N)");
			ch = scan.next().charAt(0);	
		}
		
		for(int i : o_lst)
		{
			System.out.println(i);
		}
		
		stat = staff.updateOrder(o_lst);
		return stat;
		
	}	
}


