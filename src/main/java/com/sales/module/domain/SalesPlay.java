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

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author vijay
 *
 */
@Entity
@Table(name="SC_SALESPLAY", uniqueConstraints = @UniqueConstraint(columnNames = "SPID"))
public class SalesPlay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="SPID",unique = true, nullable = false)
	private Integer spId;

	@Column(name="NAME",length=255)
	public String salesPlayName;
	
	@ManyToOne
	@JoinColumn(name="SUID")
	@JsonIgnore
	private User user;

	@OneToMany(mappedBy="salesPlay",fetch = FetchType.LAZY)
	private List<SalesPlayMapping> salesPlayMapping;
	
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	@JsonIgnore
	private Clients clients;
	
	@Column(name="GLOBAL_ID",length=255)
	private String globalId;
	
	@Column(name="DATE_CREATED")
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdDate;
	
	@Column(name="LASTUPDATED_DATE")
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime lastUpdated;
	
	@Column(name="CLIENT_CONTACT_NAME",length=255)
	private String clientContactName;

	@Column(name="CLIENT_CONTACT_DESIGNATION",length=255)
	private String clientContactDesignation;
	
	@Column(name="CLIENT_CONTACT_EMAIL",length=255)
	private String clientContactEmail;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;
	
	/**
	 * @return the spId
	 */
	public Integer getSpId() {
		return spId;
	}

	/**
	 * @param spId the spId to set
	 */
	public void setSpId(Integer spId) {
		this.spId = spId;
	}

	/**
	 * @return the salesPlayName
	 */
	public String getSalesPlayName() {
		return salesPlayName;
	}

	/**
	 * @param salesPlayName the salesPlayName to set
	 */
	public void setSalesPlayName(String salesPlayName) {
		this.salesPlayName = salesPlayName;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the salesPlayMapping
	 */
	public List<SalesPlayMapping> getSalesPlayMapping() {
		return salesPlayMapping;
	}

	/**
	 * @param salesPlayMapping the salesPlayMapping to set
	 */
	public void setSalesPlayMapping(List<SalesPlayMapping> salesPlayMapping) {
		this.salesPlayMapping = salesPlayMapping;
	}

	/**
	 * @return the clients
	 */
	public Clients getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Clients clients) {
		this.clients = clients;
	}

	/**
	 * @return the globalId
	 */
	public String getGlobalId() {
		return globalId;
	}

	/**
	 * @param globalId the globalId to set
	 */
	public void setGlobalId(String globalId) {
		this.globalId = globalId;
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
	 * @return the clientContactName
	 */
	public String getClientContactName() {
		return clientContactName;
	}

	/**
	 * @param clientContactName the clientContactName to set
	 */
	public void setClientContactName(String clientContactName) {
		this.clientContactName = clientContactName;
	}

	/**
	 * @return the clientContactDesignation
	 */
	public String getClientContactDesignation() {
		return clientContactDesignation;
	}

	/**
	 * @param clientContactDesignation the clientContactDesignation to set
	 */
	public void setClientContactDesignation(String clientContactDesignation) {
		this.clientContactDesignation = clientContactDesignation;
	}

	/**
	 * @return the clientContactEmail
	 */
	public String getClientContactEmail() {
		return clientContactEmail;
	}

	/**
	 * @param clientContactEmail the clientContactEmail to set
	 */
	public void setClientContactEmail(String clientContactEmail) {
		this.clientContactEmail = clientContactEmail;
	}

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


	

}
