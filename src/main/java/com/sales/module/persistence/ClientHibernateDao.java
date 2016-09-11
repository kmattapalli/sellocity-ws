package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.ClientDAO;
import com.sales.module.domain.ScClient;

@Repository("clientDao")
public class ClientHibernateDao extends SelloCityHibernateDao<ScClient> implements ClientDAO<ScClient>{
 

  public Class<ScClient> getPersistentClass() {
    return ScClient.class;
  }

 
 
}
