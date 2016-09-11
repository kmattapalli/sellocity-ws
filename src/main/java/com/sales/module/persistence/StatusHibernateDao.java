package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.StatusDAO;
import com.sales.module.domain.ScStatus;

@Repository
public class StatusHibernateDao extends SelloCityHibernateDao<ScStatus> implements StatusDAO<ScStatus>{
 

  public Class<ScStatus> getPersistentClass() {
    return ScStatus.class;
  }

 
 
}
