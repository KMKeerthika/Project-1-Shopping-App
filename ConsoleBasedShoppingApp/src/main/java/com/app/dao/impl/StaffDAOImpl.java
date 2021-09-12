package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.staffDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;

public class StaffDAOImpl implements staffDAO
{
	private static Logger log = Logger.getLogger(CustomerSearchDAOImpl.class);
	
    Scanner scan = new Scanner(System.in);
	
	@Override
	public boolean addProduct(String Pid, String Pname, Double Pprice) throws BusinessException 
	{
		boolean stat = false;
		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
		    String sql="INSERT INTO products (Pid, Pname, Pprice) VALUES (?,?,?)";
			
		    PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
		    preparedStatement.setString(1, Pid);
		    preparedStatement.setString(2, Pname);
		   	preparedStatement.setDouble(3, Pprice);
			
		    int resultSet= preparedStatement.executeUpdate();
			
		    if(resultSet == 1)
		    {
		    	stat = true;
		    	//log.info("Product Added Successfully!");
		    }
			    
            viewProducts();
			
		} 
		
		catch (ClassNotFoundException | SQLException e) 
		{
			log.error(e);
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return stat;			
	
	 }

	@Override
	public void viewProducts() throws BusinessException 
	{
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			String sql="select Pid, Pname, Pprice from products";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			//preparedStatement.setString();
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getString("Pid")+"\t");
				System.out.print(resultSet.getString("Pname")+"\t");
				System.out.print(resultSet.getDouble("Pprice"));
		    }
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			log.error(e);
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
			
		}
	}

	@Override
	public boolean updateOrder(ArrayList<Integer> o_lst) throws BusinessException 
	{
		boolean stat = false;
		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			for(int i : o_lst)
			{
				String sql="UPDATE orders SET status = 'onMove' WHERE orderId = ?";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				
				preparedStatement.setInt(1, i);
				
				int resultSet = preparedStatement.executeUpdate();
				
				if(resultSet == 1)
				{ 
					stat = true;
				}
				else
				{
					log.warn("Internal System Error");
					throw new BusinessException("Internal System Error");
				}
				
			}
			
			
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			log.error(e);
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
			
		}
		return stat;
	}

}
