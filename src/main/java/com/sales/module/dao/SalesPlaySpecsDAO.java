package com.sales.module.dao;

public interface SalesPlaySpecsDAO<SalesPlaySpecs> extends SelloCityDao<SalesPlaySpecs>{
	
	public SalesPlaySpecs findBySalesPlaySpecId(Long specId);


  
}
