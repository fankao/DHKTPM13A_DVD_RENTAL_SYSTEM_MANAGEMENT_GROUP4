package com.group4.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import com.group4.business.ThueTraDiaBUS;
import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.IDiaDAO;
import com.group4.dao.IKhachHangDAO;
import com.group4.dao.ILoaiDiaDAO;
import com.group4.dao.ITuaDeDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.dao.impl.LoaiDiaDAO;
import com.group4.dao.impl.TuaDeDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.ChiTietThueTraID;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.LoaiDia;
import com.group4.entities.TenLoaiDia;
import com.group4.entities.TrangThaiDia;
import com.group4.entities.TuaDe;

public class TestingThanhToanPhiTreHan {
	public static void main() {
		IKhachHangDAO khachHangDAO = new KhachHangDAO();
		khachHangDAO.create(new KhachHang("Minh Chiến", "0852369741", "Bình Phước"));
		khachHangDAO.create(new KhachHang("Gia Hưng", "0939221234", "Quảng Nam"));
		khachHangDAO.create(new KhachHang("Thanh Trí","0987456322","Ninh Thuận"));
		khachHangDAO.create(new KhachHang("Hồng Phúc", "0943223458", "Vĩnh Long"));
		khachHangDAO.create(new KhachHang("Văn Chiến", "0674322133", "TP Hồ Chí Minh"));
		khachHangDAO.create(new KhachHang("Thanh Tùng","0121653445","Hà Nội"));
		
		
		ITuaDeDAO tuaDeDAO = new TuaDeDAO();
		TuaDe tuaDe1 = new TuaDe("Chiến tranh giữa các vì sao");
		tuaDeDAO.create(tuaDe1);
		TuaDe tuaDe2 = new TuaDe("Pokemon");
		tuaDeDAO.create(tuaDe2);

		ILoaiDiaDAO loaiDiaDAO = new LoaiDiaDAO();
		LoaiDia l1 = new LoaiDia(TenLoaiDia.DVD, 100, 10, 10);
		loaiDiaDAO.create(l1);
		LoaiDia l2 = new LoaiDia(TenLoaiDia.GAME, 150, 15, 15);
		loaiDiaDAO.create(l2);

		IDiaDAO diaDAO = new DiaDAO();
		Dia dia1 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l1);
		diaDAO.create(dia1);
		Dia dia2 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l2);
		diaDAO.create(dia2);
		Dia dia3 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l2);
		diaDAO.create(dia3);
		Dia dia4 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l1);
		diaDAO.create(dia4);
		Dia dia5 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l2);
		diaDAO.create(dia5);
		Dia dia6 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l1);
		diaDAO.create(dia6);

		ThueTraDiaBUS thueTraDiaBUS = new ThueTraDiaBUS();
		thueTraDiaBUS.xuLyThueDia(khachHangDAO.findById(1L), new HashSet<Dia>(Arrays.asList(dia1, dia2,dia3)));

		IChiTietThueTraDAO chiTietThueTraDAO = new ChiTietThueTraDAO();
		
		ChiTietThueTra chiTietThueTra1 = chiTietThueTraDAO.findById(new ChiTietThueTraID(1L, 1L));
		chiTietThueTra1.setNgayTra(LocalDate.of(2020, 12, 20));

		ChiTietThueTra chiTietThueTra2 = chiTietThueTraDAO.findById(new ChiTietThueTraID(1L, 2L));
		chiTietThueTra2.setNgayTra(LocalDate.of(2020, 12, 20));
		
		ChiTietThueTra chiTietThueTra3 = chiTietThueTraDAO.findById(new ChiTietThueTraID(1L, 3L));
		chiTietThueTra3.setNgayTra(LocalDate.of(2020, 12, 20));

		chiTietThueTraDAO.update(chiTietThueTra1);
		chiTietThueTraDAO.update(chiTietThueTra2);
		chiTietThueTraDAO.update(chiTietThueTra3);
	}

}
