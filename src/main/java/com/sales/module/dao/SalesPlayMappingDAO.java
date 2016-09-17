package com.sales.module.dao;

import java.util.List;

public interface SalesPlayMappingDAO<ScSalesplayMapping>  extends SelloCityDao<ScSalesplayMapping>{

	public ScSalesplayMapping findByScSalesplayMappingId(Integer spIdValue);
	public ScSalesplayMapping findByScSalesplayMappingWithBenefits(Integer spIdValue);
	public List<ScSalesplayMapping> findByScSalesplayMappingList(Integer spIdValue) ;
  
}
