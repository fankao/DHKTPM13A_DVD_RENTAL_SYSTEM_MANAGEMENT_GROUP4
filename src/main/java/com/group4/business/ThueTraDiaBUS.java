package com.group4.business;

import java.util.Set;

import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;

public class ThueTraDiaBUS {
	private static IChiTietThueTraDAO chiTietThueTraDAO;
	static {
		chiTietThueTraDAO = new ChiTietThueTraDAO();
	}

	/**
	 * Xử lý thuê đĩa
	 * 
	 * @param khachHang: khách hàng muốn thuê đĩa
	 * @param dsDiaThue: danh sách đĩa muốn thuê
	 * @return: true nếu thuê thành công/ false nếu thất bại
	 */
	public boolean xuLyThueDia(KhachHang khachHang, Set<Dia> dsDiaThue){
		int check = 0;
		for (Dia dia : dsDiaThue) {
			ChiTietThueTra chiTietThueTra = new ChiTietThueTra();
			chiTietThueTra.thueDia(khachHang, dia);
			if (chiTietThueTraDAO.create(chiTietThueTra) != null) {
				check++;
			}

		}
		return check > 0;

	}

	/**
	 * Tính tổng tiền thuê đĩa
	 * 
	 * @param dsThue: danh sách chi tiết thuê đĩa
	 * @return: tongTien: double
	 */
	public double tinhTongTienThueDia(Set<Dia> dsDiaThue) {
		double tongTien = 0.0;
		for (Dia dia : dsDiaThue) {
			tongTien += dia.getLoaiDia().getPhiThue();
		}
		return tongTien;
	}

	public boolean traDia() {
		// TODO: cập nhật chi tiết thuê trả
		// TODO: cập nhật trạng thái đĩa
		return false;
	}

}
