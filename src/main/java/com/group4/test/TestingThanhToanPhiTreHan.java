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
import com.group4.dao.ITaiKhoanDAO;
import com.group4.dao.ITuaDeDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.dao.impl.LoaiDiaDAO;
import com.group4.dao.impl.TaiKhoanDAO;
import com.group4.dao.impl.TuaDeDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.ChiTietThueTraID;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.LoaiDia;
import com.group4.entities.TaiKhoan;
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
		kh6 = khachHangDAO.create(kh6);
		KhachHang kh7 = new KhachHang("Thanh Vũ", "0741258963", "Hà Nam");
		kh7 = khachHangDAO.create(kh7);
		KhachHang kh8 = new KhachHang("Văn Dũng", "0122334556", "Bình Dương");
		kh8 = khachHangDAO.create(kh8);
		KhachHang kh9 = new KhachHang("Hoàng Minh", "0122344556", "Quảng Ngãi");
		kh9 = khachHangDAO.create(kh9);
		KhachHang kh10 = new KhachHang("Thanh An", "0956774833", "Ninh Bình");
		kh10 = khachHangDAO.create(kh10);
		KhachHang kh11 = new KhachHang("Thúy Hồng", "0987332211", "Long An");
		kh11 = khachHangDAO.create(kh11);
		KhachHang kh12 = new KhachHang("Thúy Kiều", "0854332223", "TP Hồ Chí Minh");
		kh12 = khachHangDAO.create(kh12);
		KhachHang kh13 = new KhachHang("Hữu Nghĩa", "0922345772", "TP Hồ Chí Minh");
		kh13 = khachHangDAO.create(kh13);
		KhachHang kh14 = new KhachHang("Thị Linh", "0898432212", "Hà Nội");
		kh14 = khachHangDAO.create(kh14);
		KhachHang kh15 = new KhachHang("Minh Quân", "0905332234", "Bình Thuận");
		kh15 = khachHangDAO.create(kh15);
		KhachHang kh16 = new KhachHang("Gia Bảo", "0909876633", "TP Hồ Chí Minh");
		kh16 = khachHangDAO.create(kh16);
		KhachHang kh17 = new KhachHang("Thanh Thúy", "0987332212", "Ninh Bình");
		kh17 = khachHangDAO.create(kh17);
		KhachHang kh18 = new KhachHang("Hồng Quyên", "0973328332", "Hà Nội");
		kh18 = khachHangDAO.create(kh18);
		KhachHang kh19 = new KhachHang("Văn Mỹ", "0922111223", "TP Hồ Chí Minh");
		kh19 = khachHangDAO.create(kh19);
		KhachHang kh20 = new KhachHang("Thanh Quý", "0121653445", "Hà Nội");
		kh20 = khachHangDAO.create(kh20);
		KhachHang kh21 = new KhachHang("Hạ Vũ", "0741258963", "Cà Mau");
		kh21 = khachHangDAO.create(kh21);
		KhachHang kh22 = new KhachHang("Quyết Chiến", "0443922212", "TP Hồ Chí Minh");
		kh22 = khachHangDAO.create(kh22);
		KhachHang kh23 = new KhachHang("Thành Hưng", "0933457543", "Quảng Ngãi");
		kh23 = khachHangDAO.create(kh23);
		KhachHang kh24 = new KhachHang("Mỹ Hoa", "0892223847", "Long An");
		kh24 = khachHangDAO.create(kh24);
		KhachHang kh25 = new KhachHang("Hồng Thiên", "0922333455", "Sóc Trăng");
		kh25 = khachHangDAO.create(kh25);
		KhachHang kh26 = new KhachHang("Quốc Khánh", "0989333446", "TP Hồ Chí Minh");
		kh26 = khachHangDAO.create(kh26);
		KhachHang kh27 = new KhachHang("Thanh Phú", "0989333464", "Hà Nội");
		kh27 = khachHangDAO.create(kh27);
		KhachHang kh28 = new KhachHang("Quý Phước", "0989333746", "Quảng Bình");
		kh28 = khachHangDAO.create(kh28);

		ITuaDeDAO tuaDeDAO = new TuaDeDAO();
		TuaDe tuaDe1 = new TuaDe("Chiến tranh giữa các vì sao");
		tuaDe1 = tuaDeDAO.create(tuaDe1);
		TuaDe tuaDe2 = new TuaDe("Pokemon");
		tuaDe2 = tuaDeDAO.create(tuaDe2);
		TuaDe tuaDe3 = new TuaDe("Du Hành Giữa các Vì Sao");
		tuaDe3 = tuaDeDAO.create(tuaDe3);
		TuaDe tuaDe4 = new TuaDe("Liên Minh Huyền Diệu");
		tuaDe4 = tuaDeDAO.create(tuaDe4);
		TuaDe tuaDe5 = new TuaDe("Transformer");
		tuaDeDAO.create(tuaDe5);
		TuaDe tuaDe6 = new TuaDe("Siêu nhân GAO");
		tuaDeDAO.create(tuaDe6);
		TuaDe tuaDe7 = new TuaDe("Tom and Jerry");
		tuaDeDAO.create(tuaDe7);
		TuaDe tuaDe8 = new TuaDe("Cuộc chiến sống còn");
		tuaDeDAO.create(tuaDe8);
		TuaDe tuaDe9 = new TuaDe("Người cha báo thù");
		tuaDeDAO.create(tuaDe9);
		TuaDe tuaDe10 = new TuaDe("Gia đình hạnh phúc");
		tuaDeDAO.create(tuaDe10);

		ILoaiDiaDAO loaiDiaDAO = new LoaiDiaDAO();
		LoaiDia l1 = new LoaiDia(TenLoaiDia.DVD, 100, 10, 10);
		l1 = loaiDiaDAO.create(l1);
		LoaiDia l2 = new LoaiDia(TenLoaiDia.GAME, 150, 15, 15);
		l2 = loaiDiaDAO.create(l2);

		IDiaDAO diaDAO = new DiaDAO();
		Dia dia1 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l1);
		dia1 = diaDAO.create(dia1);
		Dia dia2 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l2);
		dia2 = diaDAO.create(dia2);
		Dia dia3 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l2);
		dia3 = diaDAO.create(dia3);
		Dia dia4 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l1);
		dia4 = diaDAO.create(dia4);
		Dia dia5 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l2);
		dia5 = diaDAO.create(dia5);
		Dia dia6 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l1);
		dia6 = diaDAO.create(dia6);
		Dia dia7 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l1);
		dia7 = diaDAO.create(dia7);
		Dia dia8 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe3, l1);
		dia8 = diaDAO.create(dia8);
		Dia dia9 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe4, l2);
		dia9 = diaDAO.create(dia9);
		Dia dia10 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe5, l1);
		dia10 = diaDAO.create(dia10);
		Dia dia11 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l1);
		dia11 = diaDAO.create(dia11);
		Dia dia12 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l2);
		dia12 = diaDAO.create(dia12);
		Dia dia13 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l2);
		dia13 = diaDAO.create(dia13);
		Dia dia14 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l1);
		dia14 = diaDAO.create(dia14);
		Dia dia15 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l2);
		dia15 = diaDAO.create(dia15);
		Dia dia16 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l1);
		dia16 = diaDAO.create(dia16);
		Dia dia17 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l1);
		dia17 = diaDAO.create(dia17);
		Dia dia18 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe3, l1);
		dia18 = diaDAO.create(dia18);
		Dia dia19 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe4, l2);
		dia19 = diaDAO.create(dia19);
		Dia dia20 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe5, l1);
		dia20 = diaDAO.create(dia20);
		Dia dia21 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l1);
		dia21 = diaDAO.create(dia21);
		Dia dia22 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l2);
		dia22 = diaDAO.create(dia22);
		Dia dia23 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l2);
		dia23 = diaDAO.create(dia23);
		Dia dia24 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l1);
		dia24 = diaDAO.create(dia24);
		Dia dia25 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l2);
		dia25 = diaDAO.create(dia25);
		Dia dia26 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l1);
		dia26 = diaDAO.create(dia26);
		Dia dia27 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l1);
		dia27 = diaDAO.create(dia27);
		Dia dia28 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe3, l1);
		dia28 = diaDAO.create(dia28);
		Dia dia29 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe4, l2);
		dia29 = diaDAO.create(dia29);
		Dia dia30 = new Dia(TrangThaiDia.ON_SHEFT, tuaDe5, l1);
		dia30 = diaDAO.create(dia30);

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

		ITaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
		TaiKhoan tk1 = new TaiKhoan("admin", "123456");
		taiKhoanDAO.create(tk1);
	}

}
