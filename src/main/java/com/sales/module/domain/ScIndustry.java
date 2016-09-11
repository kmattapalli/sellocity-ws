package com.sales.module.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SC_INDUSTRY database table.
 * 
 */
@Entity
@Table(name="SC_INDUSTRY")
@NamedQuery(name="ScIndustry.findAll", query="SELECT s FROM ScIndustry s")
public class ScIndustry implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer industryId;
	private Integer createdBy;
	private Timestamp dateCreated;
	private Integer lastupdatedBy;
	private Timestamp lastupdatedDate;
	private String name;
	private List<ScClient> scClients;
	private List<ScCustomer> scCustomers;

	public ScIndustry() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="INDUSTRY_ID")
	public Integer getIndustryId() {
		return this.industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}


	@Column(name="CREATED_BY")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="DATE_CREATED")
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


	//bi-directional many-to-one association to ScClient
	@OneToMany(mappedBy="scIndustry")
	@JsonIgnore
	public List<ScClient> getScClients() {
		return this.scClients;
	}

	public void setScClients(List<ScClient> scClients) {
		this.scClients = scClients;
	}

	public ScClient addScClient(ScClient scClient) {
		getScClients().add(scClient);
		scClient.setScIndustry(this);

		return scClient;
	}

	public ScClient removeScClient(ScClient scClient) {
		getScClients().remove(scClient);
		scClient.setScIndustry(null);

		return scClient;
	}


	//bi-directional many-to-one association to ScCustomer
	@OneToMany(mappedBy="scIndustry")
	@JsonIgnore
	public List<ScCustomer> getScCustomers() {
		return this.scCustomers;
	}

	public void setScCustomers(List<ScCustomer> scCustomers) {
		this.scCustomers = scCustomers;
	}

	public ScCustomer addScCustomer(ScCustomer scCustomer) {
		getScCustomers().add(scCustomer);
		scCustomer.setScIndustry(this);

		return scCustomer;
	}

	public ScCustomer removeScCustomer(ScCustomer scCustomer) {
		getScCustomers().remove(scCustomer);
		scCustomer.setScIndustry(null);

		return scCustomer;
	}

}