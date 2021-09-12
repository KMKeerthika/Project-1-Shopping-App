package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.List;

import org.apache.log4j.Logger;
import com.app.dao.CustomerSearchDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customers;


public class CustomerSearchDAOImpl  implements CustomerSearchDAO
{
	private static Logger log = Logger.getLogger(CustomerSearchDAOImpl.class);
	
	//--------------------------search via custID---------------------------------------
	@Override
	public  Customers getCustomersByCustId(int custId) throws BusinessException 
	{
		Customers customer = null;
		String name = null,mailId = null,username = null,password = null;
		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			String sql="select custId,name,mailId,username,password from customers where custId=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, custId);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			if(resultSet == null)
			{
				
				throw new BusinessException("Entered customer ID doesnt exist");
			} 
			else
			{
				while(resultSet.next()) 
				{
					customer = new Customers(custId,  name, mailId, username, password);
					customer.setCustId(custId);
					customer.setName(resultSet.getString("name"));
					customer.setMailId(resultSet.getString("mailId"));
					customer.setUsername(resultSet.getString("username"));
					
				}
			}
						
		} catch (ClassNotFoundException | SQLException e) 
		{
			log.error(e);
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
			
		}
		return customer;
	}

	//--------------------------search via name---------------------------------------
	@Override
	public Customers getCustomersByName(String name) throws BusinessException 
	{
		Customers customer = null;
		int custId = 0;
		String mailId = null,username = null,password = null;
		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			System.out.println(name);
			String sql="select custId,mailId,username from customers where name=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			if(resultSet == null)
			{
				throw new BusinessException("Entered customer Name Doesnt Exist");
			} 
			else
			{
				while(resultSet.next()) 
				{
					customer = new Customers(custId, name, mailId,username,password);
					customer.setName(name);
					customer.setCustId(resultSet.getInt("custId"));
					customer.setMailId(resultSet.getString("mailId"));
					customer.setUsername(resultSet.getString("username"));
					
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) 
		{
			log.error(e);
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return customer;
	}

	//--------------------------search via mailId---------------------------------------
	@Override
	public Customers getCustomersByMailId(String mailId) throws BusinessException 
	{
		Customers customer = null;
		int custId = 0;
		String username = null,password = null,name = null;
		
		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			String sql="select custId,name,mailId,username,password from customers where mailId=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, mailId);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			if(resultSet == null)
			{
				throw new BusinessException("Entered customer Name Doesnt Exist");
			} 
			else 
			{
				while(resultSet.next()) 
				{
					customer = new Customers(custId, name, mailId, username,password);
					customer.setMailId(mailId);
					customer.setCustId(resultSet.getInt("custId"));
					customer.setName(resultSet.getString("name"));
					customer.setUsername(resultSet.getString("username"));
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) 
		{
			log.error(e);
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
			
		}
		return customer;
	}

	//--------------------------search via username---------------------------------------
	@Override
	public Customers getCustomersByUsername(String username) throws BusinessException 
	{
		Customers customer = null;
		int custId = 0;
		String mailId = null,password = null,name = null;
		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			String sql="select custId,name,mailId,username,password from customers where username=?";
			
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			if(resultSet == null)
			{
				throw new BusinessException("Entered customer username doesnt exist");
			} 
			
			else 
			{
				while(resultSet.next()) 
				{
					customer = new Customers(custId, name, mailId, username, password);
					customer.setUsername(username);
					customer.setCustId(resultSet.getInt("custId"));
					customer.setName(resultSet.getString("name"));
					customer.setMailId(resultSet.getString("mailId"));
					
				}
			}
			
			
		} catch (ClassNotFoundException | SQLException e) 
		{
			log.error(e);
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
			
		}
		return customer;
	}

	
}