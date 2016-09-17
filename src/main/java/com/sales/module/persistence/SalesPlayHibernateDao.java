package com.sales.module.persistence;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayDAO;
import com.sales.module.domain.ScSalesplay;

@Repository
public class SalesPlayHibernateDao extends SelloCityHibernateDao<ScSalesplay> implements SalesPlayDAO<ScSalesplay>{
 
	public ScSalesplay findByScSalesplayId(Integer spIdValue){
		List<ScSalesplay> playList= findByCriteria(Restrictions.eq("spid",spIdValue));
		
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}
	public ScSalesplay findByScSalesplayIdWithMapping(Integer spIdValue){
		 ScSalesplay salesPlayObj=new ScSalesplay();;
		 Criteria crit = getSession().createCriteria(getPersistentClass());
		 crit.add(Restrictions.eq("spid",spIdValue));
		 List<ScSalesplay> playList= (List<ScSalesplay>)crit.list();
		 if(playList != null && playList.size() >=0){
			salesPlayObj = playList.get(0);
		 }
		 Hibernate.initialize(salesPlayObj.getScSalesplayMappings());
		return salesPlayObj;
	}

	  public Class<ScSalesplay> getPersistentClass() {
	    return ScSalesplay.class;
	  }


 
 
}
