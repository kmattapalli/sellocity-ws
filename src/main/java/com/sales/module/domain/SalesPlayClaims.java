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



/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author vijay
 *
 */
@Entity
@Table(name="SC_SALESPLAY_CLAIMS", uniqueConstraints = @UniqueConstraint(columnNames = "CLAIM_ID"))
public class SalesPlayClaims implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	@Id
	@Column(name="CLAIM_ID",unique = true, nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer claimId;
	
	@Column(name="NAME",length = 1000)
	private String name;
	
	@Column(name="IMAGE_URL",length = 1000)
	private String imageUrl;

	@ManyToOne
	@JoinColumn(name="SPMAP_ID")
	private SalesPlayMapping salesPlayMapping;

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
	 * @return the claimId
	 */
	public Integer getClaimId() {
		return claimId;
	}

	/**
	 * @param claimId the claimId to set
	 */
	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the salesPlayMapping
	 */
	public SalesPlayMapping getSalesPlayMapping() {
		return salesPlayMapping;
	}

	/**
	 * @param salesPlayMapping the salesPlayMapping to set
	 */
	public void setSalesPlayMapping(SalesPlayMapping salesPlayMapping) {
		this.salesPlayMapping = salesPlayMapping;
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
