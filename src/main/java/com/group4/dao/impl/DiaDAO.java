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
			query = em.createQuery("select d Dia d where dia.id =:diaId and dia.trangThai LIKE ? :trangThai", Dia.class)
					.setParameter("diaId", diaId).setParameter("trangThai", TrangThaiDia.ON_SHEFT.name());

		} catch (Exception e) {
			logger.error("Truy vấn thất bại: " + e.getMessage());
		}

		return query != null && query.getResultList().size() > 0;
	}

}
