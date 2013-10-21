package com.sample.sprinmvc;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;

public class DbOperatioTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {

		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setAddress("Delhi");
		customerDTO.setFirstname("ravi");
		customerDTO.setLastname("ranjan");
		customerDTO.setDateofbirth("06/10/1989");

		//CustomerBoImpl  customerBoImpl = new CustomerBoImpl();
		//customerBoImpl.addCustomer(customerDTO);

		//assertEquals(customerBoImpl.getCustomer(customerDTO.getFriendid()), customerDTO);

		//friendservice.deleteFriend(friendDTO.getFriendId());
	}
}
