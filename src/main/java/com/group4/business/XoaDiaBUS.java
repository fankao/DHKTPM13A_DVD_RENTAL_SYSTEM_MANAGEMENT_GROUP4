package com.group4.business;

import com.group4.dao.IDiaDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.entities.Dia;
import com.group4.entities.TrangThaiDia;

public class XoaDiaBUS {
	private static IDiaDAO diaDAO;
	static {
		diaDAO = new DiaDAO();
	}

	public boolean xoaDia(Dia dia) {
		if (dia.getTrangThai() != TrangThaiDia.ON_HOLD && !diaDAO.diaDaDuocThue(dia.getId())
				&& !diaDAO.diaDaDuocDat(dia.getId())) {
			return diaDAO.delete(dia);
		}
		return false;
	}

}
