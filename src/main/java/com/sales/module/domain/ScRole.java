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


/**
 * The persistent class for the SC_ROLES database table.
 * 
 */
@Entity
@Table(name="SC_ROLES")
@NamedQuery(name="ScRole.findAll", query="SELECT s FROM ScRole s")
public class ScRole implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer rleId;
	private Integer createdBy;
	private Timestamp dateCreated;
	private Integer lastupdatedBy;
	private Timestamp lastupdatedDate;
	private String name;
	private String rdescription;
	private List<ScUser> scUsers;

	public ScRole() {
	}


	@Id
	@Column(name="RLE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getRleId() {
		return this.rleId;
	}

	public void setRleId(Integer rleId) {
		this.rleId = rleId;
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


	@Column(name="RDESCRIPTION")
	public String getRdescription() {
		return this.rdescription;
	}

	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}


	//bi-directional many-to-one association to ScUser
	@OneToMany(mappedBy="scRole")
	public List<ScUser> getScUsers() {
		return this.scUsers;
	}

	public void setScUsers(List<ScUser> scUsers) {
		this.scUsers = scUsers;
	}

	public ScUser addScUser(ScUser scUser) {
		getScUsers().add(scUser);
		scUser.setScRole(this);

		return scUser;
	}

	public ScUser removeScUser(ScUser scUser) {
		getScUsers().remove(scUser);
		scUser.setScRole(null);

		return scUser;
	}

}