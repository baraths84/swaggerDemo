package com.sample.sprinmvc;

import java.util.ArrayList;
import java.util.UUID;

public interface CustomerBo {

	UUID addCustomer(CustomerDTO customerDTO);
	
	String addCustomerReturnValue();
	
	void addCustomerThrowException() throws Exception;
	
	void addCustomerAround(String name);
	
	public CustomerDTO getCustomer(UUID uuid);
	
	public ArrayList<CustomerDTO> getFriends();
	
	public void deleteFriend(UUID uuid);
	
	public boolean updateFriend(CustomerDTO customerDTO);
	
	public void addCustomerTest(CustomerDTO customerDTO);
}