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


/**
 * The persistent class for the SC_COMPETETIVE_COMPARE database table.
 * 
 */
@Entity
@Table(name="SC_COMPETETIVE_COMPARE")
@NamedQuery(name="ScCompetetiveCompare.findAll", query="SELECT s FROM ScCompetetiveCompare s")
public class ScCompetetiveCompare implements Serializable {
	private static final long serialVersionUID = 1L;
	private int compareId;
	private String competitor;
	private Timestamp dateCreated;
	private String feature;
	private Timestamp lastupdatedDate;
	private String value;
	private ScSalesplayMapping scSalesplayMapping;
	private ScStatus scStatus;

	public ScCompetetiveCompare() {
	}


	@Id
	@Column(name="COMPARE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCompareId() {
		return this.compareId;
	}

	public void setCompareId(int compareId) {
		this.compareId = compareId;
	}


	@Column(name="COMPETITOR")
	public String getCompetitor() {
		return this.competitor;
	}

	public void setCompetitor(String competitor) {
		this.competitor = competitor;
	}


	@Column(name="DATE_CREATED")
	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Column(name="FEATURE")
	public String getFeature() {
		return this.feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}


	@Column(name="LASTUPDATED_DATE")
	public Timestamp getLastupdatedDate() {
		return this.lastupdatedDate;
	}

	public void setLastupdatedDate(Timestamp lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}


	@Column(name="[VALUE]")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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