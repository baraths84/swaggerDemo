package com.sample.sprinmvc;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.sprinmvc.CustomerBo;

@Service
public class CustomerBoImpl implements CustomerBo {

	@Autowired
	CustomerDAO customerDAO;
	
	public UUID addCustomer(CustomerDTO customerDTO){
		System.out.println("addCustomer() is running ");
		//CustomerDAOImpl CustomerDAO = new CustomerDAOImpl();
		return customerDAO.insertData(customerDTO);
	}
	
	public void addCustomerTest(CustomerDTO customerDTO){
		System.out.println("addCustomer() is running ");
		//CustomerDAOImpl CustomerDAO = new CustomerDAOImpl();
		customerDAO.insertData(customerDTO);
		//return null;
	}
	
	public String addCustomerReturnValue(){
		System.out.println("addCustomerReturnValue() is running ");
		return "abc";
	}
	
	public void addCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running ");
		throw new Exception("Generic Error");
	}
	
	public void addCustomerAround(String name){
		System.out.println("addCustomerAround() is running, args : " + name);				
	}
	
	public CustomerDTO getCustomer(UUID uuid)
	{
		//CustomerDAOImpl customerDAO = new CustomerDAOImpl();
		return customerDAO.getCustomer(uuid);
	}
	
	public ArrayList<CustomerDTO> getFriends()
	{
		//CustomerDAOImpl customerDAO = new CustomerDAOImpl();
		return customerDAO.getAllCustomers();
	}
	
	public void deleteFriend(UUID uuid)
	{
		//CustomerDAOImpl customerDAO = new CustomerDAOImpl();
		customerDAO.deleteCustomer(uuid);
	}
	
	public boolean updateFriend(CustomerDTO customerDTO)
	{
		//CustomerDAOImpl customerDAO = new CustomerDAOImpl();
		return customerDAO.UpdateCustomer(customerDTO);
		
	}
}