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
public class SalesPlayMappingInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;

	private String painPoint1;
	private Integer spmapId1;
	private String painPoint2;
	private Integer spmapId2;
	private String painPoint3;
	private Integer spmapId3;
	private String painPoint4;
	private Integer spmapId4;
	/**
	 * @return the painPoint1
	 */
	public String getPainPoint1() {
		return painPoint1;
	}
	/**
	 * @param painPoint1 the painPoint1 to set
	 */
	public void setPainPoint1(String painPoint1) {
		this.painPoint1 = painPoint1;
	}
	/**
	 * @return the painPoint2
	 */
	public String getPainPoint2() {
		return painPoint2;
	}
	/**
	 * @param painPoint2 the painPoint2 to set
	 */
	public void setPainPoint2(String painPoint2) {
		this.painPoint2 = painPoint2;
	}
	/**
	 * @return the painPoint3
	 */
	public String getPainPoint3() {
		return painPoint3;
	}
	/**
	 * @param painPoint3 the painPoint3 to set
	 */
	public void setPainPoint3(String painPoint3) {
		this.painPoint3 = painPoint3;
	}
	/**
	 * @return the painPoint4
	 */
	public String getPainPoint4() {
		return painPoint4;
	}
	/**
	 * @param painPoint4 the painPoint4 to set
	 */
	public void setPainPoint4(String painPoint4) {
		this.painPoint4 = painPoint4;
	}
	/**
	 * @return the spmapId1
	 */
	public Integer getSpmapId1() {
		return spmapId1;
	}
	/**
	 * @param spmapId1 the spmapId1 to set
	 */
	public void setSpmapId1(Integer spmapId1) {
		this.spmapId1 = spmapId1;
	}
	/**
	 * @return the spmapId2
	 */
	public Integer getSpmapId2() {
		return spmapId2;
	}
	/**
	 * @param spmapId2 the spmapId2 to set
	 */
	public void setSpmapId2(Integer spmapId2) {
		this.spmapId2 = spmapId2;
	}
	/**
	 * @return the spmapId3
	 */
	public Integer getSpmapId3() {
		return spmapId3;
	}
	/**
	 * @param spmapId3 the spmapId3 to set
	 */
	public void setSpmapId3(Integer spmapId3) {
		this.spmapId3 = spmapId3;
	}
	/**
	 * @return the spmapId4
	 */
	public Integer getSpmapId4() {
		return spmapId4;
	}
	/**
	 * @param spmapId4 the spmapId4 to set
	 */
	public void setSpmapId4(Integer spmapId4) {
		this.spmapId4 = spmapId4;
	}
	


}
