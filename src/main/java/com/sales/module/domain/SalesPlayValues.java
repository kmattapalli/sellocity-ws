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
@Table(name="SC_SALESPLAY_VALUES", uniqueConstraints = @UniqueConstraint(columnNames = "VALUE_ID"))
public class SalesPlayValues implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	@Id
	@Column(name="VALUE_ID",unique = true, nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer valueId;
	
	@Column(name="TITLE",length = 1000)
	private String title;
	
	@Column(name="VALUE",length = 1000)
	private String value;

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
	 * @return the valueId
	 */
	public Integer getValueId() {
		return valueId;
	}

	/**
	 * @param valueId the valueId to set
	 */
	public void setValueId(Integer valueId) {
		this.valueId = valueId;
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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




}
