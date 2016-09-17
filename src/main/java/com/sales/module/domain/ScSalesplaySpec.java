package com.sales.module.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SC_SALESPLAY_SPECS database table.
 * 
 */
@Entity
@Table(name="SC_SALESPLAY_SPECS")
@NamedQuery(name="ScSalesplaySpec.findAll", query="SELECT s FROM ScSalesplaySpec s")
public class ScSalesplaySpec implements Serializable {
	private static final long serialVersionUID = 1L;
	private int specId;
	private Timestamp dateCreated;
	private Timestamp lastupdatedDate;
	private String name;
	private String url;
	@JsonIgnore
	private ScSalesplayMapping scSalesplayMapping;
	@JsonIgnore
	private ScStatus scStatus;

	public ScSalesplaySpec() {
	}


	@Id
	@Column(name="SPEC_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getSpecId() {
		return this.specId;
	}

	public void setSpecId(int specId) {
		this.specId = specId;
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


	@Column(name="NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="URL")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	//bi-directional many-to-one association to ScSalesplayMapping
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SPMAP_ID")
	public ScSalesplayMapping getScSalesplayMapping() {
		return this.scSalesplayMapping;
	}

	public void setScSalesplayMapping(ScSalesplayMapping scSalesplayMapping) {
		this.scSalesplayMapping = scSalesplayMapping;
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

}