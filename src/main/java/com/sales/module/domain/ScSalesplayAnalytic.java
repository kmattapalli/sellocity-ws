package com.sales.module.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the SC_SALESPLAY_ANALYTICS database table.
 * 
 */
@Entity
@Table(name="SC_SALESPLAY_ANALYTICS")
@NamedQuery(name="ScSalesplayAnalytic.findAll", query="SELECT s FROM ScSalesplayAnalytic s")
public class ScSalesplayAnalytic implements Serializable {
	private static final long serialVersionUID = 1L;
	private int aid;
	private String browser;
	private String clientContactEmail;
	private String clientName;
	private String device;
	private String eventname;
	private String ip;
	private String location;
	private String mgrFirstname;
	private int mgrId;
	private String mgrLastname;
	private String pageVisited;
	private String sessionId;
	private String spFirstname;
	private int spId;
	private String spLastname;
	private int spid;
	private int spmapId;
	private Timestamp startTime;

	public ScSalesplayAnalytic() {
	}


	@Id
	@Column(name="AID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getAid() {
		return this.aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}


	@Column(name="BROWSER")
	public String getBrowser() {
		return this.browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}


	@Column(name="CLIENT_CONTACT_EMAIL")
	public String getClientContactEmail() {
		return this.clientContactEmail;
	}

	public void setClientContactEmail(String clientContactEmail) {
		this.clientContactEmail = clientContactEmail;
	}


	@Column(name="CLIENT_NAME")
	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	@Column(name="DEVICE")
	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}


	@Column(name="EVENTNAME")
	public String getEventname() {
		return this.eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}


	@Column(name="IP")
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	@Column(name="LOCATION")
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	@Column(name="MGR_FIRSTNAME")
	public String getMgrFirstname() {
		return this.mgrFirstname;
	}

	public void setMgrFirstname(String mgrFirstname) {
		this.mgrFirstname = mgrFirstname;
	}


	@Column(name="MGR_ID")
	public int getMgrId() {
		return this.mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}


	@Column(name="MGR_LASTNAME")
	public String getMgrLastname() {
		return this.mgrLastname;
	}

	public void setMgrLastname(String mgrLastname) {
		this.mgrLastname = mgrLastname;
	}


	@Column(name="PAGE_VISITED")
	public String getPageVisited() {
		return this.pageVisited;
	}

	public void setPageVisited(String pageVisited) {
		this.pageVisited = pageVisited;
	}


	@Column(name="SESSION_ID")
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	@Column(name="SP_FIRSTNAME")
	public String getSpFirstname() {
		return this.spFirstname;
	}

	public void setSpFirstname(String spFirstname) {
		this.spFirstname = spFirstname;
	}


	@Column(name="SP_ID")
	public int getSpId() {
		return this.spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}


	@Column(name="SP_LASTNAME")
	public String getSpLastname() {
		return this.spLastname;
	}

	public void setSpLastname(String spLastname) {
		this.spLastname = spLastname;
	}


	@Column(name="SPID")
	public int getSpid() {
		return this.spid;
	}

	public void setSpid(int spid) {
		this.spid = spid;
	}


	@Column(name="SPMAP_ID")
	public int getSpmapId() {
		return this.spmapId;
	}

	public void setSpmapId(int spmapId) {
		this.spmapId = spmapId;
	}


	@Column(name="START_TIME")
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

}