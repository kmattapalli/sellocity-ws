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
public class ProductInfoWrapper implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;

	private ProductInfo[] productData;

	/**
	 * @return the productData
	 */
	public ProductInfo[] getProductData() {
		return productData;
	}

	/**
	 * @param productData the productData to set
	 */
	public void setProductData(ProductInfo[] productData) {
		this.productData = productData;
	}



}
