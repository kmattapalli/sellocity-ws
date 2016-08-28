package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayClaimsDAO;
import com.sales.module.domain.SalesPlayClaims;

@Repository
public class SalesPlayClaimsHibernateDao extends SelloCityHibernateDao<SalesPlayClaims> implements SalesPlayClaimsDAO<SalesPlayClaims>{
 	
	  public Class<SalesPlayClaims> getPersistentClass() {
	    return SalesPlayClaims.class;
	  }

	@Override
	public SalesPlayClaims findBySalesPlayClaimsId(Integer claimId) {
		List<SalesPlayClaims> playList= findByCriteria(Restrictions.eq("claimId",claimId));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}


 }
