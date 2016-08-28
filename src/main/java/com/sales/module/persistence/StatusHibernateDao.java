package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.StatusDAO;
import com.sales.module.domain.Status;

@Repository
public class StatusHibernateDao extends SelloCityHibernateDao<Status> implements StatusDAO<Status>{
 

  public Class<Status> getPersistentClass() {
    return Status.class;
  }

 
 
}
