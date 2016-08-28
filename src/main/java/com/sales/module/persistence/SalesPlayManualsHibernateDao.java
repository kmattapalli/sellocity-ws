package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayManualsDAO;
import com.sales.module.domain.SalesPlayManuals;

@Repository
public class SalesPlayManualsHibernateDao extends SelloCityHibernateDao<SalesPlayManuals> implements SalesPlayManualsDAO<SalesPlayManuals>{
 

	
	
  public Class<SalesPlayManuals> getPersistentClass() {
    return SalesPlayManuals.class;
  }


	@Override
	public SalesPlayManuals findBySalesPlayManuals(Long spIdValue) {
		List<SalesPlayManuals> playList= findByCriteria(Restrictions.eq("manualId",spIdValue));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
 	}
}
