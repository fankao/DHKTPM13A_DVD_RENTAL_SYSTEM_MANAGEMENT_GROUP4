package com.group4.test;

import java.time.LocalDate;
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
		diaDAO.create(new Dia(TrangThaiDia.ON_SHEFT, tuaDe1, l1));
		diaDAO.create(new Dia(TrangThaiDia.ON_SHEFT, tuaDe2, l2));

		ThueTraDiaBUS thueTraDiaBUS = new ThueTraDiaBUS();
		thueTraDiaBUS.xuLyThueDia(khachHangDAO.findById(1L), new HashSet<Dia>(diaDAO.findAll()));

		IChiTietThueTraDAO chiTietThueTraDAO = new ChiTietThueTraDAO();
		ChiTietThueTra chiTietThueTra1 = chiTietThueTraDAO.findById(new ChiTietThueTraID(1L, 1L));
		chiTietThueTra1.setNgayTra(LocalDate.of(2020, 12, 10));
		
		ChiTietThueTra chiTietThueTra2 = chiTietThueTraDAO.findById(new ChiTietThueTraID(1L, 2L));
		chiTietThueTra2.setNgayTra(LocalDate.of(2020, 12, 20));
		
		chiTietThueTraDAO.update(chiTietThueTra1);
		chiTietThueTraDAO.update(chiTietThueTra2);
	}

}
