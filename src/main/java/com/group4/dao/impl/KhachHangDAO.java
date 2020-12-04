package com.group4.dao.impl;

import javax.persistence.TypedQuery;

import com.group4.dao.IKhachHangDAO;
import com.group4.entities.KhachHang;

public class KhachHangDAO extends AbstractDAO<KhachHang, Long> implements IKhachHangDAO {

	@Override
	public boolean khachHangDaThueDia(Long khachHangId) {
		TypedQuery<KhachHang> query = null;
		try {
			query = em.createQuery("select kh from KhachHang kh JOIN ChiTietThueTra ct ON ct.khachHangId = kh.id where kh.id =:khachHangId", KhachHang.class)
					.setParameter("khachHangId", khachHangId);
		} catch (Exception e) {
			logger.error("Truy vấn thất bại: " + e.getMessage());
		}
		return query != null && query.getResultList().size() > 0;
	}

	@Override
	public boolean khachHangDaDatDia(Long khachHangId) {
		TypedQuery<KhachHang> query = null;
		try {
			query = em.createQuery("select kh from KhachHang kh JOIN ChiTietDatGiu ct ON ct.khachHangId = kh.id where kh.id =:khachHangId", KhachHang.class)
					.setParameter("khachHangId", khachHangId);
		} catch (Exception e) {
			logger.error("Truy vấn thất bại: " + e.getMessage());
		}
		return query != null && query.getResultList().size() > 0;
	}

}
