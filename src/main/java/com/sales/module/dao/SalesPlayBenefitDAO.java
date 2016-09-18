package com.sales.module.dao;

public interface SalesPlayBenefitDAO<ScSalesplayBenefit> extends SelloCityDao<ScSalesplayBenefit>{
	
	public ScSalesplayBenefit findByScSalesplayBenefits(Long mapId);


  
}
