/**
 * 
 */
package com.sample.sprinmvc;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author ravi.ranjan
 *
 */
public interface CustomerDAO {

	public UUID insertData(CustomerDTO CustomerDTO);
	
	public ArrayList<CustomerDTO> getAllCustomers();
	
	public CustomerDTO getCustomer(UUID uuid);
	
	public void deleteCustomer(UUID uuid);
	
	public boolean UpdateCustomer(CustomerDTO friend);
	
	
}
