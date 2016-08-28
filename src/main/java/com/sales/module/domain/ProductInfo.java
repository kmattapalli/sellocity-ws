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
public class ProductInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	private String productInfo;
	private byte[] painPointImage;
	/**
	 * @return the productInfo
	 */
	public String getProductInfo() {
		return productInfo;
	}
	/**
	 * @param productInfo the productInfo to set
	 */
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	/**
	 * @return the painPointImage
	 */
	public byte[] getPainPointImage() {
		return painPointImage;
	}
	/**
	 * @param painPointImage the painPointImage to set
	 */
	public void setPainPointImage(byte[] painPointImage) {
		this.painPointImage = painPointImage;
	}
	


}
