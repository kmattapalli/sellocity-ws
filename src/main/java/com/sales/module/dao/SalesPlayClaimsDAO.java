package com.sales.module.dao;

public interface SalesPlayClaimsDAO<SalesPlayClaims> extends SelloCityDao<SalesPlayClaims>{
	
	public SalesPlayClaims findBySalesPlayClaimsId(Integer claimId);


  
}
