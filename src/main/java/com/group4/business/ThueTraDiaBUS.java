package com.group4.business;

import static com.group4.ui.panel.UtilsLayout.isInputFieldNotBlank;

import java.time.LocalDate;
import java.util.Set;

import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.IDiaDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.ui.panel.PnlRentDisk;
import com.group4.ui.panel.PnlTraDia;

public class ThueTraDiaBUS {
	private static IChiTietThueTraDAO chiTietThueTraDAO;
	private static ThanhToanPhiTreHanBUS thanhToanPhiTreHanBUS;
	private static IDiaDAO diaDAO;
	static {
		thanhToanPhiTreHanBUS = new ThanhToanPhiTreHanBUS();
		chiTietThueTraDAO = new ChiTietThueTraDAO();
		diaDAO = new DiaDAO();
	}

	/**
	 * Xử lý thuê đĩa
	 * 
	 * @param khachHang: khách hàng muốn thuê đĩa
	 * @param dsDiaThue: danh sách đĩa muốn thuê
	 * @return: true nếu thuê thành công/ false nếu thất bại
	 */
	public boolean xuLyThueDia(KhachHang khachHang, Set<Dia> dsDiaThue) {
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

		// TODO: tìm khách hàng
		// TODO: thêm phí trễ hạn
		// TODO: cập nhật chi tiết thuê trả
		// TODO: cập nhật trạng thái đĩa
		public boolean traDia(KhachHang khachHang, Set<Dia> dsDiaTra,LocalDate ngaytra) {
			int check = 0;
			for (Dia dia : dsDiaTra) {
				ChiTietThueTra chiTietThueTra = new ChiTietThueTra();
				chiTietThueTra.traDia(khachHang, dia,ngaytra);
				if (chiTietThueTraDAO.update(chiTietThueTra) != null) {
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
			tongTien += dia.getPhiThue();
		}
		return tongTien;
	}

	

}
