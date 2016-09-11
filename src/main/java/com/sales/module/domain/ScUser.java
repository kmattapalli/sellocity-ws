package com.sales.module.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SC_USERS database table.
 * 
 */
@Entity
@Table(name="SC_USERS")
@NamedQuery(name="ScUser.findAll", query="SELECT s FROM ScUser s")
public class ScUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer suid;
	private String caddress;
	private String city;
	private String country;
	private Integer createdBy;
	private String cstate;
	private Timestamp dateCreated;
	private String designation;
	private String email;
	private byte[] encpwd;
	private String firstname;
	private String imageUrl;
	private String lastname;
	private Integer lastupdatedBy;
	private Timestamp lastupdatedDate;
	private Integer managerId;
	private String phone;
	private String pwd;
	private Integer token;
	private String uname;
	private String zip;
	private List<ScClient> scClients1;
	private List<ScClient> scClients2;
	private List<ScProduct> scProducts1;
	private List<ScProduct> scProducts2;
	private List<ScSalesplay> scSalesplays1;
	private List<ScSalesplay> scSalesplays2;
	private List<ScSalesplay> scSalesplays3;
	private List<ScSalesTeam> scSalesTeams1;
	private List<ScSalesTeam> scSalesTeams2;
	private List<ScSalesTeam> scSalesTeams3;
	private List<ScSalesTeam> scSalesTeams4;
	private ScCustomer scCustomer;
	private ScRole scRole;
	private ScStatus scStatus;

	public ScUser() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SUID")
	public Integer getSuid() {
		return this.suid;
	}

	public void setSuid(Integer suid) {
		this.suid = suid;
	}


	@Column(name="CADDRESS")
	public String getCaddress() {
		return this.caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	@Column(name="CITY")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(name="COUNTRY")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Column(name="CREATED_BY")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="CSTATE")
	public String getCstate() {
		return this.cstate;
	}

	public void setCstate(String cstate) {
		this.cstate = cstate;
	}


	@Column(name="DATE_CREATED")
	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Column(name="DESIGNATION")
	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	@Column(name="EMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="ENCPWD")
	public byte[] getEncpwd() {
		return this.encpwd;
	}

	public void setEncpwd(byte[] encpwd) {
		this.encpwd = encpwd;
	}


	@Column(name="FIRSTNAME")
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	@Column(name="IMAGE_URL")
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Column(name="LASTNAME")
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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


	@Column(name="MANAGER_ID")
	public Integer getManagerId() {
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}


	@Column(name="PHONE")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(name="PWD")
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Column(name="TOKEN")
	public Integer getToken() {
		return this.token;
	}

	public void setToken(Integer token) {
		this.token = token;
	}


	@Column(name="UNAME")
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}


	@Column(name="ZIP")
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}


	//bi-directional many-to-one association to ScClient
	@OneToMany(mappedBy="scUser1")
	@JsonIgnore
	public List<ScClient> getScClients1() {
		return this.scClients1;
	}

	public void setScClients1(List<ScClient> scClients1) {
		this.scClients1 = scClients1;
	}

	public ScClient addScClients1(ScClient scClients1) {
		getScClients1().add(scClients1);
		scClients1.setScUser1(this);

		return scClients1;
	}

	public ScClient removeScClients1(ScClient scClients1) {
		getScClients1().remove(scClients1);
		scClients1.setScUser1(null);

		return scClients1;
	}


	//bi-directional many-to-one association to ScClient
	@OneToMany(mappedBy="scUser2")
	@JsonIgnore
	public List<ScClient> getScClients2() {
		return this.scClients2;
	}

	public void setScClients2(List<ScClient> scClients2) {
		this.scClients2 = scClients2;
	}

	public ScClient addScClients2(ScClient scClients2) {
		getScClients2().add(scClients2);
		scClients2.setScUser2(this);

		return scClients2;
	}

	public ScClient removeScClients2(ScClient scClients2) {
		getScClients2().remove(scClients2);
		scClients2.setScUser2(null);

		return scClients2;
	}


	//bi-directional many-to-one association to ScProduct
	@OneToMany(mappedBy="scUser1")
	@JsonIgnore
	public List<ScProduct> getScProducts1() {
		return this.scProducts1;
	}

	public void setScProducts1(List<ScProduct> scProducts1) {
		this.scProducts1 = scProducts1;
	}

	public ScProduct addScProducts1(ScProduct scProducts1) {
		getScProducts1().add(scProducts1);
		scProducts1.setScUser1(this);

		return scProducts1;
	}

	public ScProduct removeScProducts1(ScProduct scProducts1) {
		getScProducts1().remove(scProducts1);
		scProducts1.setScUser1(null);

		return scProducts1;
	}


	//bi-directional many-to-one association to ScProduct
	@OneToMany(mappedBy="scUser2")
	@JsonIgnore
	public List<ScProduct> getScProducts2() {
		return this.scProducts2;
	}

	public void setScProducts2(List<ScProduct> scProducts2) {
		this.scProducts2 = scProducts2;
	}

	public ScProduct addScProducts2(ScProduct scProducts2) {
		getScProducts2().add(scProducts2);
		scProducts2.setScUser2(this);

		return scProducts2;
	}

	public ScProduct removeScProducts2(ScProduct scProducts2) {
		getScProducts2().remove(scProducts2);
		scProducts2.setScUser2(null);

		return scProducts2;
	}


	//bi-directional many-to-one association to ScSalesplay
	@OneToMany(mappedBy="scUser1")
	@JsonIgnore
	public List<ScSalesplay> getScSalesplays1() {
		return this.scSalesplays1;
	}

	public void setScSalesplays1(List<ScSalesplay> scSalesplays1) {
		this.scSalesplays1 = scSalesplays1;
	}

	public ScSalesplay addScSalesplays1(ScSalesplay scSalesplays1) {
		getScSalesplays1().add(scSalesplays1);
		scSalesplays1.setScUser1(this);

		return scSalesplays1;
	}

	public ScSalesplay removeScSalesplays1(ScSalesplay scSalesplays1) {
		getScSalesplays1().remove(scSalesplays1);
		scSalesplays1.setScUser1(null);

		return scSalesplays1;
	}


	//bi-directional many-to-one association to ScSalesplay
	@OneToMany(mappedBy="scUser2")
	@JsonIgnore
	public List<ScSalesplay> getScSalesplays2() {
		return this.scSalesplays2;
	}

	public void setScSalesplays2(List<ScSalesplay> scSalesplays2) {
		this.scSalesplays2 = scSalesplays2;
	}

	public ScSalesplay addScSalesplays2(ScSalesplay scSalesplays2) {
		getScSalesplays2().add(scSalesplays2);
		scSalesplays2.setScUser2(this);

		return scSalesplays2;
	}

	public ScSalesplay removeScSalesplays2(ScSalesplay scSalesplays2) {
		getScSalesplays2().remove(scSalesplays2);
		scSalesplays2.setScUser2(null);

		return scSalesplays2;
	}


	//bi-directional many-to-one association to ScSalesplay
	@OneToMany(mappedBy="scUser3")
	@JsonIgnore
	public List<ScSalesplay> getScSalesplays3() {
		return this.scSalesplays3;
	}

	public void setScSalesplays3(List<ScSalesplay> scSalesplays3) {
		this.scSalesplays3 = scSalesplays3;
	}

	public ScSalesplay addScSalesplays3(ScSalesplay scSalesplays3) {
		getScSalesplays3().add(scSalesplays3);
		scSalesplays3.setScUser3(this);

		return scSalesplays3;
	}

	public ScSalesplay removeScSalesplays3(ScSalesplay scSalesplays3) {
		getScSalesplays3().remove(scSalesplays3);
		scSalesplays3.setScUser3(null);

		return scSalesplays3;
	}


	//bi-directional many-to-one association to ScSalesTeam
	@OneToMany(mappedBy="scUser1")
	@JsonIgnore
	public List<ScSalesTeam> getScSalesTeams1() {
		return this.scSalesTeams1;
	}

	public void setScSalesTeams1(List<ScSalesTeam> scSalesTeams1) {
		this.scSalesTeams1 = scSalesTeams1;
	}

	public ScSalesTeam addScSalesTeams1(ScSalesTeam scSalesTeams1) {
		getScSalesTeams1().add(scSalesTeams1);
		scSalesTeams1.setScUser1(this);

		return scSalesTeams1;
	}

	public ScSalesTeam removeScSalesTeams1(ScSalesTeam scSalesTeams1) {
		getScSalesTeams1().remove(scSalesTeams1);
		scSalesTeams1.setScUser1(null);

		return scSalesTeams1;
	}


	//bi-directional many-to-one association to ScSalesTeam
	@OneToMany(mappedBy="scUser2")
	@JsonIgnore
	public List<ScSalesTeam> getScSalesTeams2() {
		return this.scSalesTeams2;
	}

	public void setScSalesTeams2(List<ScSalesTeam> scSalesTeams2) {
		this.scSalesTeams2 = scSalesTeams2;
	}

	public ScSalesTeam addScSalesTeams2(ScSalesTeam scSalesTeams2) {
		getScSalesTeams2().add(scSalesTeams2);
		scSalesTeams2.setScUser2(this);

		return scSalesTeams2;
	}

	public ScSalesTeam removeScSalesTeams2(ScSalesTeam scSalesTeams2) {
		getScSalesTeams2().remove(scSalesTeams2);
		scSalesTeams2.setScUser2(null);

		return scSalesTeams2;
	}


	//bi-directional many-to-one association to ScSalesTeam
	@OneToMany(mappedBy="scUser3")
	@JsonIgnore
	public List<ScSalesTeam> getScSalesTeams3() {
		return this.scSalesTeams3;
	}

	public void setScSalesTeams3(List<ScSalesTeam> scSalesTeams3) {
		this.scSalesTeams3 = scSalesTeams3;
	}

	public ScSalesTeam addScSalesTeams3(ScSalesTeam scSalesTeams3) {
		getScSalesTeams3().add(scSalesTeams3);
		scSalesTeams3.setScUser3(this);

		return scSalesTeams3;
	}

	public ScSalesTeam removeScSalesTeams3(ScSalesTeam scSalesTeams3) {
		getScSalesTeams3().remove(scSalesTeams3);
		scSalesTeams3.setScUser3(null);

		return scSalesTeams3;
	}


	//bi-directional many-to-one association to ScSalesTeam
	@OneToMany(mappedBy="scUser4")
	@JsonIgnore
	public List<ScSalesTeam> getScSalesTeams4() {
		return this.scSalesTeams4;
	}

	public void setScSalesTeams4(List<ScSalesTeam> scSalesTeams4) {
		this.scSalesTeams4 = scSalesTeams4;
	}

	public ScSalesTeam addScSalesTeams4(ScSalesTeam scSalesTeams4) {
		getScSalesTeams4().add(scSalesTeams4);
		scSalesTeams4.setScUser4(this);

		return scSalesTeams4;
	}

	public ScSalesTeam removeScSalesTeams4(ScSalesTeam scSalesTeams4) {
		getScSalesTeams4().remove(scSalesTeams4);
		scSalesTeams4.setScUser4(null);

		return scSalesTeams4;
	}


	//bi-directional many-to-one association to ScCustomer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUST_ID")
	public ScCustomer getScCustomer() {
		return this.scCustomer;
	}

	public void setScCustomer(ScCustomer scCustomer) {
		this.scCustomer = scCustomer;
	}


	//bi-directional many-to-one association to ScRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RLE_ID")
	public ScRole getScRole() {
		return this.scRole;
	}

	public void setScRole(ScRole scRole) {
		this.scRole = scRole;
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