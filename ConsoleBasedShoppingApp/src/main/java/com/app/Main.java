package com.app;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.app.dao.CustomerDAO;
import com.app.dao.LoginDAO;
import com.app.dao.RegistrationDAO;
import com.app.dao.staffDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.dao.impl.LoginDAOImpl;
import com.app.dao.impl.RegistrationDAOImpl;
import com.app.dao.impl.StaffDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customers;
import com.app.model.Orders;
import com.app.service.Cart;
import com.app.service.CustomerService;
import com.app.service.CustomersSearchService;
import com.app.service.StaffService;
import com.app.service.impl.CartImpl;
import com.app.service.impl.CustomerServiceImpl;
import com.app.service.impl.CustomersSearchServiceImpl;
import com.app.service.impl.StaffServiceImpl;


public class Main 
{
	
	private static Logger log = Logger.getLogger(Main.class);
	
	
	static RegistrationDAO registration = new RegistrationDAOImpl();
	static LoginDAO login = new LoginDAOImpl();
	static Cart cart = new CartImpl();
	static CustomerDAO customerDAO = new CustomerDAOImpl();
	static CustomerService customer = new CustomerServiceImpl();
	static Customers cust = new Customers();
	static Orders order = new Orders();
	static staffDAO staffDAO = new StaffDAOImpl();
	static StaffService staffService = new StaffServiceImpl();
	static CustomersSearchService customersSearchService = new CustomersSearchServiceImpl();
	

	public static void main(String[] args) 
	{
		int ch1 = 1, ch2 = 1, ch3 = 1;
		int custId = 0;
		String name, mailId = null, username = null, password = null;
		boolean stat;
		
		Scanner scan = new Scanner(System.in);
	
		
		log.info("-----------------Welcome To Shopping App------------------");
		
		while(ch1 != 3)
		{
			log.info("1 --> Register\t2 --> Login\t3 --> Exit");
			ch1 = scan.nextInt();
			
			switch(ch1)
			{
			   case 1: log.info("--------Registeration--------");
			           log.info("Please Enter Your Details To Register YourSelf");
             		   
			           log.info("Name :");
             		   name = scan.next();  
              		   
             		   log.info("Mail Id :");
            		   mailId = scan.next();
            		   
            		   log.info("UserName :");
             		   username = scan.next();
             		   
             		   log.info("Password :");
            		   password = scan.next();
            		   
				      try 
				      {
					     cust =  registration.register(name, mailId, username, password);
				      } 
				      catch (BusinessException e1) 
				      {
					     e1.printStackTrace();
				      }
	                      
	                  if(cust!=null) 
	                  {
	                	 log.info("Customer details: ");
		                 log.info(cust);
	                  }
			   break;
			   
			   case 2: log.info("--------Login--------");
			           log.info("Please Enter Your Details To Login");
			           
			           log.info("UserName :");
             		   username = scan.next();
             		   
             		   log.info("Password :");
            		   password = scan.next();
            		   
            		   //-------------------staff---------------------------------------------------------------
            		   
            		   if((username.equals("root"))&&(password.equals("root")))
            		   {
            			   while(ch2 != 4)
				    	   {
            				   log.info("1 --> Add Products 2 --> Update Order 3 --> Search Customer 4 --> Log Out ");
    				    	   ch2 = scan.nextInt();
    				    	   
    				           switch(ch2)
    				           {
    				        	   
    				        	   case 1: // add new product
								           try { staffService.addProduct(); } 
								           catch (BusinessException e) {e.printStackTrace();}
        				           break;
        				               				        	   
    				        	   case 2: // update order status
								           try 
								           { 
								        	   stat = staffService.updateOrder();
								        	   if(stat == true)
												{ 
								        		   log.info("Order Updated");
												}
								           
								           } 
								           catch (BusinessException e) {e.printStackTrace(); }
    				        	   break;
    				        	   
    				        	   case 3: //search customer
    				        		        log.info("------------------Customer Search Menu-----------------");
    				        		        while(ch3 != 5)
    						    	        {
    				        		           log.info("1 --> Search By ID 2 --> Search By Name 3 --> Search By MailID 4 --> Search By Username 5 --> Go Back ");
    		    				    	       ch3 = scan.nextInt();
    		    				    	      
    		    				    	       
											switch(ch3)
    		       				            {
    		       				        	   
    		       				        	   case 1: // Search By ID
    		       				        		       log.info("Enter Customer ID");
    		       							           try 
    		       							           {
    		       							        	   custId = scan.nextInt();
    		       							               Customers customer = customersSearchService.getCustomersByCustId(custId);
    		       							               
    		       							               if(customer!=null) 
    		       							               {
    		       								             log.info("Customer Details: ");
    		       								             log.info(customer);
    		       							               }
    		       							           }
    		       							           catch (NumberFormatException e) 
    		       							           {
    		       							    	     log.warn("Customer Id should be digit only... Try Again");
    		       							           } 
    		       							           catch (BusinessException e) 
    		       							           {
    		       							    	     log.warn(e.getMessage());
    		       							           }
    		           				           break;
    		           				               				        	   
    		       				        	   case 2: // Search By Name
    		       				        		       log.info("Enter Customers name to get details");
    		       					                   try 
    		       					                   {
    		       					            	      name = scan.next();
    		       					            	     
    		       					                      Customers customer = customersSearchService.getCustomersByName(name);
    		       					                      
    		       					                      if(customer!=null) 
    		       					                      {
    		       					                	    log.info("Customer details: ");
    		       						                    log.info(customer);
    		       					                      }
    		       					                     }
    		       					              
    		       					                     catch (BusinessException e)    { log.warn(e.getMessage()); }
    		       				        	   break;
    		       				        	   
    		       				        	   case 3: // Search By MailID
    		       				        		       log.info("Enter Customers mailId to get details");
    		       			                           try 
    		       			                           {
    		       			                    	      mailId = scan.next();
    		       			                    	      
    		       			                              Customers customer = customersSearchService.getCustomersByMailId(mailId);
    		       			                              
    		       			                              if(customer!=null) 
    		       			                              {
    		       			                        	    log.info("Player with mailId "+mailId+" found successfully... Below is the details");
    		       				                            log.info(customer);
    		       			                              }
    		       			                            }
    		       			                    
    		       			                            catch (BusinessException e)     { log.warn(e.getMessage()); }
     		       				        	   break;
     		       				        	   
    		       				        	   case 4: // Search By username
    		       				        		       log.info("Enter Customers username to get details");
		       			                               try 
		       			                               {
		       			                    	         username = (scan.nextLine());
		       			                                 Customers customer = customersSearchService.getCustomersByUsername(mailId);
		       			                                 if(customer!=null) 
		       			                                 {
		       			                        	        log.info("Customer details");
		       				                                log.info(customer);
		       			                                 }
		       			                               }
		       			                    
		       			                               catch (BusinessException e)   { log.warn(e.getMessage()); }
      		       				        	   break;
      		       				        	   
    		       				        	   case 5: // Back
    		       				        		       log.info("Exiting Customer Search Menu");
      		       				        	   break;
    		       				            }
    						    	      }	

    				        	   break;  
    				        	   
    				        	   case 4: // log out
    				        		       log.info("\nLogging Out");
    				        	   break;
    				              
				    	        }
            		        }
            		    }	   
            		   
            		   // ----------------customer--------------------------------------------------------------
            		   else 
            		   {
            			   try 
    				       { 
    				    	   stat = login.checkForUser(username, password);
    				           
    				           
    				    	   if(stat == true)
    				    	   {
    				    		   custId = customerDAO.getCustId(username);
    				    		   log.info("Login Successful!");
    				    	   
    				           
    				    	      System.out.println("----------Welcome To Home Page-------------");
    				    	      while(ch2 != 4)
    				    	      {
    				    	    	  System.out.println("");
    				    	    	  log.info("-------------Products List--------------");
    				    		      customerDAO.viewProducts();
    				    		      
    				    		      log.info("\n1 --> Add To Cart 2 --> View Order History 3 --> Update Order Status 4 --> Log Out ");
        				    	      ch2 = scan.nextInt();
        				    	   
        				              switch(ch2)
        				              {
        				        	   
        				        	      case 1: // select products into cart
        				        		          cart.addCart(custId);
            				              break;
            				               				        	   
        				        	      case 2: //view order history
        				        		           customerDAO.viewOrderHistory(custId);
        				        		           
        				        	      break;
        				        	   
        				        	      case 3: // update order status
        				        		          stat = customer.orderUpdate(custId);
        				        		          if(stat == true)
        				        					{ 
        				        		        	  log.info("Order Updated");
        				        					}
        				        					else
        				        					{
        				        						log.info("Check order ID");
        				        					}
        				        	      break;  
        				        	    
        				        	      case 4: // log out
        				        		          log.info("\nLogging Out");
        				        	      break;
        				               }   
    				    	        }
    				    	     }   
    				    	     else   
    				    		     log.info("Check Your Credentials");
    				    	  
    				       } 
    				       catch (Exception e)    
            			   {
    				    	   log.warn(e.getMessage()); 
    				    	   System.out.println(e);
    				       }
            			   
            		   }
				       
            		   
            		  
			   break;
			   
			   case 3: log.info("---------------------Exiting App------------------------");
			   break;
			}
			
           	   
		}
	  }
   }
