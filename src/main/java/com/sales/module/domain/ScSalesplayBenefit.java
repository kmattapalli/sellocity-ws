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
 * The persistent class for the SC_SALESPLAY_BENEFITS database table.
 * 
 */
@Entity
@Table(name="SC_SALESPLAY_BENEFITS")
@NamedQuery(name="ScSalesplayBenefit.findAll", query="SELECT s FROM ScSalesplayBenefit s")
public class ScSalesplayBenefit implements Serializable {
	private static final long serialVersionUID = 1L;
	private int benefitId;
	private String benefit;
	private Timestamp dateCreated;
	private Timestamp lastupdatedDate;
	private String title;
	@JsonIgnore
	private ScSalesplayMapping scSalesplayMapping;
	@JsonIgnore
	private ScStatus scStatus;

	public ScSalesplayBenefit() {
	}


	@Id
	@Column(name="BENEFIT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getBenefitId() {
		return this.benefitId;
	}

	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}


	@Column(name="BENEFIT")
	public String getBenefit() {
		return this.benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
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


	@Column(name="TITLE")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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