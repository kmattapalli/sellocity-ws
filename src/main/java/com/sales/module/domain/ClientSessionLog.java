package com.sales.module.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.joda.time.DateTime;



/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author vijay
 *
 */
@Entity
@Table(name="Client_Session_Log",uniqueConstraints = @UniqueConstraint(columnNames = "SessionId"))
public class ClientSessionLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;

	@Id
	@Column(name="SessionId")
	private Integer sessionId;

	@Column(name="Client_ID",length=20)
	private String clientId;
	
	@Column(name="Products_Visited")
	private String productsVisited;
	
	@Column(name="Interaction_Type")
	private String InteractionType;
	
	@Column(name="Start_Time")
	private DateTime startTime;
	@Column(name="End_Time")
	private DateTime endTime;

	
	@ManyToOne
	@JoinColumn(name="SPID")
	private SalesPlay spId;


	/**
	 * @return the sessionId
	 */
	public Integer getSessionId() {
		return sessionId;
	}


	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}


	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}


	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	/**
	 * @return the productsVisited
	 */
	public String getProductsVisited() {
		return productsVisited;
	}


	/**
	 * @param productsVisited the productsVisited to set
	 */
	public void setProductsVisited(String productsVisited) {
		this.productsVisited = productsVisited;
	}


	/**
	 * @return the interactionType
	 */
	public String getInteractionType() {
		return InteractionType;
	}


	/**
	 * @param interactionType the interactionType to set
	 */
	public void setInteractionType(String interactionType) {
		InteractionType = interactionType;
	}


	/**
	 * @return the startTime
	 */
	public DateTime getStartTime() {
		return startTime;
	}


	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}


	/**
	 * @return the endTime
	 */
	public DateTime getEndTime() {
		return endTime;
	}


	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}


	/**
	 * @return the spId
	 */
	public SalesPlay getSpId() {
		return spId;
	}


	/**
	 * @param spId the spId to set
	 */
	public void setSpId(SalesPlay spId) {
		this.spId = spId;
	}
	
	

}
