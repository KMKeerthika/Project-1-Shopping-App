package com.app.model;

public class Orders 
{
	private int orderId, custId;
	private String Pid, status;
	private double totalPrice;
	
	public int getOrderId() 
	{
		return orderId;
	}
	
	public void setOrderId(int orderId) 
	{
		this.orderId = orderId;
	}
	
	public int getCustId() 
	{
		return custId;
	}
	
	public void setCustId(int custId) 
	{
		this.custId = custId;
	}
	
	public String getPid() 
	{
		return Pid;
	}
	
	public void setPid(String pid) 
	{
		Pid = pid;
	}
	
	public String getStatus() 
	{
		return status;
	}
	
	public void setStatus(String status) 
	{
		status = status;
	}
	
	public double getTotalPrice() 
	{
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) 
	{
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() 
	{
		return "Orders [orderId=" + orderId + ", custId=" + custId + ", Pid=" + Pid + ", Status=" + status
				+ ", totalPrice=" + totalPrice + "]";
	}

	public Orders(int orderId, int custId, String pid, String Status, double totalPrice) 
	{
		super();
		this.orderId = orderId;
		this.custId = custId;
		Pid = pid;
		status = Status;
		this.totalPrice = totalPrice;
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	

}
