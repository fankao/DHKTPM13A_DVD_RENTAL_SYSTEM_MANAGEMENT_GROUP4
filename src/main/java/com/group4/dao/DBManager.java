package com.group4.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DBManager {

	private static DBManager instance = null;

	private EntityManager em;

	private DBManager() {
		em = Persistence.createEntityManagerFactory("dvd-rental-management").createEntityManager();
	}

	public synchronized static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public EntityManager getEntityManager() {
		return em;
	}

}
