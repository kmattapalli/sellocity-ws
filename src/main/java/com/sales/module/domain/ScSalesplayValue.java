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
 * The persistent class for the SC_SALESPLAY_VALUES database table.
 * 
 */
@Entity
@Table(name="SC_SALESPLAY_VALUES")
@NamedQuery(name="ScSalesplayValue.findAll", query="SELECT s FROM ScSalesplayValue s")
public class ScSalesplayValue implements Serializable {
	private static final long serialVersionUID = 1L;
	private int valueId;
	private Timestamp dateCreated;
	private Timestamp lastupdatedDate;
	private String title;
	private String value;
	private ScSalesplayMapping scSalesplayMapping;
	private ScStatus scStatus;

	public ScSalesplayValue() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="VALUE_ID")
	public int getValueId() {
		return this.valueId;
	}

	public void setValueId(int valueId) {
		this.valueId = valueId;
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