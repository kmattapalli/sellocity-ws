package com.sales.module.dao;

import java.util.List;

public interface CustomerDAO<ScCustomer>  extends SelloCityDao<ScCustomer> {
	
	public List<ScCustomer> findByName(String name);


  
}
