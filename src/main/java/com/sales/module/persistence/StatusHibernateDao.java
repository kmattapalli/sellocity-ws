package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.StatusDAO;
import com.sales.module.domain.ScStatus;

@Repository
public class StatusHibernateDao extends SelloCityHibernateDao<ScStatus> implements StatusDAO<ScStatus>{
 

  public Class<ScStatus> getPersistentClass() {
    return ScStatus.class;
  }

@Override
public ScStatus findScStatusByName(String name) {
	
	List<ScStatus> playList= findByCriteria(Restrictions.eq("name",name));
	
	if(playList != null && playList.size() >=0){
		return playList.get(0);
	}
	return null;

}

 
 
}
