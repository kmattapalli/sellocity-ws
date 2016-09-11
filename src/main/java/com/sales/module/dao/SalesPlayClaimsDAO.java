package com.sales.module.dao;

public interface SalesPlayClaimsDAO<ScSalesplayClaims> extends SelloCityDao<ScSalesplayClaims>{
	
	public ScSalesplayClaims findBySalesPlayClaimsId(Integer claimId);


  
}
