package com.group4.dao;

import java.util.List;

public interface IGenericDAO<T,ID> {
	List<T> findAll();
	
	T findById(ID id);
	
	T create(T obj);
	
	T update(T objUpdate);
	
	boolean delete(T t);
	
	boolean deleteById(ID id);
	

}
