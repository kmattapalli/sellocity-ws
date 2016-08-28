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
@Table(name="SC_USERS",uniqueConstraints = @UniqueConstraint(name="USER_unique_constaint", columnNames = {"SUID"}))
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	@Id
	@Column(name="SUID",unique = true, nullable = false,length = 20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer suId;

	@Column(name="UNAME",length = 20)
	private String uName;	

	@Column(name="PWD",length = 20)
	private String password;	
	
	@Column(name="LASTNAME",length = 20)
	private String lastName;
	
	@Column(name="FIRSTNAME",length = 20)
	private String firstName;
	
	@Column(name="DESIGNATION",length = 20)
	private String designation;
	
	@Column(name="PHONE",length = 20)
	private String phone;
	
	@Column(name="EMAIL",length = 255)
	private String email;
	
	@Column(name="CADDRESS",length = 255)
	private String cAddress;
	
	@Column(name="CITY",length = 50)
	private String city;
	
	@Column(name="CSTATE",length = 20)
	private String CState;
	
	@Column(name="ZIP",length = 20)
	private String zip;
	
	@Column(name="COUNTRY",length = 255)
	private String country;
	
	@Column(name="IMAGE_URL",length = 255)
	private String imageURL;
	
	@Column(name="DATE_CREATED",length = 20)
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdDate;
	
	@Temporal(TemporalType.DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="LASTUPDATED_DATE",length = 20)
	private DateTime lastUpdated;
	
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="RLE_ID")
	private Roles roles;

	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;

	@OneToMany( fetch = FetchType.LAZY, mappedBy="clients")
	private List<SalesPlay> salesPlay;

	/**
	 * @return the suId
	 */
	public Integer getSuId() {
		return suId;
	}

	/**
	 * @param suId the suId to set
	 */
	public void setSuId(Integer suId) {
		this.suId = suId;
	}

	/**
	 * @return the uName
	 */
	public String getuName() {
		return uName;
	}

	/**
	 * @param uName the uName to set
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the cAddress
	 */
	public String getcAddress() {
		return cAddress;
	}

	/**
	 * @param cAddress the cAddress to set
	 */
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the cState
	 */
	public String getCState() {
		return CState;
	}

	/**
	 * @param cState the cState to set
	 */
	public void setCState(String cState) {
		CState = cState;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
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
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	

}
