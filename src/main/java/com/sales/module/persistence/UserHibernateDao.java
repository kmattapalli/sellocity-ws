package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.UserDAO;
import com.sales.module.domain.ScUser;

@Repository
public class UserHibernateDao extends SelloCityHibernateDao<ScUser> implements UserDAO<ScUser>{
 

  public Class<ScUser> getPersistentClass() {
    return ScUser.class;
  }

 
 
}
