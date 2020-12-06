package com.group4.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.group4.dao.IChiTietThueTraDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.ChiTietThueTraID;

public class ChiTietThueTraDAO extends AbstractDAO<ChiTietThueTra, ChiTietThueTraID> implements IChiTietThueTraDAO {

	public ChiTietThueTraDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Lấy danh sách chi tiết thuê trả đã trả đĩa
	 */
	@Override
	public List<ChiTietThueTra> getDSDaTraDiaTheoKH(Long khId) {
		TypedQuery<ChiTietThueTra> query = em.createQuery(
				"select ct from ChiTietThueTra ct where ct.ngayTra is not null and ct.khachHang.id =:khId ",
				ChiTietThueTra.class).setParameter("khId", khId);

		List<ChiTietThueTra> results = query.getResultList();

		return results.size() == 0 ? new ArrayList<ChiTietThueTra>() : results;
	}

	@Override
	public List<ChiTietThueTra> getDSChuaTraDiaTheoDia(Long khId) {
		TypedQuery<ChiTietThueTra> query = em
				.createQuery("select ct from ChiTietThueTra ct where ct.ngayTra is null and ct.khachHang.id =:khId",
						ChiTietThueTra.class)
				.setParameter("khId", khId);

		List<ChiTietThueTra> results = query.getResultList();

		return results.size() == 0 ? new ArrayList<ChiTietThueTra>() : results;
	}

}
