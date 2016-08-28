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
public class ProductValues implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;

	private String productValues1;
	private String productValues2;
	private String productValues3;
	private String productValues4;
	/**
	 * @return the productValues1
	 */
	public String getProductValues1() {
		return productValues1;
	}
	/**
	 * @param productValues1 the productValues1 to set
	 */
	public void setProductValues1(String productValues1) {
		this.productValues1 = productValues1;
	}
	/**
	 * @return the productValues2
	 */
	public String getProductValues2() {
		return productValues2;
	}
	/**
	 * @param productValues2 the productValues2 to set
	 */
	public void setProductValues2(String productValues2) {
		this.productValues2 = productValues2;
	}
	/**
	 * @return the productValues3
	 */
	public String getProductValues3() {
		return productValues3;
	}
	/**
	 * @param productValues3 the productValues3 to set
	 */
	public void setProductValues3(String productValues3) {
		this.productValues3 = productValues3;
	}
	/**
	 * @return the productValues4
	 */
	public String getProductValues4() {
		return productValues4;
	}
	/**
	 * @param productValues4 the productValues4 to set
	 */
	public void setProductValues4(String productValues4) {
		this.productValues4 = productValues4;
	}

}
