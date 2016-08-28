package com.sales.module.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author vijay
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	private String clientName;
	private String customerClientContact;
	private String customerClientEmail;

	private String salesPlayName;

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the customerClientContact
	 */
	public String getCustomerClientContact() {
		return customerClientContact;
	}

	/**
	 * @param customerClientContact the customerClientContact to set
	 */
	public void setCustomerClientContact(String customerClientContact) {
		this.customerClientContact = customerClientContact;
	}

	/**
	 * @return the customerClientEmail
	 */
	public String getCustomerClientEmail() {
		return customerClientEmail;
	}

	/**
	 * @param customerClientEmail the customerClientEmail to set
	 */
	public void setCustomerClientEmail(String customerClientEmail) {
		this.customerClientEmail = customerClientEmail;
	}

	/**
	 * @return the salesPlayName
	 */
	public String getSalesPlayName() {
		return salesPlayName;
	}

	/**
	 * @param salesPlayName the salesPlayName to set
	 */
	public void setSalesPlayName(String salesPlayName) {
		this.salesPlayName = salesPlayName;
	}




}
