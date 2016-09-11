package com.sales.module.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the SC_CORE_TABLE_AUDIT database table.
 * 
 */
@Entity
@Table(name="SC_CORE_TABLE_AUDIT")
@NamedQuery(name="ScCoreTableAudit.findAll", query="SELECT s FROM ScCoreTableAudit s")
public class ScCoreTableAudit implements Serializable {
	private static final long serialVersionUID = 1L;
	private String atype;
	private int crecId;
	private String ctable;
	private Timestamp dateCreated;
	private int id;
	private String uname;

	public ScCoreTableAudit() {
	}


	@Column(name="ATYPE")
	public String getAtype() {
		return this.atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}


	@Column(name="CREC_ID")
	public int getCrecId() {
		return this.crecId;
	}

	public void setCrecId(int crecId) {
		this.crecId = crecId;
	}


	@Column(name="CTABLE")
	public String getCtable() {
		return this.ctable;
	}

	public void setCtable(String ctable) {
		this.ctable = ctable;
	}


	@Column(name="DATE_CREATED")
	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Column(name="ID")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="UNAME")
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}