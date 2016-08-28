package com.sales.module.dao;

public interface SalesPlayAwardsDAO<SalesPlayAwards> extends SelloCityDao<SalesPlayAwards>{
	
	public SalesPlayAwards findByAwardId(Integer awardId);


  
}
