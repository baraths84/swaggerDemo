package com.sample.sprinmvc;

import java.util.UUID;

public class CustomerDTO {
	private UUID friendid;

	private String firstname;

	private String lastname;

	private String address;

	private String dateofbirth;

	CustomerDTO()
	{
		this.friendid = null;
		this.address = null;
		this.firstname = null;
		this.lastname = null;
		this.dateofbirth = null;
	}



	@Override
	public boolean equals(Object obj) {
		CustomerDTO CustomerDTO= (CustomerDTO)obj;
		
		return this.firstname.equalsIgnoreCase(CustomerDTO.getFirstname())
				&& this.lastname.equalsIgnoreCase(CustomerDTO.getLastname())
				&& this.address.equalsIgnoreCase(CustomerDTO.getAddress())
				&& this.dateofbirth.equals(CustomerDTO.getDateofbirth());
	}



	/**
	 * @return the friendid
	 */
	public UUID getFriendid() {
		return friendid;
	}



	/**
	 * @param friendid the friendid to set
	 */
	public void setFriendid(UUID friendid) {
		this.friendid = friendid;
	}



	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}



	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}



	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * @return the dateofbirth
	 */
	public String getDateofbirth() {
		return dateofbirth;
	}



	/**
	 * @param dateofbirth the dateofbirth to set
	 */
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

}
