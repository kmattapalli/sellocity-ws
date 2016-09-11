package com.sales.module.dao;

public interface SalesPlayAwardsDAO<ScSalesplayAwards> extends SelloCityDao<ScSalesplayAwards>{
	
	public ScSalesplayAwards findByAwardId(Integer awardId);


  
}
