package com.sales.module.dao;

import java.util.List;

public interface CustomerDAO<Customer>  extends SelloCityDao<Customer> {
	
	public List<Customer> findByName(String name);


  
}
