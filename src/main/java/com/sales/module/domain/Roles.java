package com.sales.module.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author vijay
 *
 */
@Entity
@Table(name="SC_ROLES")
public class Roles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990354759751443525L;


	@Id
	@Column(name="RLE_ID",unique = true, nullable = false,length = 20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
	
	
	@Column(name="RNAME",length = 10)
	private String name;
	
	@Column(name="RDESCRIPTION",length = 100)
	private String description;

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	




}
