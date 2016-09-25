package com.sales.module.dao;

public interface StatusDAO<ScStatus> extends SelloCityDao<ScStatus>{
	public ScStatus findScStatusByName(String name);

  
}
