package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayAwardsDAO;
import com.sales.module.domain.ScSalesplayAward;

@Repository
public class SalesPlayAwardsHibernateDao extends SelloCityHibernateDao<ScSalesplayAward> implements SalesPlayAwardsDAO<ScSalesplayAward>{
 	
	  public Class<ScSalesplayAward> getPersistentClass() {
	    return ScSalesplayAward.class;
	  }



	@Override
	public ScSalesplayAward findByAwardId(Integer awardId) {
		List<ScSalesplayAward> playList= findByCriteria(Restrictions.eq("awardId",awardId));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}

 }
