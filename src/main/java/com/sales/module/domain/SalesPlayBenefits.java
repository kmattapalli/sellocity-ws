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
@Table(name="SC_SALESPLAY_BENEFITS", uniqueConstraints = @UniqueConstraint(columnNames = "BENEFIT_ID"))
public class SalesPlayBenefits implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	@Id
	@Column(name="BENEFIT_ID",unique = true, nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer benefitID;
	
	@Column(name="TITLE",length = 1000)
	private String name;
	
	@Column(name="BENEFIT",length = 1000)
	private String benefit;

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
	 * @return the benefitID
	 */
	public Integer getBenefitID() {
		return benefitID;
	}

	/**
	 * @param benefitID the benefitID to set
	 */
	public void setBenefitID(Integer benefitID) {
		this.benefitID = benefitID;
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
	 * @return the benefit
	 */
	public String getBenefit() {
		return benefit;
	}

	/**
	 * @param benefit the benefit to set
	 */
	public void setBenefit(String benefit) {
		this.benefit = benefit;
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
