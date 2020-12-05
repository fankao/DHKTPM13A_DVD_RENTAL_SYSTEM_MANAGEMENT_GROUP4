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

	public List<ChiTietDatGiu> getDSDatBanSaoTheoKH(Long khachHangId) {
		return chiTietDatGiuDAO.getDSDatBanSaoTheoKH(khachHangId);
	}

	public List<TuaDe> getDSTuaDeKhachHangChuaDat(Long khachHangId) {
		return chiTietDatGiuDAO.getDSTuaDeMaKhacHangChuaDat(khachHangId);
	}

	public boolean datGiuBanSao(KhachHang khachHang, TuaDe tuaDe) {
		ChiTietDatGiu chiTietDatGiu = new ChiTietDatGiu();
		chiTietDatGiu.datGiuDia(khachHang, tuaDe);
		return chiTietDatGiuDAO.create(chiTietDatGiu) != null;
	}

	public ChiTietDatGiu layChiTietDatGiuSomNhat(Dia dia) {

		return null;
	}

	public boolean ganDia(ChiTietDatGiu chiTietDatGiu) {

		return true;
	}

}
