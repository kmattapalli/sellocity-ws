package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.ClientDAO;
import com.sales.module.domain.Clients;

@Repository("clientDao")
public class ClientHibernateDao extends SelloCityHibernateDao<Clients> implements ClientDAO<Clients>{
 

  public Class<Clients> getPersistentClass() {
    return Clients.class;
  }

 
 
}
