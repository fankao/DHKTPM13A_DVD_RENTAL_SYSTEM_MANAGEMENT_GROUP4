package com.group4.business;

import java.util.List;

import com.group4.dao.IChiTietDatGiuDAO;
import com.group4.dao.IDiaDAO;
import com.group4.dao.impl.ChiTietDatGiuDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.entities.ChiTietDatGiu;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.TrangThaiDia;
import com.group4.entities.TuaDe;

public class DatTruocDiaBUS {
	private static IChiTietDatGiuDAO chiTietDatGiuDAO;
	private static IDiaDAO diaDAO;
	static {
		chiTietDatGiuDAO = new ChiTietDatGiuDAO();
		diaDAO = new DiaDAO();
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
		return chiTietDatGiuDAO.getCTDatGiuDauTien(dia);
	}

	public ChiTietDatGiu ganDia(Dia dia) {
		ChiTietDatGiu chiTietDatGiu = layChiTietDatGiuSomNhat(dia);
		
		if(chiTietDatGiu == null) {
			return null;
		}
		
		chiTietDatGiu.setDaGanDia(true);
		dia.setTrangThai(TrangThaiDia.ON_HOLD);
		
		if(diaDAO.update(dia) ==null || chiTietDatGiuDAO.update(chiTietDatGiu) ==null) {
			return null;
		}
		
		
		return chiTietDatGiu;
	}

}
