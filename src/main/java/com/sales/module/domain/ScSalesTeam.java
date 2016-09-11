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
 * The persistent class for the SC_SALES_TEAM database table.
 * 
 */
@Entity
@Table(name="SC_SALES_TEAM")
@NamedQuery(name="ScSalesTeam.findAll", query="SELECT s FROM ScSalesTeam s")
public class ScSalesTeam implements Serializable {
	private static final long serialVersionUID = 1L;
	private int stId;
	private Timestamp dateCreated;
	private Timestamp lastupdatedDate;
	private ScUser scUser1;
	private ScUser scUser2;
	private ScUser scUser3;
	private ScUser scUser4;

	public ScSalesTeam() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ST_ID")
	public int getStId() {
		return this.stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
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
	@JoinColumn(name="LASTMODIFIED_BY")
	public ScUser getScUser2() {
		return this.scUser2;
	}

	public void setScUser2(ScUser scUser2) {
		this.scUser2 = scUser2;
	}


	//bi-directional many-to-one association to ScUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MGR_ID")
	public ScUser getScUser3() {
		return this.scUser3;
	}

	public void setScUser3(ScUser scUser3) {
		this.scUser3 = scUser3;
	}


	//bi-directional many-to-one association to ScUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SUID")
	public ScUser getScUser4() {
		return this.scUser4;
	}

	public void setScUser4(ScUser scUser4) {
		this.scUser4 = scUser4;
	}

}