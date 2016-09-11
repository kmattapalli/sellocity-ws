package com.sales.module.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SC_CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="SC_CUSTOMERS")
@NamedQuery(name="ScCustomer.findAll", query="SELECT s FROM ScCustomer s")
public class ScCustomer implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer custId;
	private String caddress;
	private String city;
	private String country;
	private Integer createdBy;
	private String cstate;
	private Timestamp dateCreated;
	private Integer lastupdatedBy;
	private Timestamp lastupdatedDate;
	private String logo;
	private String name;
	private String zip;
	private List<ScClient> scClients;
	private ScIndustry scIndustry;
	private ScStatus scStatus;
	private List<ScProduct> scProducts;
	private List<ScSalesplay> scSalesplays;
	private List<ScUser> scUsers;

	public ScCustomer() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CUST_ID")
	public Integer getCustId() {
		return this.custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}


	@Column(name="CADDRESS")
	public String getCaddress() {
		return this.caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	@Column(name="CITY")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(name="COUNTRY")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Column(name="CREATED_BY")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="CSTATE")
	public String getCstate() {
		return this.cstate;
	}

	public void setCstate(String cstate) {
		this.cstate = cstate;
	}


	@Column(name="DATE_CREATED")
	
	@PrePersist
	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Column(name="LASTUPDATED_BY")
	public Integer getLastupdatedBy() {
		return this.lastupdatedBy;
	}

	public void setLastupdatedBy(Integer lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}


	@Column(name="LASTUPDATED_DATE")
	
	@PrePersist
	public Timestamp getLastupdatedDate() {
		return this.lastupdatedDate;
	}

	public void setLastupdatedDate(Timestamp lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}


	@Column(name="LOGO")
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}


	@Column(name="NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="ZIP")
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}


	//bi-directional many-to-one association to ScClient
	@OneToMany(mappedBy="scCustomer")
	@JsonIgnore
	public List<ScClient> getScClients() {
		return this.scClients;
	}

	public void setScClients(List<ScClient> scClients) {
		this.scClients = scClients;
	}

	public ScClient addScClient(ScClient scClient) {
		getScClients().add(scClient);
		scClient.setScCustomer(this);

		return scClient;
	}

	public ScClient removeScClient(ScClient scClient) {
		getScClients().remove(scClient);
		scClient.setScCustomer(null);

		return scClient;
	}


	//bi-directional many-to-one association to ScIndustry
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INDUSTRY_ID")
	@JsonIgnore
	public ScIndustry getScIndustry() {
		return this.scIndustry;
	}

	public void setScIndustry(ScIndustry scIndustry) {
		this.scIndustry = scIndustry;
	}


	//bi-directional many-to-one association to ScStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CSTATUS", referencedColumnName="NAME")
	public ScStatus getScStatus() {
		return this.scStatus;
	}

	public void setScStatus(ScStatus scStatus) {
		this.scStatus = scStatus;
	}


	//bi-directional many-to-one association to ScProduct
	@OneToMany(mappedBy="scCustomer")
	@JsonIgnore
	public List<ScProduct> getScProducts() {
		return this.scProducts;
	}

	public void setScProducts(List<ScProduct> scProducts) {
		this.scProducts = scProducts;
	}

	public ScProduct addScProduct(ScProduct scProduct) {
		getScProducts().add(scProduct);
		scProduct.setScCustomer(this);

		return scProduct;
	}

	public ScProduct removeScProduct(ScProduct scProduct) {
		getScProducts().remove(scProduct);
		scProduct.setScCustomer(null);

		return scProduct;
	}


	//bi-directional many-to-one association to ScSalesplay
	@OneToMany(mappedBy="scCustomer")
	@JsonIgnore
	public List<ScSalesplay> getScSalesplays() {
		return this.scSalesplays;
	}

	public void setScSalesplays(List<ScSalesplay> scSalesplays) {
		this.scSalesplays = scSalesplays;
	}

	public ScSalesplay addScSalesplay(ScSalesplay scSalesplay) {
		getScSalesplays().add(scSalesplay);
		scSalesplay.setScCustomer(this);

		return scSalesplay;
	}

	public ScSalesplay removeScSalesplay(ScSalesplay scSalesplay) {
		getScSalesplays().remove(scSalesplay);
		scSalesplay.setScCustomer(null);

		return scSalesplay;
	}


	//bi-directional many-to-one association to ScUser
	@OneToMany(mappedBy="scCustomer")
	@JsonIgnore
	public List<ScUser> getScUsers() {
		return this.scUsers;
	}

	public void setScUsers(List<ScUser> scUsers) {
		this.scUsers = scUsers;
	}

	public ScUser addScUser(ScUser scUser) {
		getScUsers().add(scUser);
		scUser.setScCustomer(this);

		return scUser;
	}

	public ScUser removeScUser(ScUser scUser) {
		getScUsers().remove(scUser);
		scUser.setScCustomer(null);

		return scUser;
	}

}