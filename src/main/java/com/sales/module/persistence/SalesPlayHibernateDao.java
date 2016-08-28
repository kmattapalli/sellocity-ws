package com.sales.module.persistence;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayDAO;
import com.sales.module.domain.SalesPlay;

@Repository
public class SalesPlayHibernateDao extends SelloCityHibernateDao<SalesPlay> implements SalesPlayDAO<SalesPlay>{
 
	public SalesPlay findBySalesPlayId(Integer spIdValue){
		List<SalesPlay> playList= findByCriteria(Restrictions.eq("spId",spIdValue));
		
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}
	public SalesPlay findBySalesPlayIdWithMapping(Integer spIdValue){
		 SalesPlay salesPlayObj=new SalesPlay();;
		 Criteria crit = getSession().createCriteria(getPersistentClass());
		 crit.add(Restrictions.eq("spId",spIdValue));
		 List<SalesPlay> playList= (List<SalesPlay>)crit.list();
		 if(playList != null && playList.size() >=0){
			salesPlayObj = playList.get(0);
		 }
		 Hibernate.initialize(salesPlayObj.getSalesPlayMapping());
		return salesPlayObj;
	}

	  public Class<SalesPlay> getPersistentClass() {
	    return SalesPlay.class;
	  }

 
 
}
