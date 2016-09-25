package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlaySpecsDAO;
import com.sales.module.domain.ScSalesplaySpec;

@Repository
public class SalesPlaySpecsHibernateDao extends SelloCityHibernateDao<ScSalesplaySpec> implements SalesPlaySpecsDAO<ScSalesplaySpec>{
 	
	  public Class<ScSalesplaySpec> getPersistentClass() {
	    return ScSalesplaySpec.class;
	  }

	@Override
	public ScSalesplaySpec findByScSalesplaySpecId(Integer specId) {
		List<ScSalesplaySpec> playList= findByCriteria(Restrictions.eq("specId",specId));
		if(playList != null && playList.size() >0){
			return playList.get(0);
		}
		return null;
	}

 }
