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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SC_CLIENTS database table.
 * 
 */
@Entity
@Table(name="SC_CLIENTS")
@NamedQuery(name="ScClient.findAll", query="SELECT s FROM ScClient s")
public class ScClient implements Serializable {
	private static final long serialVersionUID = 1L;
	private int clientId;
	private String caddress;
	private String city;
	private String country;
	private String cstate;
	private Timestamp dateCreated;
	private Timestamp lastupdatedDate;
	private String logo;
	private String name;
	private String zip;
	private ScCustomer scCustomer;
	private ScIndustry scIndustry;
	private ScStatus scStatus;
	private ScUser scUser1;
	private ScUser scUser2;
	private List<ScSalesplay> scSalesplays;

	public ScClient() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CLIENT_ID")
	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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


	@Column(name="CSTATE")
	public String getCstate() {
		return this.cstate;
	}

	public void setCstate(String cstate) {
		this.cstate = cstate;
	}


	@Column(name="DATE_CREATED")
	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Column(name="LASTUPDATED_DATE")
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


	//bi-directional many-to-one association to ScCustomer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUST_ID")
	public ScCustomer getScCustomer() {
		return this.scCustomer;
	}

	public void setScCustomer(ScCustomer scCustomer) {
		this.scCustomer = scCustomer;
	}


	//bi-directional many-to-one association to ScIndustry
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INDUSTRY_ID")
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


	//bi-directional many-to-one association to ScUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CREATED_BY")
	public ScUser getScUser1() {
		return this.scUser1;
	}

	public void setScUser1(ScUser scUser1) {
		this.scUser1 = scUser1;
	}


	//bi-directional many-to-one association to ScUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LASTUPDATED_BY")
	public ScUser getScUser2() {
		return this.scUser2;
	}

	public void setScUser2(ScUser scUser2) {
		this.scUser2 = scUser2;
	}


	//bi-directional many-to-one association to ScSalesplay
	@OneToMany(mappedBy="scClient")
	@JsonIgnore
	public List<ScSalesplay> getScSalesplays() {
		return this.scSalesplays;
	}

	public void setScSalesplays(List<ScSalesplay> scSalesplays) {
		this.scSalesplays = scSalesplays;
	}

	public ScSalesplay addScSalesplay(ScSalesplay scSalesplay) {
		getScSalesplays().add(scSalesplay);
		scSalesplay.setScClient(this);

		return scSalesplay;
	}

	public ScSalesplay removeScSalesplay(ScSalesplay scSalesplay) {
		getScSalesplays().remove(scSalesplay);
		scSalesplay.setScClient(null);

		return scSalesplay;
	}

}