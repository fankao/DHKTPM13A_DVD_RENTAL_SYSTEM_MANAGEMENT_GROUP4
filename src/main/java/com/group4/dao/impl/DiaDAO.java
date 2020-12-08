package com.group4.dao.impl;

import javax.persistence.TypedQuery;

import com.group4.dao.IDiaDAO;
import com.group4.entities.Dia;
import com.group4.entities.TrangThaiDia;

public class DiaDAO extends AbstractDAO<Dia, Long> implements IDiaDAO {

	@Override
	public boolean checkDiaCoTrenKe(Long diaId) {
		TypedQuery<Dia> query = null;
		try {
			query = em.createQuery("select dia from Dia dia where dia.id =:diaId and dia.trangThai like :trangThai", Dia.class)
					.setParameter("diaId", diaId).setParameter("trangThai", TrangThaiDia.ON_SHEFT);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Truy vấn thất bại: " + e.getMessage());
		}

		return query != null && query.getResultList().size() > 0;
	}

}
