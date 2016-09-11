package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.CustomerDAO;
import com.sales.module.domain.ScCustomer;

@Repository
public class CustomerHibernateDao extends SelloCityHibernateDao<ScCustomer> implements CustomerDAO<ScCustomer>{
 
	public List<ScCustomer> findByName(String name){
		return findByCriteria(Restrictions.eq("name",name));
	}
  public Class<ScCustomer> getPersistentClass() {
    return ScCustomer.class;
  }

 
 
}
