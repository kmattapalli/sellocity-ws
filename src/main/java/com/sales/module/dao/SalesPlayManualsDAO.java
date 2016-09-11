package com.sales.module.dao;

public interface SalesPlayManualsDAO<ScSalesplayManuals> extends SelloCityDao<ScSalesplayManuals>{
	
	public ScSalesplayManuals findByScSalesplayManuals(Long spIdValue);


  
}
