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
 * The persistent class for the SC_SALESPLAY_COMMON_QA database table.
 * 
 */
@Entity
@Table(name="SC_SALESPLAY_COMMON_QA")
@NamedQuery(name="ScSalesplayCommonQa.findAll", query="SELECT s FROM ScSalesplayCommonQa s")
public class ScSalesplayCommonQa implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cqaId;
	private String answer;
	private Timestamp dateCreated;
	private String imageUrl;
	private Timestamp lastupdatedDate;
	private String question;
	@JsonIgnore
	private ScSalesplayMapping scSalesplayMapping;
	@JsonIgnore
	private ScStatus scStatus;

	public ScSalesplayCommonQa() {
	}


	@Id
	@Column(name="CQA_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCqaId() {
		return this.cqaId;
	}

	public void setCqaId(int cqaId) {
		this.cqaId = cqaId;
	}


	@Column(name="ANSWER")
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Column(name="DATE_CREATED")
	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Column(name="IMAGE_URL")
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Column(name="LASTUPDATED_DATE")
	public Timestamp getLastupdatedDate() {
		return this.lastupdatedDate;
	}

	public void setLastupdatedDate(Timestamp lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}


	@Column(name="QUESTION")
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
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