package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayMappingDAO;
import com.sales.module.domain.ScSalesplayMapping;

@Repository
public class SalesPlayMappingHibernateDao extends SelloCityHibernateDao<ScSalesplayMapping> implements SalesPlayMappingDAO<ScSalesplayMapping>{
 

	
	
  public Class<ScSalesplayMapping> getPersistentClass() {
    return ScSalesplayMapping.class;
  }

	@Override
	public ScSalesplayMapping findByScSalesplayMappingId(Long spIdValue) {
		List<ScSalesplayMapping> playList= findByCriteria(Restrictions.eq("spmapId",spIdValue));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}
 	}
