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

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SC_STATUS database table.
 * 
 */
@Entity
@Table(name="SC_STATUS")
@NamedQuery(name="ScStatus.findAll", query="SELECT s FROM ScStatus s")
public class ScStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer statusId;
	private Integer createdBy;
	private String Name;
	private Timestamp dateCreated;
	private Integer lastupdatedBy;
	private Timestamp lastupdatedDate;
	private String sdescription;
	private List<ScClient> scClients;
	private List<ScCompetetiveCompare> scCompetetiveCompares;
	private List<ScCustomer> scCustomers;
	private List<ScSalesplay> scSalesplays;
	private List<ScSalesplayAward> scSalesplayAwards;
	private List<ScSalesplayBenefit> scSalesplayBenefits;
	private List<ScSalesplayClaim> scSalesplayClaims;
	private List<ScSalesplayCommonQa> scSalesplayCommonQas;
	private List<ScSalesplayManual> scSalesplayManuals;
	private List<ScSalesplayMapping> scSalesplayMappings;
	private List<ScSalesplayResponse> scSalesplayResponses;
	private List<ScSalesplaySpec> scSalesplaySpecs;
	private List<ScSalesplayTestimonial> scSalesplayTestimonials;
	private List<ScSalesplayValue> scSalesplayValues;
	private List<ScUser> scUsers;

	public ScStatus() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STATUS_ID")
	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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


	@Column(name="SDESCRIPTION")
	public String getSdescription() {
		return this.sdescription;
	}

	public void setSdescription(String sdescription) {
		this.sdescription = sdescription;
	}


	//bi-directional many-to-one association to ScClient
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScClient> getScClients() {
		return this.scClients;
	}

	public void setScClients(List<ScClient> scClients) {
		this.scClients = scClients;
	}

	public ScClient addScClient(ScClient scClient) {
		getScClients().add(scClient);
		scClient.setScStatus(this);

		return scClient;
	}

	public ScClient removeScClient(ScClient scClient) {
		getScClients().remove(scClient);
		scClient.setScStatus(null);

		return scClient;
	}


	//bi-directional many-to-one association to ScCompetetiveCompare
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScCompetetiveCompare> getScCompetetiveCompares() {
		return this.scCompetetiveCompares;
	}

	public void setScCompetetiveCompares(List<ScCompetetiveCompare> scCompetetiveCompares) {
		this.scCompetetiveCompares = scCompetetiveCompares;
	}

	public ScCompetetiveCompare addScCompetetiveCompare(ScCompetetiveCompare scCompetetiveCompare) {
		getScCompetetiveCompares().add(scCompetetiveCompare);
		scCompetetiveCompare.setScStatus(this);

		return scCompetetiveCompare;
	}

	public ScCompetetiveCompare removeScCompetetiveCompare(ScCompetetiveCompare scCompetetiveCompare) {
		getScCompetetiveCompares().remove(scCompetetiveCompare);
		scCompetetiveCompare.setScStatus(null);

		return scCompetetiveCompare;
	}


	//bi-directional many-to-one association to ScCustomer
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScCustomer> getScCustomers() {
		return this.scCustomers;
	}

	public void setScCustomers(List<ScCustomer> scCustomers) {
		this.scCustomers = scCustomers;
	}

	public ScCustomer addScCustomer(ScCustomer scCustomer) {
		getScCustomers().add(scCustomer);
		scCustomer.setScStatus(this);

		return scCustomer;
	}

	public ScCustomer removeScCustomer(ScCustomer scCustomer) {
		getScCustomers().remove(scCustomer);
		scCustomer.setScStatus(null);

		return scCustomer;
	}


	//bi-directional many-to-one association to ScSalesplay
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplay> getScSalesplays() {
		return this.scSalesplays;
	}

	public void setScSalesplays(List<ScSalesplay> scSalesplays) {
		this.scSalesplays = scSalesplays;
	}

	public ScSalesplay addScSalesplay(ScSalesplay scSalesplay) {
		getScSalesplays().add(scSalesplay);
		scSalesplay.setScStatus(this);

		return scSalesplay;
	}

	public ScSalesplay removeScSalesplay(ScSalesplay scSalesplay) {
		getScSalesplays().remove(scSalesplay);
		scSalesplay.setScStatus(null);

		return scSalesplay;
	}


	//bi-directional many-to-one association to ScSalesplayAward
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplayAward> getScSalesplayAwards() {
		return this.scSalesplayAwards;
	}

	public void setScSalesplayAwards(List<ScSalesplayAward> scSalesplayAwards) {
		this.scSalesplayAwards = scSalesplayAwards;
	}

	public ScSalesplayAward addScSalesplayAward(ScSalesplayAward scSalesplayAward) {
		getScSalesplayAwards().add(scSalesplayAward);
		scSalesplayAward.setScStatus(this);

		return scSalesplayAward;
	}

	public ScSalesplayAward removeScSalesplayAward(ScSalesplayAward scSalesplayAward) {
		getScSalesplayAwards().remove(scSalesplayAward);
		scSalesplayAward.setScStatus(null);

		return scSalesplayAward;
	}


	//bi-directional many-to-one association to ScSalesplayBenefit
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplayBenefit> getScSalesplayBenefits() {
		return this.scSalesplayBenefits;
	}

	public void setScSalesplayBenefits(List<ScSalesplayBenefit> scSalesplayBenefits) {
		this.scSalesplayBenefits = scSalesplayBenefits;
	}

	public ScSalesplayBenefit addScSalesplayBenefit(ScSalesplayBenefit scSalesplayBenefit) {
		getScSalesplayBenefits().add(scSalesplayBenefit);
		scSalesplayBenefit.setScStatus(this);

		return scSalesplayBenefit;
	}

	public ScSalesplayBenefit removeScSalesplayBenefit(ScSalesplayBenefit scSalesplayBenefit) {
		getScSalesplayBenefits().remove(scSalesplayBenefit);
		scSalesplayBenefit.setScStatus(null);

		return scSalesplayBenefit;
	}


	//bi-directional many-to-one assoc
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplayClaim> getScSalesplayClaims() {
		return this.scSalesplayClaims;
	}

	public void setScSalesplayClaims(List<ScSalesplayClaim> scSalesplayClaims) {
		this.scSalesplayClaims = scSalesplayClaims;
	}

	public ScSalesplayClaim addScSalesplayClaim(ScSalesplayClaim scSalesplayClaim) {
		getScSalesplayClaims().add(scSalesplayClaim);
		scSalesplayClaim.setScStatus(this);

		return scSalesplayClaim;
	}

	public ScSalesplayClaim removeScSalesplayClaim(ScSalesplayClaim scSalesplayClaim) {
		getScSalesplayClaims().remove(scSalesplayClaim);
		scSalesplayClaim.setScStatus(null);

		return scSalesplayClaim;
	}


	//bi-directional many-to-one association to ScSalesplayCommonQa
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplayCommonQa> getScSalesplayCommonQas() {
		return this.scSalesplayCommonQas;
	}

	public void setScSalesplayCommonQas(List<ScSalesplayCommonQa> scSalesplayCommonQas) {
		this.scSalesplayCommonQas = scSalesplayCommonQas;
	}

	public ScSalesplayCommonQa addScSalesplayCommonQa(ScSalesplayCommonQa scSalesplayCommonQa) {
		getScSalesplayCommonQas().add(scSalesplayCommonQa);
		scSalesplayCommonQa.setScStatus(this);

		return scSalesplayCommonQa;
	}

	public ScSalesplayCommonQa removeScSalesplayCommonQa(ScSalesplayCommonQa scSalesplayCommonQa) {
		getScSalesplayCommonQas().remove(scSalesplayCommonQa);
		scSalesplayCommonQa.setScStatus(null);

		return scSalesplayCommonQa;
	}


	//bi-directional many-to-one association to ScSalesplayManual
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplayManual> getScSalesplayManuals() {
		return this.scSalesplayManuals;
	}

	public void setScSalesplayManuals(List<ScSalesplayManual> scSalesplayManuals) {
		this.scSalesplayManuals = scSalesplayManuals;
	}

	public ScSalesplayManual addScSalesplayManual(ScSalesplayManual scSalesplayManual) {
		getScSalesplayManuals().add(scSalesplayManual);
		scSalesplayManual.setScStatus(this);

		return scSalesplayManual;
	}

	public ScSalesplayManual removeScSalesplayManual(ScSalesplayManual scSalesplayManual) {
		getScSalesplayManuals().remove(scSalesplayManual);
		scSalesplayManual.setScStatus(null);

		return scSalesplayManual;
	}


	//bi-directional many-to-one association to ScSalesplayMapping
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplayMapping> getScSalesplayMappings() {
		return this.scSalesplayMappings;
	}

	public void setScSalesplayMappings(List<ScSalesplayMapping> scSalesplayMappings) {
		this.scSalesplayMappings = scSalesplayMappings;
	}

	public ScSalesplayMapping addScSalesplayMapping(ScSalesplayMapping scSalesplayMapping) {
		getScSalesplayMappings().add(scSalesplayMapping);
		scSalesplayMapping.setScStatus(this);

		return scSalesplayMapping;
	}

	public ScSalesplayMapping removeScSalesplayMapping(ScSalesplayMapping scSalesplayMapping) {
		getScSalesplayMappings().remove(scSalesplayMapping);
		scSalesplayMapping.setScStatus(null);

		return scSalesplayMapping;
	}


	//bi-directional many-to-one association to ScSalesplayResponse
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplayResponse> getScSalesplayResponses() {
		return this.scSalesplayResponses;
	}

	public void setScSalesplayResponses(List<ScSalesplayResponse> scSalesplayResponses) {
		this.scSalesplayResponses = scSalesplayResponses;
	}

	public ScSalesplayResponse addScSalesplayRespons(ScSalesplayResponse scSalesplayRespons) {
		getScSalesplayResponses().add(scSalesplayRespons);
		scSalesplayRespons.setScStatus(this);

		return scSalesplayRespons;
	}

	public ScSalesplayResponse removeScSalesplayRespons(ScSalesplayResponse scSalesplayRespons) {
		getScSalesplayResponses().remove(scSalesplayRespons);
		scSalesplayRespons.setScStatus(null);

		return scSalesplayRespons;
	}


	//bi-directional many-to-one association to ScSalesplaySpec
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplaySpec> getScSalesplaySpecs() {
		return this.scSalesplaySpecs;
	}

	public void setScSalesplaySpecs(List<ScSalesplaySpec> scSalesplaySpecs) {
		this.scSalesplaySpecs = scSalesplaySpecs;
	}

	public ScSalesplaySpec addScSalesplaySpec(ScSalesplaySpec scSalesplaySpec) {
		getScSalesplaySpecs().add(scSalesplaySpec);
		scSalesplaySpec.setScStatus(this);

		return scSalesplaySpec;
	}

	public ScSalesplaySpec removeScSalesplaySpec(ScSalesplaySpec scSalesplaySpec) {
		getScSalesplaySpecs().remove(scSalesplaySpec);
		scSalesplaySpec.setScStatus(null);

		return scSalesplaySpec;
	}


	//bi-directional many-to-one association to ScSalesplayTestimonial
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplayTestimonial> getScSalesplayTestimonials() {
		return this.scSalesplayTestimonials;
	}

	public void setScSalesplayTestimonials(List<ScSalesplayTestimonial> scSalesplayTestimonials) {
		this.scSalesplayTestimonials = scSalesplayTestimonials;
	}

	public ScSalesplayTestimonial addScSalesplayTestimonial(ScSalesplayTestimonial scSalesplayTestimonial) {
		getScSalesplayTestimonials().add(scSalesplayTestimonial);
		scSalesplayTestimonial.setScStatus(this);

		return scSalesplayTestimonial;
	}

	public ScSalesplayTestimonial removeScSalesplayTestimonial(ScSalesplayTestimonial scSalesplayTestimonial) {
		getScSalesplayTestimonials().remove(scSalesplayTestimonial);
		scSalesplayTestimonial.setScStatus(null);

		return scSalesplayTestimonial;
	}


	//bi-directional many-to-one association to ScSalesplayValue
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScSalesplayValue> getScSalesplayValues() {
		return this.scSalesplayValues;
	}

	public void setScSalesplayValues(List<ScSalesplayValue> scSalesplayValues) {
		this.scSalesplayValues = scSalesplayValues;
	}

	public ScSalesplayValue addScSalesplayValue(ScSalesplayValue scSalesplayValue) {
		getScSalesplayValues().add(scSalesplayValue);
		scSalesplayValue.setScStatus(this);

		return scSalesplayValue;
	}

	public ScSalesplayValue removeScSalesplayValue(ScSalesplayValue scSalesplayValue) {
		getScSalesplayValues().remove(scSalesplayValue);
		scSalesplayValue.setScStatus(null);

		return scSalesplayValue;
	}


	//bi-directional many-to-one association to ScUser
	@OneToMany(mappedBy="scStatus")
	@JsonIgnore
	public List<ScUser> getScUsers() {
		return this.scUsers;
	}

	public void setScUsers(List<ScUser> scUsers) {
		this.scUsers = scUsers;
	}

	public ScUser addScUser(ScUser scUser) {
		getScUsers().add(scUser);
		scUser.setScStatus(this);

		return scUser;
	}

	public ScUser removeScUser(ScUser scUser) {
		getScUsers().remove(scUser);
		scUser.setScStatus(null);

		return scUser;
	}


	/**
	 * @return the name
	 */
	@Column(name="NAME")
	public String getName() {
		return Name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

}