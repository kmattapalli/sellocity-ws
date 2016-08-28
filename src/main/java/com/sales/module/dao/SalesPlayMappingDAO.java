package com.sales.module.dao;

public interface SalesPlayMappingDAO<SalesPlayMapping>  extends SelloCityDao<SalesPlayMapping>{

	public SalesPlayMapping findBySalesPlayMappingId(Long spIdValue);
  
}
