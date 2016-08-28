package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.UserDAO;
import com.sales.module.domain.User;

@Repository
public class UserHibernateDao extends SelloCityHibernateDao<User> implements UserDAO<User>{
 

  public Class<User> getPersistentClass() {
    return User.class;
  }

 
 
}
