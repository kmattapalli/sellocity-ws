package com.sales.module.dao;

public interface SalesPlayDAO<ScSalesplay> extends SelloCityDao<ScSalesplay>{
	
	public ScSalesplay findByScSalesplayId(Integer spIdValue);

	public ScSalesplay findByScSalesplayIdWithMapping(Integer spIdValue);

  
}
