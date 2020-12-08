package com.group4.dao.impl;

import javax.persistence.TypedQuery;

import com.group4.dao.ITaiKhoanDAO;
import com.group4.entities.TaiKhoan;

public class TaiKhoanDAO extends AbstractDAO<TaiKhoan, Long> implements ITaiKhoanDAO {

	@Override
	public TaiKhoan dangNhap(String tenTaiKhoan, String password) {
		TypedQuery<TaiKhoan> query = em
				.createQuery("select tk from TaiKhoan tk where tk.username=:u and password =:p", TaiKhoan.class)
				.setParameter("u", tenTaiKhoan).setParameter("p", password);

		return query.getResultList().size() == 0 ? null : query.getResultList().get(0);
	}

}
