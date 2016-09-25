package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayManualsDAO;
import com.sales.module.domain.ScSalesplayManual;

@Repository
public class SalesPlayManualsHibernateDao extends SelloCityHibernateDao<ScSalesplayManual> implements SalesPlayManualsDAO<ScSalesplayManual>{
 

	
	
  public Class<ScSalesplayManual> getPersistentClass() {
    return ScSalesplayManual.class;
  }


	@Override
	public ScSalesplayManual findByScSalesplayManuals(Integer spIdValue) {
		List<ScSalesplayManual> playList= findByCriteria(Restrictions.eq("manualId",spIdValue));
		if(playList != null && playList.size() >0){
			return playList.get(0);
		}
		return null;
 	}
}
