package com.group4.dao.impl;

import javax.persistence.TypedQuery;

import com.group4.dao.IChiTietDatGiuDAO;
import com.group4.entities.ChiTietDatGiu;
import com.group4.entities.ChiTietDatGiuID;

public class ChiTietDatGiuDAO extends AbstractDAO<ChiTietDatGiu, ChiTietDatGiuID> implements IChiTietDatGiuDAO {

	@Override
	public ChiTietDatGiu layChiTietDatGiuSomNhatTheoTuaDe(Long tuaDeId) {
		TypedQuery<ChiTietDatGiu> query = null;
		try {
			query = em.createQuery("select ct from ChiTietDatGiu ct where ct.tuaDe.tuaDeId =: tuaDeId and min(ct.ngayDat)",
					ChiTietDatGiu.class).setParameter("tuaDeId", tuaDeId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Lỗi truy vấn: " + e.getMessage());
		}
		return query.getResultList().size() > 0 ? query.getSingleResult() : null;
	}

}
