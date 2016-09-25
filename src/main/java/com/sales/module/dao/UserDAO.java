package com.sales.module.dao;

public interface UserDAO<ScUser> extends SelloCityDao<ScUser>{

	public ScUser findBySuid(Integer suid);

  
}
