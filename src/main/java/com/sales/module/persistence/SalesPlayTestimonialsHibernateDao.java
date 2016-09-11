package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayTestimonialsDAO;
import com.sales.module.domain.ScSalesplayTestimonial;

@Repository
public class SalesPlayTestimonialsHibernateDao extends SelloCityHibernateDao<ScSalesplayTestimonial> implements SalesPlayTestimonialsDAO<ScSalesplayTestimonial>{
 	
	  public Class<ScSalesplayTestimonial> getPersistentClass() {
	    return ScSalesplayTestimonial.class;
	  }



	@Override
	public ScSalesplayTestimonial findByTestimonialId(Integer testimonialId) {
		List<ScSalesplayTestimonial> playList= findByCriteria(Restrictions.eq("testimonialId",testimonialId));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}
}
