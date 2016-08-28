package com.sales.module.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author vijay
 *
 */
@Entity
@Table(name="SC_SALESPLAY_MAPPING", uniqueConstraints = @UniqueConstraint(columnNames = "SPMAP_ID"))
public class SalesPlayMapping implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	@Id
	@Column(name="SPMAP_ID",unique = true, nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long salesPlayKey;
	
	@ManyToOne
	@JoinColumn(name="SPID")
	@JsonIgnore
	private SalesPlay salesPlay;

	@Column(name="TITLE",length = 1000)
	private String title;
	
	@Column(name="PAIN_POINT_IMAGE",length = 250)
	private String painPointImage;
	
	@Column(name="PAIN_POINT",length = 1000)
	private String painPoint;
	
	@Column(name="PRODUCT_NAME",length = 255)
	private String productName;
	
	@Column(name="PRODUCT_INFO",length = 1000)
	private String productInfo;
	
	@Column(name="PRODUCT_IMAGE",length = 255)
	private String productImage;

	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;

	@Column(name="DATE_CREATED")
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdDate;
	
	@Column(name="LASTUPDATED_DATE")
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime lastUpdated;

	/**
	 * @return the salesPlayKey
	 */
	public Long getSalesPlayKey() {
		return salesPlayKey;
	}

	/**
	 * @param salesPlayKey the salesPlayKey to set
	 */
	public void setSalesPlayKey(Long salesPlayKey) {
		this.salesPlayKey = salesPlayKey;
	}

	/**
	 * @return the salesPlay
	 */
	public SalesPlay getSalesPlay() {
		return salesPlay;
	}

	/**
	 * @param salesPlay the salesPlay to set
	 */
	public void setSalesPlay(SalesPlay salesPlay) {
		this.salesPlay = salesPlay;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the painPointImage
	 */
	public String getPainPointImage() {
		return painPointImage;
	}

	/**
	 * @param painPointImage the painPointImage to set
	 */
	public void setPainPointImage(String painPointImage) {
		this.painPointImage = painPointImage;
	}

	/**
	 * @return the painPoint
	 */
	public String getPainPoint() {
		return painPoint;
	}

	/**
	 * @param painPoint the painPoint to set
	 */
	public void setPainPoint(String painPoint) {
		this.painPoint = painPoint;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

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
	 * @return the productImage
	 */
	public String getProductImage() {
		return productImage;
	}

	/**
	 * @param productImage the productImage to set
	 */
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the createdDate
	 */
	public DateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastUpdated
	 */
	public DateTime getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(DateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	



}
