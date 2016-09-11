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


/**
 * The persistent class for the SC_PRODUCTS database table.
 * 
 */
@Entity
@Table(name="SC_PRODUCTS")
@NamedQuery(name="ScProduct.findAll", query="SELECT s FROM ScProduct s")
public class ScProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productId;
	private Timestamp dateCreated;
	private String imageUrl;
	private String info;
	private Timestamp lastupdatedDate;
	private String name;
	private String url;
	private String value;
	private ScCustomer scCustomer;
	private ScUser scUser1;
	private ScUser scUser2;
	private List<ScSalesplayMapping> scSalesplayMappings;

	public ScProduct() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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


	@Column(name="INFO")
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
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


	@Column(name="URL")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	@Column(name="[VALUE]")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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
	@JoinColumn(name="LASTUPDATED_BY")
	public ScUser getScUser2() {
		return this.scUser2;
	}

	public void setScUser2(ScUser scUser2) {
		this.scUser2 = scUser2;
	}


	//bi-directional many-to-one association to ScSalesplayMapping
	@OneToMany(mappedBy="scProduct")
	public List<ScSalesplayMapping> getScSalesplayMappings() {
		return this.scSalesplayMappings;
	}

	public void setScSalesplayMappings(List<ScSalesplayMapping> scSalesplayMappings) {
		this.scSalesplayMappings = scSalesplayMappings;
	}

	public ScSalesplayMapping addScSalesplayMapping(ScSalesplayMapping scSalesplayMapping) {
		getScSalesplayMappings().add(scSalesplayMapping);
		scSalesplayMapping.setScProduct(this);

		return scSalesplayMapping;
	}

	public ScSalesplayMapping removeScSalesplayMapping(ScSalesplayMapping scSalesplayMapping) {
		getScSalesplayMappings().remove(scSalesplayMapping);
		scSalesplayMapping.setScProduct(null);

		return scSalesplayMapping;
	}

}