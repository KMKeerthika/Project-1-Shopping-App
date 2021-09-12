package com.app.model;

public class Products 
{
	private String Pid, Pname;
	private double Pprice;
	
	public String getPid() 
	{
		return Pid;
	}
	
	public void setPid(String pid) 
	{
		Pid = pid;
	}
	
	public String getPname() 
	{
		return Pname;
	}
	
	public void setPname(String pname) 
	{
		Pname = pname;
	}
	
	public double getPprice() 
	{
		return Pprice;
	}
	
	public void setPprice(double pprice) 
	{
		Pprice = pprice;
	}

	@Override
	public String toString() 
	{
		return "Products [Pid=" + Pid + ", Pname=" + Pname + ", Pprice=" + Pprice + "]";
	}

	public Products(String pid, String pname, double pprice) 
	{
		super();
		Pid = pid;
		Pname = pname;
		Pprice = pprice;
	}

	public Products() 
	{
		// TODO Auto-generated constructor stub
	}
	
	

}
