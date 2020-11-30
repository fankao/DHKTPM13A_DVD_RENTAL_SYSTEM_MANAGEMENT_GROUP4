package com.group4.business;

import java.util.List;
import java.util.stream.Collectors;

import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.entities.ChiTietThueTra;

public class ThanhToanPhiTreHanBUS {

	private static IChiTietThueTraDAO chiTietThueTraDAO;

	static {
		chiTietThueTraDAO = new ChiTietThueTraDAO();
	}

	/**
	 * UC005b: Lấy danh sách chi tiết thuê trả đã trễ hạn trả đĩa theo id khách hàng
	 * 
	 * @param khachHangId: id khách hàng
	 * @return List<ChiTietThueTra>
	 */
	public List<ChiTietThueTra> getDSThueTraTreHanTheoKH(Long khachHangId) {
		List<ChiTietThueTra> ds = chiTietThueTraDAO.getDSDaTraDiaTheoKH(khachHangId);
		return ds.stream().filter(x -> daTreHanTraDia(x) == true && x.isDaThanhToanPhiTreHan() == false)
				.collect(Collectors.toList());

	}

	/**
	 * Tính tồng tiền trễ hạn
	 * 
	 * @param dsThueTraTreHan: danh sách trễ hạn
	 * @return tổng tiền
	 */
	public double tinhTongTienPhiTreHan(List<ChiTietThueTra> dsThueTraTreHan) {
		return 0.0;
	}

	/**
	 * UC005c: ghi nhận thanh toán phí trễ hạn
	 * 
	 * @param dsChiTietThueTra: danh sách chi tiết thuê trả có phí trễ hạn
	 * @return: true: đã ghi nhận / false: không thể ghi nhậns
	 */
	public boolean ghiNhanThanhToanPhiTreHan(List<ChiTietThueTra> dsChiTietThueTra) {
		int check = 0;
		for (ChiTietThueTra chiTietThueTra : dsChiTietThueTra) {
			if (thanhToanPhiTreHan(chiTietThueTra) != null) {
				check++;
			}
		}
		return check > 0;
	}

	/**
	 * Kiểm tra trễ hạn trả đĩa
	 * 
	 * @param chiTietThueTra: chi tiết thuê trả cần kiểm tra
	 * @return true: trễ hạn/ false: không trễ hạn
	 */
	private boolean daTreHanTraDia(ChiTietThueTra chiTietThueTra) {
		// kiểm tra xem ngày trả đĩa có sau ngày thuê + số ngày thuê được quy định bởi
		// loại đĩa không
		boolean daTreHan = chiTietThueTra.getNgayTra()
				.isAfter(chiTietThueTra.getNgayThue().plusDays(chiTietThueTra.getDia().getLoaiDia().getSoNgayThue()));

		return daTreHan;
	}

	/**
	 * Thực hiện thanh toán phí trễ hạn
	 * 
	 * @param chiTietThueTra: chi tiết thuê trả có phí trễ hạn
	 * @return: chi tiêt thuê trả đã thanh toán phí trễ hạn
	 */
	private ChiTietThueTra thanhToanPhiTreHan(ChiTietThueTra chiTietThueTra) {
		chiTietThueTra.setDaThanhToanPhiTreHan(true);
		return chiTietThueTraDAO.update(chiTietThueTra);

	}

}
