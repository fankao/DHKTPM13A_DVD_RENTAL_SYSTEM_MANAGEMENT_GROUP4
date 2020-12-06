package com.group4.business;
import static com.group4.Injection.chiTietDatGiuDAO;
import static com.group4.Injection.chiTietThueTraDAO;
import static com.group4.Injection.khachHangDAO;
import static com.group4.Injection.thanhToanPhiTreHanBUS;

import java.util.List;
import java.util.stream.Collectors;

import com.group4.entities.ChiTietThueTra;
import com.group4.entities.KhachHang;

public class KhachHangBUS {
	

	/**
	 * Lấy danh sách khách hàng có phí trễ hạn
	 * 
	 * @return
	 */
	public List<KhachHang> getDSKhachHangCoPhiTreHan() {
		return khachHangDAO.findAll().stream()
				.filter(x -> thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(x.getId()).size() > 0 == true)
				.collect(Collectors.toList());
	}

	/**
	 * Lấy số đĩa thuê đã thuê
	 * 
	 * @param khachHang
	 * @return số đĩa thuê
	 */
	public int tinhSoDiaDaThue(KhachHang khachHang) {
		return khachHang.getDsChiTietThueTra().size();
	}

	/**
	 * Xoá khách hàng
	 * 
	 * @param khachHang: khách hàng cần xoá
	 * @return true: nếu xoá thành công/ false: nếu khách hàng đã thuê đĩa, đặt đĩa
	 */
	public boolean xoaKhachHang(KhachHang khachHang) {
		if (khachHangDaDatDia(khachHang.getId()) == true || khachHangDaThueDia(khachHang.getId()) == true) {
			return false;
		}
		return khachHangDAO.delete(khachHang);
	}

	// Kiểm tra khách hàng có trong danh sách đang thuê đĩa hay không
	public boolean khachHangDaThueDia(Long khachHangId) {
		return chiTietThueTraDAO.findAll().stream().filter(x -> x.getKhachHang().getId() == khachHangId).count() > 0;
	}

	// Kiểm tra khách hàng có trong danh sách đặt đĩa trước hay không
	public boolean khachHangDaDatDia(Long khachHangId) {
		return chiTietDatGiuDAO.findAll().stream().filter(x -> x.getKhachHang().getId() == khachHangId).count() > 0;
	}

	/**
	 * lấy số đĩa chưa trả
	 * @param khachHang
	 * @return
	 */
	public List<ChiTietThueTra> getDSChiTietChuaTraDia(KhachHang khachHang) {
		return khachHang.getDsChiTietThueTra().stream().filter(x -> x.getNgayTra() != null)
				.collect(Collectors.toList());
	}

}
