package com.sales.module.dao;

public interface SalesPlaySpecsDAO<ScSalesplaySpecs> extends SelloCityDao<ScSalesplaySpecs>{
	
	public ScSalesplaySpecs findByScSalesplaySpecId(Integer specId);


  
}
