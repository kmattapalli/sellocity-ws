package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlaySpecsDAO;
import com.sales.module.domain.SalesPlaySpecs;

@Repository
public class SalesPlaySpecsHibernateDao extends SelloCityHibernateDao<SalesPlaySpecs> implements SalesPlaySpecsDAO<SalesPlaySpecs>{
 	
	  public Class<SalesPlaySpecs> getPersistentClass() {
	    return SalesPlaySpecs.class;
	  }

	@Override
	public SalesPlaySpecs findBySalesPlaySpecId(Long specId) {
		List<SalesPlaySpecs> playList= findByCriteria(Restrictions.eq("specId",specId));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}

 }
