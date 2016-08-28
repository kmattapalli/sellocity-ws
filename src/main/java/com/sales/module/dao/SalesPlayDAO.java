package com.sales.module.dao;

public interface SalesPlayDAO<SalesPlay> extends SelloCityDao<SalesPlay>{
	
	public SalesPlay findBySalesPlayId(Integer spIdValue);

	public SalesPlay findBySalesPlayIdWithMapping(Integer spIdValue);

  
}
