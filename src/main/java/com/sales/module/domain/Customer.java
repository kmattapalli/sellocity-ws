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
 * @author Vijay
 *
 */
@Entity
@Table(name="SC_CUSTOMERS",  uniqueConstraints = @UniqueConstraint(columnNames = "CUST_ID"))
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;
	
	@Id
	@Column(name="CUST_ID",unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="INDUSTRY")
	private String industry;
	
	@Column(name="DATE_CREATED")
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdBy;
	
	@Column(name="LOGO")
	private String logo;
	
	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;	
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy="customer")
	private List<Clients> clients;


	
	@OneToMany( fetch = FetchType.LAZY, mappedBy="customer")
	private List<Products> products;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy="customer")
	private List<SalesPlay> salesPlay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}



	/**
	 * @return the clients
	 */
	public List<Clients> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Clients> clients) {
		this.clients = clients;
	}


	/**
	 * @return the custId
	 */
	public Integer getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(Integer custId) {
		this.custId = custId;
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
	 * @return the createdBy
	 */
	public DateTime getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(DateTime createdBy) {
		this.createdBy = createdBy;
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
	 * @return the products
	 */
	public List<Products> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Products> products) {
		this.products = products;
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


	
	

}
