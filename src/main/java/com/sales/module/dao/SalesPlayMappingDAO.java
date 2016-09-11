package com.sales.module.dao;

public interface SalesPlayMappingDAO<ScSalesplayMapping>  extends SelloCityDao<ScSalesplayMapping>{

	public ScSalesplayMapping findByScSalesplayMappingId(Long spIdValue);
  
}
