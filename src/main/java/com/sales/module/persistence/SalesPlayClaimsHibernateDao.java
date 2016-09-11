package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayClaimsDAO;
import com.sales.module.domain.ScSalesplayClaim;

@Repository
public class SalesPlayClaimsHibernateDao extends SelloCityHibernateDao<ScSalesplayClaim> implements SalesPlayClaimsDAO<ScSalesplayClaim>{
 	
	  public Class<ScSalesplayClaim> getPersistentClass() {
	    return ScSalesplayClaim.class;
	  }

	@Override
	public ScSalesplayClaim findBySalesPlayClaimsId(Integer claimId) {
		List<ScSalesplayClaim> playList= findByCriteria(Restrictions.eq("claimId",claimId));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}





 }
