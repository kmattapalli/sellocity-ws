package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.CustomerDAO;
import com.sales.module.domain.Customer;

@Repository
public class CustomerHibernateDao extends SelloCityHibernateDao<Customer> implements CustomerDAO<Customer>{
 
	public List<Customer> findByName(String name){
		return findByCriteria(Restrictions.eq("name",name));
	}
  public Class<Customer> getPersistentClass() {
    return Customer.class;
  }

 
 
}
