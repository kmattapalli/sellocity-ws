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
 * The persistent class for the SC_SALESPLAY database table.
 * 
 */
@Entity
@Table(name="SC_SALESPLAY")
@NamedQuery(name="ScSalesplay.findAll", query="SELECT s FROM ScSalesplay s")

public class ScSalesplay implements Serializable {
	private static final long serialVersionUID = 1L;
	private int spid;
	private String clientContactDesignation;
	private String clientContactEmail;
	private String clientContactName;
	private String clientName;
	private Timestamp dateCreated;
	private String globalId;
	private Timestamp lastupdatedDate;
	private String name;
	private String title;
	@JsonIgnore
	private ScClient scClient;
	@JsonIgnore
	private ScCustomer scCustomer;
	@JsonIgnore
	private ScStatus scStatus;
	@JsonIgnore 
	private ScUser scUser1;
	@JsonIgnore 
	private ScUser scUser2;
	@JsonIgnore 
	private ScUser scUser3;
	
	private List<ScSalesplayMapping> scSalesplayMappings;
	private List<ScSalesplayResponse> scSalesplayResponses;

	public ScSalesplay() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SPID")
	public int getSpid() {
		return this.spid;
	}

	public void setSpid(int spid) {
		this.spid = spid;
	}


	@Column(name="CLIENT_CONTACT_DESIGNATION")
	public String getClientContactDesignation() {
		return this.clientContactDesignation;
	}

	public void setClientContactDesignation(String clientContactDesignation) {
		this.clientContactDesignation = clientContactDesignation;
	}


	@Column(name="CLIENT_CONTACT_EMAIL")
	public String getClientContactEmail() {
		return this.clientContactEmail;
	}

	public void setClientContactEmail(String clientContactEmail) {
		this.clientContactEmail = clientContactEmail;
	}


	@Column(name="CLIENT_CONTACT_NAME")
	public String getClientContactName() {
		return this.clientContactName;
	}

	public void setClientContactName(String clientContactName) {
		this.clientContactName = clientContactName;
	}


	@Column(name="CLIENT_NAME")
	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	@Column(name="DATE_CREATED")
	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Column(name="GLOBAL_ID")
	public String getGlobalId() {
		return this.globalId;
	}

	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}


	@Column(name="LASTUPDATED_DATE")
	public Timestamp getLastupdatedDate() {
		return this.lastupdatedDate;
	}

	public void setLastupdatedDate(Timestamp lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}


	@Column(name="NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="TITLE")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	//bi-directional many-to-one association to ScClient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLIENT_ID")
	public ScClient getScClient() {
		return this.scClient;
	}

	public void setScClient(ScClient scClient) {
		this.scClient = scClient;
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
	@JoinColumn(name="SUID")
	public ScUser getScUser2() {
		return this.scUser2;
	}

	public void setScUser2(ScUser scUser2) {
		this.scUser2 = scUser2;
	}


	//bi-directional many-to-one association to ScUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LASTUPDATED_BY")
	public ScUser getScUser3() {
		return this.scUser3;
	}

	public void setScUser3(ScUser scUser3) {
		this.scUser3 = scUser3;
	}


	//bi-directional many-to-one association to ScSalesplayMapping
	@OneToMany(mappedBy="scSalesplay",fetch=FetchType.LAZY)
	public List<ScSalesplayMapping> getScSalesplayMappings() {
		return this.scSalesplayMappings;
	}

	public void setScSalesplayMappings(List<ScSalesplayMapping> scSalesplayMappings) {
		this.scSalesplayMappings = scSalesplayMappings;
	}

	public ScSalesplayMapping addScSalesplayMapping(ScSalesplayMapping scSalesplayMapping) {
		getScSalesplayMappings().add(scSalesplayMapping);
		scSalesplayMapping.setScSalesplay(this);

		return scSalesplayMapping;
	}

	public ScSalesplayMapping removeScSalesplayMapping(ScSalesplayMapping scSalesplayMapping) {
		getScSalesplayMappings().remove(scSalesplayMapping);
		scSalesplayMapping.setScSalesplay(null);

		return scSalesplayMapping;
	}


	//bi-directional many-to-one association to ScSalesplayResponse
	@OneToMany(mappedBy="scSalesplay")
	@JsonIgnore
	public List<ScSalesplayResponse> getScSalesplayResponses() {
		return this.scSalesplayResponses;
	}

	public void setScSalesplayResponses(List<ScSalesplayResponse> scSalesplayResponses) {
		this.scSalesplayResponses = scSalesplayResponses;
	}

	public ScSalesplayResponse addScSalesplayRespons(ScSalesplayResponse scSalesplayRespons) {
		getScSalesplayResponses().add(scSalesplayRespons);
		scSalesplayRespons.setScSalesplay(this);

		return scSalesplayRespons;
	}

	public ScSalesplayResponse removeScSalesplayRespons(ScSalesplayResponse scSalesplayRespons) {
		getScSalesplayResponses().remove(scSalesplayRespons);
		scSalesplayRespons.setScSalesplay(null);

		return scSalesplayRespons;
	}

}