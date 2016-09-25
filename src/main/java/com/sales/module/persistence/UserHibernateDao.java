package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.UserDAO;
import com.sales.module.domain.ScUser;

@Repository
public class UserHibernateDao extends SelloCityHibernateDao<ScUser> implements UserDAO<ScUser>{
 

  public Class<ScUser> getPersistentClass() {
    return ScUser.class;
  }

@Override
public ScUser findBySuid(Integer suid) {
		List<ScUser> playList= findByCriteria(Restrictions.eq("suid",suid));
		
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;

}

 
 
}
