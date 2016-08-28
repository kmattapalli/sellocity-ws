package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayTestimonialsDAO;
import com.sales.module.domain.SalesPlayTestimonials;

@Repository
public class SalesPlayTestimonialsHibernateDao extends SelloCityHibernateDao<SalesPlayTestimonials> implements SalesPlayTestimonialsDAO<SalesPlayTestimonials>{
 	
	  public Class<SalesPlayTestimonials> getPersistentClass() {
	    return SalesPlayTestimonials.class;
	  }



	@Override
	public SalesPlayTestimonials findByTestimonialId(Integer testimonialId) {
		List<SalesPlayTestimonials> playList= findByCriteria(Restrictions.eq("testimonialId",testimonialId));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}
}
