package com.group4.business;

import com.group4.dao.IChiTietDatGiuDAO;
import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.IKhachHangDAO;
import com.group4.dao.impl.ChiTietDatGiuDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.KhachHang;

public class KhachHangBUS {
	private static IKhachHangDAO khachHangDAO;
	private static IChiTietDatGiuDAO chiTietDatGiuDAO;
	private static IChiTietThueTraDAO chiTietThueTraDAO;
	static {
		khachHangDAO = new KhachHangDAO();
		chiTietDatGiuDAO = new ChiTietDatGiuDAO();
		chiTietThueTraDAO = new ChiTietThueTraDAO();
	}

	/**
	 * Xoá khách hàng
	 * @param khachHang: khách hàng cần xoá
	 * @return true: nếu xoá thành công/ false: nếu khách hàng đã thuê đĩa, đặt đĩa
	 */
	public boolean xoaKhachHang(KhachHang khachHang) {
		if(khachHangDaDatDia(khachHang.getId()) == false || khachHangDaThueDia(khachHang.getId()) == false) {
			return false;
		}
		return khachHangDAO.delete(khachHang);
	}

	public boolean khachHangDaThueDia(Long khachHangId) {
		return chiTietThueTraDAO.findAll()
				.stream().filter(x -> x.getKhachHang().getId() == khachHangId).count() > 0;
	}

	public boolean khachHangDaDatDia(Long khachHangId) {
		return chiTietDatGiuDAO.findAll()
				.stream().filter(x -> x.getKhachHang().getId() == khachHangId).count() > 0;
	}

}
