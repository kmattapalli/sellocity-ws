package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayValuesDAO;
import com.sales.module.domain.ScSalesplayValue;

@Repository
public class SalesPlayValuesHibernateDao extends SelloCityHibernateDao<ScSalesplayValue> implements SalesPlayValuesDAO<ScSalesplayValue>{
 	
	  public Class<ScSalesplayValue> getPersistentClass() {
	    return ScSalesplayValue.class;
	  }

//
//
//	@Override
//	public ScSalesplayValue findByTestimonialId(Integer testimonialId) {
//		List<ScSalesplayValue> playList= findByCriteria(Restrictions.eq("testimonialId",testimonialId));
//		if(playList != null && playList.size() >=0){
//			return playList.get(0);
//		}
//		return null;
//	}
}
