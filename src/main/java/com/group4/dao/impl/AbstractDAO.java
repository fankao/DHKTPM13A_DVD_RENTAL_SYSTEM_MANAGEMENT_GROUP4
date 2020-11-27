package com.group4.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;

import com.group4.dao.DBManager;
import com.group4.dao.IGenericDAO;

public abstract class AbstractDAO<T, ID> implements IGenericDAO<T, ID> {
	
	protected EntityManager em;

	private Class<T> domainClass;
	
	protected final Logger logger = Logger.getLogger(getDomainClassName());
	

	public AbstractDAO() {
		em = DBManager.getInstance().getEntityManager();
	}

	@Override
	public List<T> findAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(getDomainClass());
		criteriaQuery.from(getDomainClass());
		TypedQuery<T> query = em.createQuery(criteriaQuery);
		logger.info("Số phần tử: "+query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public T findById(ID id) {
		return em.find(getDomainClass(), id);
	}

	@Override
	public T create(T obj) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(obj);
			tr.commit();
			logger.info("Thêm mới thành công");
			return obj;
		} catch (Exception e) {
			tr.rollback();
			logger.error("Thêm mới thất bại: "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public T update(T objUpdate) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(objUpdate);
			tr.commit();
			logger.info("Cập nhật thành công");
			return objUpdate;
		} catch (Exception e) {
			tr.rollback();
			logger.error("Cập nhật thất bại: "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(T t) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(t);
			tr.commit();
			logger.info("Xoá thành công");
			return true;
		} catch (Exception e) {
			tr.rollback();
			logger.error("Xoá thất bại: "+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(ID id) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(findById(id));
			tr.commit();
			logger.info("Xoá thành công");
			return true;
		} catch (Exception e) {
			tr.rollback();
			logger.error("Xoá thất bại: "+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class<T>) type.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	protected String getDomainClassName() {
		return getDomainClass().getSimpleName();
	}

}
