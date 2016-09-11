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
 * The persistent class for the SC_SALESPLAY_RESPONSE database table.
 * 
 */
@Entity
@Table(name="SC_SALESPLAY_RESPONSE")
@NamedQuery(name="ScSalesplayResponse.findAll", query="SELECT s FROM ScSalesplayResponse s")
public class ScSalesplayResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private int responseId;
	private Timestamp dateCreated;
	private String rdescription;
	private String response;
	private ScSalesplay scSalesplay;
	private ScStatus scStatus;

	public ScSalesplayResponse() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RESPONSE_ID")
	public int getResponseId() {
		return this.responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}


	@Column(name="DATE_CREATED")
	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Column(name="RDESCRIPTION")
	public String getRdescription() {
		return this.rdescription;
	}

	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}


	@Column(name="RESPONSE")
	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}


	//bi-directional many-to-one association to ScSalesplay
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SPID")
	public ScSalesplay getScSalesplay() {
		return this.scSalesplay;
	}

	public void setScSalesplay(ScSalesplay scSalesplay) {
		this.scSalesplay = scSalesplay;
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