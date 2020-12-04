package com.group4.business;

import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.KhachHang;

public class XoaKhachHangBUS {
	private static KhachHangDAO khachHangDAO;
	static {
		khachHangDAO = new KhachHangDAO();
	}

	/**
	 * Thực hiện việc xoá khách hàng khi khách hàng không thực hiện thuê trả, đặt
	 * trước đĩa
	 * 
	 * @param khachHang: khách hàng muốn xoá
	 * @return: true: nếu xoá thành công/ false: nếu ngược lại
	 */
	public boolean xoaKhachHang(KhachHang khachHang) {
		return !khachHangDAO.khachHangDaDatDia(khachHang.getId()) && !khachHangDAO.khachHangDaThueDia(khachHang.getId())
				&& khachHangDAO.delete(khachHang);
	}
}
