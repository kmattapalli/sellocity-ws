package com.sales.module.persistence;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayMappingDAO;
import com.sales.module.domain.ScSalesplayMapping;

@Repository
public class SalesPlayMappingHibernateDao extends SelloCityHibernateDao<ScSalesplayMapping> implements SalesPlayMappingDAO<ScSalesplayMapping>{
 

	
	
  public Class<ScSalesplayMapping> getPersistentClass() {
    return ScSalesplayMapping.class;
  }

	@Override
	public ScSalesplayMapping findByScSalesplayMappingId(Integer spIdValue) {
		List<ScSalesplayMapping> playList= findByCriteria(Restrictions.eq("SPID",spIdValue));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}
	@Override
	public List<ScSalesplayMapping> findByScSalesplayMappingList(Integer spIdValue) {
		List<ScSalesplayMapping> playList= findByCriteria(Restrictions.eq("scSalesplay",spIdValue));
//		if(playList != null && playList.size() >=0){
//			return playList.get(0);
//		}
		return playList;
	}
	@Override
	public ScSalesplayMapping findByScSalesplayMappingWithBenefits(Integer spIdValue){
		ScSalesplayMapping mappingObj = new ScSalesplayMapping();
		List<ScSalesplayMapping> playList= findByCriteria(Restrictions.eq("spmapId",spIdValue));
		if(playList != null && playList.size() >=0){
			mappingObj= playList.get(0);
		}
		 Hibernate.initialize(mappingObj.getScSalesplayBenefits());
		return mappingObj;
	}
 	}
