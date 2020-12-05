package com.group4.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import com.group4.business.DatTruocDiaBUS;
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
		KhachHang kh1 = new KhachHang("Minh Chiến", "0852369741", "Bình Phước");
		kh1 = khachHangDAO.create(kh1);
		KhachHang kh2 = new KhachHang("Gia Hưng", "0939221234", "Quảng Nam");
		kh2 = khachHangDAO.create(kh2);
		KhachHang kh3 = new KhachHang("Thanh Trí", "0987456322", "Ninh Thuận");
		kh3 = khachHangDAO.create(kh3);
		KhachHang kh4 = new KhachHang("Hồng Phúc", "0943223458", "Vĩnh Long");
		kh4 = khachHangDAO.create(kh4);
		KhachHang kh5 = new KhachHang("Văn Chiến", "0674322133", "TP Hồ Chí Minh");
		kh5 = khachHangDAO.create(kh5);
		KhachHang kh6 = new KhachHang("Thanh Tùng", "0121653445", "Hà Nội");
		kh5 = khachHangDAO.create(kh6);

		ITuaDeDAO tuaDeDAO = new TuaDeDAO();
		TuaDe tuaDe1 = new TuaDe("Chiến tranh giữa các vì sao");
		tuaDeDAO.create(tuaDe1);
		TuaDe tuaDe2 = new TuaDe("Pokemon");
		tuaDeDAO.create(tuaDe2);
		TuaDe tuaDe3 = new TuaDe("Du Hành Giữa các Vì Sao");
		tuaDeDAO.create(tuaDe3);
		TuaDe tuaDe4 = new TuaDe("Liên Minh Huyền Diệu");
		tuaDeDAO.create(tuaDe4);
		TuaDe tuaDe5 = new TuaDe("Transformer");
		tuaDeDAO.create(tuaDe5);

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
		Dia dia7 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l1);
		diaDAO.create(dia7);
		Dia dia8 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe3, l1);
		diaDAO.create(dia8);
		Dia dia9 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe4, l2);
		diaDAO.create(dia9);
		Dia dia10 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe5, l1);
		diaDAO.create(dia10);

		ThueTraDiaBUS thueTraDiaBUS = new ThueTraDiaBUS();
		thueTraDiaBUS.xuLyThueDia(kh1, new HashSet<Dia>(Arrays.asList(dia1, dia2, dia3, dia4)));
		thueTraDiaBUS.xuLyThueDia(kh2, new HashSet<Dia>(Arrays.asList(dia10, dia6)));
		thueTraDiaBUS.xuLyThueDia(kh3, new HashSet<Dia>(Arrays.asList(dia7, dia9)));

		// dữ liệu test thanh toán phí trễ hạn

		IChiTietThueTraDAO chiTietThueTraDAO = new ChiTietThueTraDAO();

		ChiTietThueTra chiTietThueTra1 = chiTietThueTraDAO.findById(new ChiTietThueTraID(1L, 1L));
		chiTietThueTra1.setNgayTra(LocalDate.of(2020, 12, 20));

		ChiTietThueTra chiTietThueTra2 = chiTietThueTraDAO.findById(new ChiTietThueTraID(1L, 2L));
		chiTietThueTra2.setNgayTra(LocalDate.of(2020, 12, 20));

		ChiTietThueTra chiTietThueTra3 = chiTietThueTraDAO.findById(new ChiTietThueTraID(1L, 3L));
		chiTietThueTra3.setNgayTra(LocalDate.of(2020, 12, 20));

		ChiTietThueTra chiTietThueTra4 = chiTietThueTraDAO.findById(new ChiTietThueTraID(1L, 4L));
		chiTietThueTra4.setNgayTra(LocalDate.of(2020, 12, 20));

		chiTietThueTraDAO.update(chiTietThueTra1);
		chiTietThueTraDAO.update(chiTietThueTra2);
		chiTietThueTraDAO.update(chiTietThueTra3);
		chiTietThueTraDAO.update(chiTietThueTra4);

		// Dữ liệu test gán đĩa
		ChiTietThueTra chiTietThueTra5 = chiTietThueTraDAO.findById(new ChiTietThueTraID(kh2.getId(), dia10.getId()));
		chiTietThueTra5.setNgayTra(LocalDate.now());
		chiTietThueTraDAO.update(chiTietThueTra5);
		
		DatTruocDiaBUS datTruocDiaBUS = new DatTruocDiaBUS();
		datTruocDiaBUS.datGiuBanSao(kh1, tuaDe5);
		datTruocDiaBUS.datGiuBanSao(kh3, tuaDe5);
		datTruocDiaBUS.datGiuBanSao(kh4, tuaDe5);
		datTruocDiaBUS.datGiuBanSao(kh5, tuaDe5);
	}

}
