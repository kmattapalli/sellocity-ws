package com.sales.module.domain;



import java.io.Serializable;
import java.util.List;



public class ScSalesplayView implements Serializable {
	
	private static final long serialVersionUID = 100101010L;
	private Integer spid;
	private String ClientName;
	private String imagePath;
	private String customerClientContact;
	private String customerClientEmail;
	private String salesPlayName;
	private String clientLogo;
	private List<ScProductView> scSalesplayMappings;
	/**
	 * @return the spid
	 */
	public Integer getSpid() {
		return spid;
	}
	/**
	 * @param spid the spid to set
	 */
	public void setSpid(Integer spid) {
		this.spid = spid;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return ClientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * @return the customerClientContact
	 */
	public String getCustomerClientContact() {
		return customerClientContact;
	}
	/**
	 * @param customerClientContact the customerClientContact to set
	 */
	public void setCustomerClientContact(String customerClientContact) {
		this.customerClientContact = customerClientContact;
	}
	/**
	 * @return the customerClientEmail
	 */
	public String getCustomerClientEmail() {
		return customerClientEmail;
	}
	/**
	 * @param customerClientEmail the customerClientEmail to set
	 */
	public void setCustomerClientEmail(String customerClientEmail) {
		this.customerClientEmail = customerClientEmail;
	}
	/**
	 * @return the salesPlayName
	 */
	public String getSalesPlayName() {
		return salesPlayName;
	}
	/**
	 * @param salesPlayName the salesPlayName to set
	 */
	public void setSalesPlayName(String salesPlayName) {
		this.salesPlayName = salesPlayName;
	}

	/**
	 * @return the clientLogo
	 */
	public String getClientLogo() {
		return clientLogo;
	}
	/**
	 * @param clientLogo the clientLogo to set
	 */
	public void setClientLogo(String clientLogo) {
		this.clientLogo = clientLogo;
	}
	/**
	 * @return the scSalesplayMappings
	 */
	public List<ScProductView> getScSalesplayMappings() {
		return scSalesplayMappings;
	}
	/**
	 * @param scSalesplayMappings the scSalesplayMappings to set
	 */
	public void setScSalesplayMappings(List<ScProductView> scSalesplayMappings) {
		this.scSalesplayMappings = scSalesplayMappings;
	}
	
	


}