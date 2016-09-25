package com.sales.module.dao;

import com.sales.module.domain.ScSalesplayManual;

public interface SalesPlayManualsDAO<ScSalesplayManuals> extends SelloCityDao<ScSalesplayManuals>{
	


	ScSalesplayManual findByScSalesplayManuals(Integer spIdValue);


  
}
