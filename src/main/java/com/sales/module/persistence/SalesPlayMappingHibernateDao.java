package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayMappingDAO;
import com.sales.module.domain.SalesPlayMapping;

@Repository
public class SalesPlayMappingHibernateDao extends SelloCityHibernateDao<SalesPlayMapping> implements SalesPlayMappingDAO<SalesPlayMapping>{
 

	
	
  public Class<SalesPlayMapping> getPersistentClass() {
    return SalesPlayMapping.class;
  }

	@Override
	public SalesPlayMapping findBySalesPlayMappingId(Long spIdValue) {
		List<SalesPlayMapping> playList= findByCriteria(Restrictions.eq("salesPlayKey",spIdValue));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}
 	}
