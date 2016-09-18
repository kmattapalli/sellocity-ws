package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayBenefitDAO;
import com.sales.module.domain.ScSalesplayBenefit;

@Repository
public class SalesPlayBenefitsHibernateDao extends SelloCityHibernateDao<ScSalesplayBenefit> implements SalesPlayBenefitDAO<ScSalesplayBenefit>{
 

	
	
  public Class<ScSalesplayBenefit> getPersistentClass() {
    return ScSalesplayBenefit.class;
  }


	@Override
	public ScSalesplayBenefit findByScSalesplayBenefits(Long spIdValue) {
		List<ScSalesplayBenefit> playList= findByCriteria(Restrictions.eq("benefitId",spIdValue));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
 	}




}
