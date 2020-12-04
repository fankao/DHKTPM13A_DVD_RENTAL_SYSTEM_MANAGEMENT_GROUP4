package com.group4.business;

import java.util.List;

import com.group4.dao.IChiTietDatGiuDAO;
import com.group4.dao.impl.ChiTietDatGiuDAO;
import com.group4.entities.ChiTietDatGiu;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.TuaDe;

public class DatTruocDiaBUS {
	private static IChiTietDatGiuDAO chiTietDatGiuDAO;
	static {
		chiTietDatGiuDAO = new ChiTietDatGiuDAO();
	}

	public boolean datGiuBanSao(KhachHang khachHang, List<TuaDe> dsTuaDe) {
		int check = 0;
		for (TuaDe tuaDe : dsTuaDe) {
			ChiTietDatGiu chiTietDatGiu = new ChiTietDatGiu();
			chiTietDatGiu.datGiuDia(khachHang,tuaDe);
			if(chiTietDatGiuDAO.create(chiTietDatGiu)!=null) {
				check++;
			}
		}
		return check>0;
	}

	public ChiTietDatGiu layChiTietDatGiuSomNhat(Dia dia) {

		return null;
	}

	public boolean ganDia(ChiTietDatGiu chiTietDatGiu) {

		return true;
	}

}
