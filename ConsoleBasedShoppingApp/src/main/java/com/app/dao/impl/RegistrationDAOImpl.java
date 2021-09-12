package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.RegistrationDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customers;

public class RegistrationDAOImpl implements RegistrationDAO
{
	private static Logger log = Logger.getLogger(RegistrationDAOImpl.class);
	
	@Override
	public Customers register(String name, String mailId, String username, String password) throws BusinessException 
	{
		Customers customer = null;
		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			customer = new Customers(name, mailId, username, password);
			customer.setName(name);
			customer.setMailId(mailId);
			customer.setUsername(username);
			
			String sql = "select custId,name, mailId, username, password from customers where mailId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, mailId);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			
				if(resultSet.next()) 
				{	
					
					System.out.print("User Exists!");
				}	
				else
				{
					sql = "INSERT INTO customers (name, mailId, username, password) VALUES (?,?,?,?)";
					
					preparedStatement=connection.prepareStatement(sql);
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, mailId);
					preparedStatement.setString(3, username);
					preparedStatement.setString(4, password);
						
						
					int result = preparedStatement.executeUpdate();
						
					if(result == 1) 
					{
						log.info("SuccessFully Registered!");
					}
				}
							
				return customer;
	 	
			}
		   catch (ClassNotFoundException | SQLException e) 
		   {
			  log.error(e);
			  System.out.println(e);
			  throw new BusinessException("Internal error occured contact sysadmin");
			
		   }
		

	}

}
