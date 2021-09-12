package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.LoginDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;

public class LoginDAOImpl implements LoginDAO
{
	private static Logger log = Logger.getLogger(LoginDAOImpl.class);
	
	@Override
	public boolean checkForUser(String username, String password) throws BusinessException 
	{
	    boolean isThere = false;
	    String uname;
	    
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			String sql="select mailId,username,password from customers where username=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				uname = resultSet.getString("username");
				
				if(username.equals(uname))
				{	
					isThere = true;
				}	
					   
			}
			else
			{
				log.info("Please Register Before Logging In ");
			}
			
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			log.error(e);
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
			
		}
		return isThere;
	}

}
