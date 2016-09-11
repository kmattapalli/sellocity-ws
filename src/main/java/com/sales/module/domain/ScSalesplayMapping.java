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
 * The persistent class for the SC_SALESPLAY_MAPPING database table.
 * 
 */
@Entity
@Table(name="SC_SALESPLAY_MAPPING")
@NamedQuery(name="ScSalesplayMapping.findAll", query="SELECT s FROM ScSalesplayMapping s")
public class ScSalesplayMapping implements Serializable {
	private static final long serialVersionUID = 1L;
	private int spmapId;
	private Timestamp dateCreated;
	private Timestamp lastupdatedDate;
	private String painPoint;
	private String painPointImage;
	private String productImage;
	private String productInStock;
	private String productInfo;
	private String productName;
	private String title;
	private ScProduct scProduct;
	private ScSalesplay scSalesplay;
	private ScStatus scStatus;
	
	/*private List<ScCompetetiveCompare> scCompetetiveCompares;
	private List<ScSalesplayAward> scSalesplayAwards;
	private List<ScSalesplayBenefit> scSalesplayBenefits;
	private List<ScSalesplayClaim> scSalesplayClaims;
	private List<ScSalesplayCommonQa> scSalesplayCommonQas;
	private List<ScSalesplayManual> scSalesplayManuals;

	private List<ScSalesplaySpec> scSalesplaySpecs;
	private List<ScSalesplayTestimonial> scSalesplayTestimonials;
	private List<ScSalesplayValue> scSalesplayValues;*/

	public ScSalesplayMapping() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SPMAP_ID")
	public int getSpmapId() {
		return this.spmapId;
	}

	public void setSpmapId(int spmapId) {
		this.spmapId = spmapId;
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


	@Column(name="PAIN_POINT")
	public String getPainPoint() {
		return this.painPoint;
	}

	public void setPainPoint(String painPoint) {
		this.painPoint = painPoint;
	}


	@Column(name="PAIN_POINT_IMAGE")
	public String getPainPointImage() {
		return this.painPointImage;
	}

	public void setPainPointImage(String painPointImage) {
		this.painPointImage = painPointImage;
	}


	@Column(name="PRODUCT_IMAGE")
	public String getProductImage() {
		return this.productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}


	@Column(name="PRODUCT_IN_STOCK")
	public String getProductInStock() {
		return this.productInStock;
	}

	public void setProductInStock(String productInStock) {
		this.productInStock = productInStock;
	}


	@Column(name="PRODUCT_INFO")
	public String getProductInfo() {
		return this.productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}


	@Column(name="PRODUCT_NAME")
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Column(name="TITLE")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//bi-directional many-to-one association to ScProduct
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	public ScProduct getScProduct() {
		return this.scProduct;
	}

	public void setScProduct(ScProduct scProduct) {
		this.scProduct = scProduct;
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


/*	//bi-directional many-to-one association to ScCompetetiveCompare
    @OneToMany(mappedBy="scCompetetiveCompare")
	public List<ScCompetetiveCompare> getScCompetetiveCompares() {
		return this.scCompetetiveCompares;
	}

	public void setScCompetetiveCompares(List<ScCompetetiveCompare> scCompetetiveCompares) {
		this.scCompetetiveCompares = scCompetetiveCompares;
	}

	public ScCompetetiveCompare addScCompetetiveCompare(ScCompetetiveCompare scCompetetiveCompare) {
		getScCompetetiveCompares().add(scCompetetiveCompare);
		scCompetetiveCompare.setScSalesplayMapping(this);

		return scCompetetiveCompare;
	}

	public ScCompetetiveCompare removeScCompetetiveCompare(ScCompetetiveCompare scCompetetiveCompare) {
		getScCompetetiveCompares().remove(scCompetetiveCompare);
		scCompetetiveCompare.setScSalesplayMapping(null);

		return scCompetetiveCompare;
	}


	//bi-directional many-to-one association to ScSalesplayAward
	@OneToMany(mappedBy="scSalesplayAward")
	public List<ScSalesplayAward> getScSalesplayAwards() {
		return this.scSalesplayAwards;
	}

	public void setScSalesplayAwards(List<ScSalesplayAward> scSalesplayAwards) {
		this.scSalesplayAwards = scSalesplayAwards;
	}

	public ScSalesplayAward addScSalesplayAward(ScSalesplayAward scSalesplayAward) {
		getScSalesplayAwards().add(scSalesplayAward);
		scSalesplayAward.setScSalesplayMapping(this);

		return scSalesplayAward;
	}

	public ScSalesplayAward removeScSalesplayAward(ScSalesplayAward scSalesplayAward) {
		getScSalesplayAwards().remove(scSalesplayAward);
		scSalesplayAward.setScSalesplayMapping(null);

		return scSalesplayAward;
	}


	//bi-directional many-to-one association to ScSalesplayBenefit
	@OneToMany(mappedBy="scSalesplayBenefit")
	public List<ScSalesplayBenefit> getScSalesplayBenefits() {
		return this.scSalesplayBenefits;
	}

	public void setScSalesplayBenefits(List<ScSalesplayBenefit> scSalesplayBenefits) {
		this.scSalesplayBenefits = scSalesplayBenefits;
	}

	public ScSalesplayBenefit addScSalesplayBenefit(ScSalesplayBenefit scSalesplayBenefit) {
		getScSalesplayBenefits().add(scSalesplayBenefit);
		scSalesplayBenefit.setScSalesplayMapping(this);

		return scSalesplayBenefit;
	}

	public ScSalesplayBenefit removeScSalesplayBenefit(ScSalesplayBenefit scSalesplayBenefit) {
		getScSalesplayBenefits().remove(scSalesplayBenefit);
		scSalesplayBenefit.setScSalesplayMapping(null);

		return scSalesplayBenefit;
	}


	//bi-directional many-to-one association to ScSalesplayClaim
	@OneToMany(mappedBy="scSalesplayClaim")
	public List<ScSalesplayClaim> getScSalesplayClaims() {
		return this.scSalesplayClaims;
	}

	public void setScSalesplayClaims(List<ScSalesplayClaim> scSalesplayClaims) {
		this.scSalesplayClaims = scSalesplayClaims;
	}

	public ScSalesplayClaim addScSalesplayClaim(ScSalesplayClaim scSalesplayClaim) {
		getScSalesplayClaims().add(scSalesplayClaim);
		scSalesplayClaim.setScSalesplayMapping(this);

		return scSalesplayClaim;
	}

	public ScSalesplayClaim removeScSalesplayClaim(ScSalesplayClaim scSalesplayClaim) {
		getScSalesplayClaims().remove(scSalesplayClaim);
		scSalesplayClaim.setScSalesplayMapping(null);

		return scSalesplayClaim;
	}


	//bi-directional many-to-one association to ScSalesplayCommonQa
	@OneToMany(mappedBy="scSalesplayCommonQa")
	public List<ScSalesplayCommonQa> getScSalesplayCommonQas() {
		return this.scSalesplayCommonQas;
	}

	public void setScSalesplayCommonQas(List<ScSalesplayCommonQa> scSalesplayCommonQas) {
		this.scSalesplayCommonQas = scSalesplayCommonQas;
	}

	public ScSalesplayCommonQa addScSalesplayCommonQa(ScSalesplayCommonQa scSalesplayCommonQa) {
		getScSalesplayCommonQas().add(scSalesplayCommonQa);
		scSalesplayCommonQa.setScSalesplayMapping(this);

		return scSalesplayCommonQa;
	}

	public ScSalesplayCommonQa removeScSalesplayCommonQa(ScSalesplayCommonQa scSalesplayCommonQa) {
		getScSalesplayCommonQas().remove(scSalesplayCommonQa);
		scSalesplayCommonQa.setScSalesplayMapping(null);

		return scSalesplayCommonQa;
	}


	//bi-directional many-to-one association to ScSalesplayManual
	@OneToMany(mappedBy="scSalesplayMapping")
	public List<ScSalesplayManual> getScSalesplayManuals() {
		return this.scSalesplayManuals;
	}

	public void setScSalesplayManuals(List<ScSalesplayManual> scSalesplayManuals) {
		this.scSalesplayManuals = scSalesplayManuals;
	}

	public ScSalesplayManual addScSalesplayManual(ScSalesplayManual scSalesplayManual) {
		getScSalesplayManuals().add(scSalesplayManual);
		scSalesplayManual.setScSalesplayMapping(this);

		return scSalesplayManual;
	}

	public ScSalesplayManual removeScSalesplayManual(ScSalesplayManual scSalesplayManual) {
		getScSalesplayManuals().remove(scSalesplayManual);
		scSalesplayManual.setScSalesplayMapping(null);

		return scSalesplayManual;
	}



	//bi-directional many-to-one association to ScSalesplaySpec
	@OneToMany(mappedBy="scSalesplaySpec")
	public List<ScSalesplaySpec> getScSalesplaySpecs() {
		return this.scSalesplaySpecs;
	}

	public void setScSalesplaySpecs(List<ScSalesplaySpec> scSalesplaySpecs) {
		this.scSalesplaySpecs = scSalesplaySpecs;
	}

	public ScSalesplaySpec addScSalesplaySpec(ScSalesplaySpec scSalesplaySpec) {
		getScSalesplaySpecs().add(scSalesplaySpec);
		scSalesplaySpec.setScSalesplayMapping(this);

		return scSalesplaySpec;
	}

	public ScSalesplaySpec removeScSalesplaySpec(ScSalesplaySpec scSalesplaySpec) {
		getScSalesplaySpecs().remove(scSalesplaySpec);
		scSalesplaySpec.setScSalesplayMapping(null);

		return scSalesplaySpec;
	}


	//bi-directional many-to-one association to ScSalesplayTestimonial
	@OneToMany(mappedBy="scSalesplayTestimonial")
	public List<ScSalesplayTestimonial> getScSalesplayTestimonials() {
		return this.scSalesplayTestimonials;
	}

	public void setScSalesplayTestimonials(List<ScSalesplayTestimonial> scSalesplayTestimonials) {
		this.scSalesplayTestimonials = scSalesplayTestimonials;
	}

	public ScSalesplayTestimonial addScSalesplayTestimonial(ScSalesplayTestimonial scSalesplayTestimonial) {
		getScSalesplayTestimonials().add(scSalesplayTestimonial);
		scSalesplayTestimonial.setScSalesplayMapping(this);

		return scSalesplayTestimonial;
	}

	public ScSalesplayTestimonial removeScSalesplayTestimonial(ScSalesplayTestimonial scSalesplayTestimonial) {
		getScSalesplayTestimonials().remove(scSalesplayTestimonial);
		scSalesplayTestimonial.setScSalesplayMapping(null);

		return scSalesplayTestimonial;
	}


	//bi-directional many-to-one association to ScSalesplayValue
	@OneToMany(mappedBy="scSalesplayValue")
	public List<ScSalesplayValue> getScSalesplayValues() {
		return this.scSalesplayValues;
	}

	public void setScSalesplayValues(List<ScSalesplayValue> scSalesplayValues) {
		this.scSalesplayValues = scSalesplayValues;
	}

	public ScSalesplayValue addScSalesplayValue(ScSalesplayValue scSalesplayValue) {
		getScSalesplayValues().add(scSalesplayValue);
		scSalesplayValue.setScSalesplayMapping(this);

		return scSalesplayValue;
	}

	public ScSalesplayValue removeScSalesplayValue(ScSalesplayValue scSalesplayValue) {
		getScSalesplayValues().remove(scSalesplayValue);
		scSalesplayValue.setScSalesplayMapping(null);

		return scSalesplayValue;
	}*/

}