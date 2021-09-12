package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Orders;

public class CustomerDAOImpl implements CustomerDAO
{
	private static Logger log = Logger.getLogger(CustomerSearchDAOImpl.class);
	
	Scanner scan = new Scanner(System.in);
	ArrayList<ArrayList<String>> cart = new ArrayList<>();		
	ArrayList<String> p_lst = new ArrayList<>();

	@Override
	public void viewProducts() throws BusinessException 
	{
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			String sql="select Pid, Pname, Pprice from products";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			//preparedStatement.setString();
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			if (resultSet == null)
			{
				throw new BusinessException("RS null");	
			}
			
			System.out.println("\nPid\tPname\tPprice");
			System.out.println("");
			
			while(resultSet.next())
			{
				System.out.print(resultSet.getString("Pid")+"\t");
				System.out.print(resultSet.getString("Pname")+"\t");
				System.out.print(resultSet.getDouble("Pprice")+"");
				System.out.println("");
				
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
	public void addCart(int custId, ArrayList<String> p_lst, ArrayList<ArrayList<String>> cart) throws BusinessException 
	{	
		String Pid = null, Pname = null, s_Pprice = null, status = "order placed";
		double d_Pprice;
		int temp = 0,j,k;
		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			
			for(int i = 0; i < p_lst.size(); i++)
			{   
												
				String sql="select Pid, Pname, Pprice from products where Pid = ?";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1, p_lst.get(i));
					
				ResultSet resultSet= preparedStatement.executeQuery();
					
				while(resultSet.next())
				{
					Pid = resultSet.getString("Pid");
					Pname = resultSet.getString("Pname");
					d_Pprice = resultSet.getDouble("Pprice");
					s_Pprice = Double.toString(d_Pprice);
						
				}
				cart.add(new ArrayList<String>());
				cart.get(i).add(Pid);
				cart.get(i).add(Pname);
				cart.get(i).add(s_Pprice);
			}
				
			//---------------view cart--------------------------------------
			System.out.println("-------------view cart----------------");
			System.out.println("Pid\tPname\tPprice");
			//System.out.println(p_lst.size());
			for ( j = 0; j < p_lst.size(); j++) 
			{	
				System.out.println("");
			    for ( k = 0; k < 3; k++) 
			    {
			    	System.out.print(cart.get(j).get(k)+"\t") ;	
			    }
			}
			
			
				
			//-----------update order table--------------------------------
				
			for (j = 0; j < p_lst.size(); j++) 
			{
			   
			    	String sql="INSERT INTO orders (custId, Pid, totalPrice, status) VALUES (?,?,?,?)";
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					
					Pid = cart.get(j).get(0);
					Pname = cart.get(j).get(1);
					s_Pprice = cart.get(j).get(2);
					d_Pprice = Double.parseDouble(s_Pprice);
					
				//	System.out.println(Pid+" "+Pname+"  "+s_Pprice+"  "+status);
					
					preparedStatement.setInt(1, custId);
					preparedStatement.setString(2, Pid);
					preparedStatement.setDouble(3, d_Pprice);
					preparedStatement.setString(4, status);
					
					int resultSet= preparedStatement.executeUpdate();
					
					if(resultSet == 1)
					{
						temp += 1;
					}
					else
					{
						temp -= 1;
					}
			    
			}
			
			if(temp == p_lst.size())
			{
				log.info("order table updated");
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
	public  void viewOrderHistory(int custId) throws BusinessException 
	{		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			String sql="select orderId, Pid, totalPrice, status from orders where custId = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, custId);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt("orderId")+"\t");
				System.out.print(resultSet.getString("Pid")+"\t");
				System.out.print(resultSet.getString("status")+"\t");
				System.out.print(resultSet.getDouble("totalPrice"));
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
	public int getCustId(String username) throws BusinessException 
	{
		int temp = 0;
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			String sql="select custId from customers where username = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, username);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				temp = resultSet.getInt("custId");
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			log.error(e);
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
			
		}
		return temp;
		
	}

	@Override
	public boolean updateOrder(int custId, int orderId) throws BusinessException 
	{		
		boolean stat = false;
		
		try(Connection connection = MySqlDbConnection.getConnection())
		{
			String sql="UPDATE orders SET status = 'received' WHERE orderId = ? AND custId = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, orderId);
			preparedStatement.setInt(2, custId);
			
			int resultSet = preparedStatement.executeUpdate();
			
			if(resultSet == 1)
			{ 
				stat = true;
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

