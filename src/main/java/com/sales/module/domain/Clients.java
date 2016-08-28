package com.sales.module.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="SC_CLIENTS",uniqueConstraints = @UniqueConstraint(name="CLIENT_unique_constaint", columnNames = {"CLIENT_ID","CUST_ID"}))
public class Clients implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	@Id
	@Column(name="CLIENT_ID",unique = true, nullable = false,length = 20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer clientId;
	
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;
	
	@Column(name="NAME",length = 255)
	private String name;
	
	@Column(name="COUNTRY",length = 20)
	private String country;
	
	@Column(name="INDUSTRY",length = 255)
	private String industry;
	
	@Column(name="LOGO",length=255)
	private String logo;

	@Column(name="DATE_CREATED",length = 20)
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdDate;
	
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="LASTUPDATED_DATE",length = 20)
	private DateTime lastUpdated;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="SUID", updatable = false)
	private User createdBy;
	
//	@ManyToOne(optional=true)
//	@JoinColumn(name="SUID", insertable = false)
//	private User lastUpdatedBy;
	
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy="clients")
	private List<SalesPlay> salesPlay;

	@ManyToOne
	@JoinColumn(name="RLE_ID")
	private Roles roles;

	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}




	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the salesPlay
	 */
	public List<SalesPlay> getSalesPlay() {
		return salesPlay;
	}

	/**
	 * @param salesPlay the salesPlay to set
	 */
	public void setSalesPlay(List<SalesPlay> salesPlay) {
		this.salesPlay = salesPlay;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the roles
	 */
	public Roles getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Roles roles) {
		this.roles = roles;
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
	 * @return the createdBy
	 */
	public User getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
/*
	*//**
	 * @return the lastUpdatedBy
	 *//*
	public User getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	*//**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 *//*
	public void setLastUpdatedBy(User lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}*/

	

}
