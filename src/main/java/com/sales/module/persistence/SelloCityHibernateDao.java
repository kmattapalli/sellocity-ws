package com.sales.module.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sales.module.dao.SelloCityDao;




@Transactional(readOnly = true)
public abstract class SelloCityHibernateDao<T> implements SelloCityDao<T> {

    @Autowired(required=true)
    private SessionFactory sessionFactory;

  @SuppressWarnings("unchecked")
  @Transactional(readOnly = true)
  public T findByID(Long id) {
    List<T> list = findByCriteria(Restrictions.eq("id", id));
    return list.isEmpty() ? null : list.get(0);
  }

  @Transactional(readOnly = false)
  public T persist(T entity) {
    getSession().save(entity);
    return entity;
  }
  @Transactional(readOnly = false)
  public T update (T entity) {
    getSession().update(entity);
    return entity;
  }
    
  @Transactional(readOnly = false)
  public void persist(List<T> entityList) {
    for(T entity: entityList) {
      getSession().saveOrUpdate(entity);
    }
  }
  
  @Transactional(readOnly = false)
  public void delete(T entity) {
    getSession().delete(entity);
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  protected List<T> findByCriteria(Criterion... criterion) {
    Criteria crit = getSession().createCriteria(getPersistentClass());
    for (Criterion c : criterion) {
      crit.add(c);
    }
    return crit.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<T> findAll() {
    return (List<T>)getSession().createCriteria(getPersistentClass()).list();
  }
  
  @SuppressWarnings("unchecked")
  public List<T> findByIDs(List<Long> ids) {
    Criteria crit = getSession().createCriteria(getPersistentClass());
    crit.add(Restrictions.in("id", ids));
    return (List<T>)crit.list();
  }

  public abstract Class<T> getPersistentClass();
}
