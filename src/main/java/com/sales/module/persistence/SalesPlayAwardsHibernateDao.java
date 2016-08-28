package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayAwardsDAO;
import com.sales.module.domain.SalesPlayAwards;

@Repository
public class SalesPlayAwardsHibernateDao extends SelloCityHibernateDao<SalesPlayAwards> implements SalesPlayAwardsDAO<SalesPlayAwards>{
 	
	  public Class<SalesPlayAwards> getPersistentClass() {
	    return SalesPlayAwards.class;
	  }



	@Override
	public SalesPlayAwards findByAwardId(Integer awardId) {
		List<SalesPlayAwards> playList= findByCriteria(Restrictions.eq("awardId",awardId));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}

 }
