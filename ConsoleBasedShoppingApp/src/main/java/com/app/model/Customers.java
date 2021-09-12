package com.app.model;

public class Customers 
{
	private int custId;
	private String name; 
	private String mailId; 
	private String username; 
	private String password;
	
	public int getCustId() 
	{
		return custId;
	}
	
	public void setCustId(int custId) 
	{
		this.custId = custId;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getMailId() 
	{
		return mailId;
	}
	
	public void setMailId(String mailId)
	{
		this.mailId = mailId;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	@Override
	public String toString() 
	{
		return "Customers [custId=" + custId + ", name=" + name + ", mailId=" + mailId + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	public Customers(int custId, String name, String mailId, String username, String password) 
	{
		super();
		this.custId = custId;
		this.name = name;
		this.mailId = mailId;
		this.username = username;
		this.password = password;
	}

	public Customers(String name, String mailId, String username, String password) 
	{
		super();
		this.name = name;
		this.mailId = mailId;
		this.username = username;
		this.password = password;
	}

	public Customers() {
		// TODO Auto-generated constructor stub
	}
	
	
}
	
	

