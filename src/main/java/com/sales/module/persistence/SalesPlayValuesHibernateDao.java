package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayValuesDAO;
import com.sales.module.domain.SalesPlayValues;

@Repository
public class SalesPlayValuesHibernateDao extends SelloCityHibernateDao<SalesPlayValues> implements SalesPlayValuesDAO<SalesPlayValues>{
 	
	  public Class<SalesPlayValues> getPersistentClass() {
	    return SalesPlayValues.class;
	  }

//
//
//	@Override
//	public SalesPlayValues findByTestimonialId(Integer testimonialId) {
//		List<SalesPlayValues> playList= findByCriteria(Restrictions.eq("testimonialId",testimonialId));
//		if(playList != null && playList.size() >=0){
//			return playList.get(0);
//		}
//		return null;
//	}
}
