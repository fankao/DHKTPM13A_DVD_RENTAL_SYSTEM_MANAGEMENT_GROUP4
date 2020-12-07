package com.group4.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.group4.dao.IChiTietDatGiuDAO;
import com.group4.entities.ChiTietDatGiu;
import com.group4.entities.ChiTietDatGiuID;
import com.group4.entities.Dia;
import com.group4.entities.TuaDe;

public class ChiTietDatGiuDAO extends AbstractDAO<ChiTietDatGiu, ChiTietDatGiuID> implements IChiTietDatGiuDAO {

	@Override
	public List<TuaDe> getDSTuaDeMaKhacHangChuaDat(Long khachHangId) {
		TypedQuery<TuaDe> query = null;
		try {
			query = em.createQuery(
					"select distinct tuaDe from TuaDe tuaDe left join ChiTietDatGiu ct on ct.tuaDe.id != tuaDe.id where ct.khachHang.id !=: khachHangId",
					TuaDe.class).setParameter("khachHangId", khachHangId);
		} catch (Exception e) {
			logger.error("Lỗi truy vấn: " + e.getMessage());
			logger.info("Nguyên nhân: " + e.getCause());
		}

		if (query == null || query.getResultList().size() == 0) {
			return new ArrayList<TuaDe>();
		}

		return query.getResultList();
	}

	@Override
	public List<ChiTietDatGiu> getDSDatBanSaoTheoKH(Long khachHangId) {
		TypedQuery<ChiTietDatGiu> query = null;
		try {
			query = em.createQuery("select ct from ChiTietDatGiu ct where ct.khachHang.id = :khachHangId",
					ChiTietDatGiu.class).setParameter("khachHangId", khachHangId);
		} catch (Exception e) {
			logger.error("Lỗi truy vấn: " + e.getMessage());
			logger.info("Nguyên nhân: " + e.getCause());
		}

		if (query == null || query.getResultList().size() == 0) {
			return new ArrayList<ChiTietDatGiu>();
		}

		return query.getResultList();
	}

	@Override
	public ChiTietDatGiu getCTDatGiuDauTien(Dia dia) {
		TypedQuery<ChiTietDatGiu> query = null;
		try {
			query = em.createQuery("select ct from ChiTietDatGiu ct where ct.tuaDe.id =: tuaDeId order by ct.ngayDat asc",
					ChiTietDatGiu.class).setParameter("tuaDeId", dia.getTuaDe().getId());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			logger.error("Lỗi truy vấn: " + e.getMessage());
			logger.info("Nguyên nhân: " + e.getCause());
		}
		if (query == null || query.getResultList().size() == 0) {
			return null;
		}
		return query.getResultList().get(0);
	}

}
