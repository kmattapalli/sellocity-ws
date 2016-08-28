package com.sales.module.dao;

import java.util.List;

public interface SelloCityDao<T> {
  T persist(T entity);
  void persist(List<T> entityList);
  public T update (T entity);
  void delete(T entity);
  T findByID(Long id);
  List<T> findByIDs(List<Long> ids);
  List<T> findAll();
}
