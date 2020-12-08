package com.group4;

import com.group4.business.BaoCaoTuaDeBUS;
import com.group4.business.DatTruocDiaBUS;
import com.group4.business.KhachHangBUS;
import com.group4.business.ThanhToanPhiTreHanBUS;
import com.group4.business.ThueTraDiaBUS;
import com.group4.business.TuaDeBUS;
import com.group4.dao.IChiTietDatGiuDAO;
import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.IDiaDAO;
import com.group4.dao.IKhachHangDAO;
import com.group4.dao.ILoaiDiaDAO;
import com.group4.dao.ITaiKhoanDAO;
import com.group4.dao.ITuaDeDAO;
import com.group4.dao.impl.ChiTietDatGiuDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.dao.impl.LoaiDiaDAO;
import com.group4.dao.impl.TaiKhoanDAO;
import com.group4.dao.impl.TuaDeDAO;

public class Injection {
	public static ThueTraDiaBUS thueTraDiaBUS;
	public static DatTruocDiaBUS datTruocDiaBUS;
	public static KhachHangBUS khachHangBUS;
	public static BaoCaoTuaDeBUS baoCaoTuaDeBUS;
	public static ThanhToanPhiTreHanBUS thanhToanPhiTreHanBUS;
	public static IDiaDAO diaDAO;
	public static ILoaiDiaDAO loaiDiaDAO;
	public static ITuaDeDAO tuaDeDAO;
	public static TuaDeBUS tuaDeBUS;
	public static IKhachHangDAO khachHangDAO;
	public static ITaiKhoanDAO taiKhoanDAO;
	public static IChiTietDatGiuDAO chiTietDatGiuDAO;
	public static IChiTietThueTraDAO chiTietThueTraDAO;

	public Injection() {
		thueTraDiaBUS = new ThueTraDiaBUS();
		datTruocDiaBUS = new DatTruocDiaBUS();
		khachHangBUS = new KhachHangBUS();
		baoCaoTuaDeBUS = new BaoCaoTuaDeBUS();
		thanhToanPhiTreHanBUS = new ThanhToanPhiTreHanBUS();
		diaDAO = new DiaDAO();
		loaiDiaDAO = new LoaiDiaDAO();
		tuaDeDAO = new TuaDeDAO();
		tuaDeBUS = new TuaDeBUS();
		khachHangDAO = new KhachHangDAO();
		taiKhoanDAO = new TaiKhoanDAO();
		chiTietDatGiuDAO = new ChiTietDatGiuDAO();
		chiTietThueTraDAO = new ChiTietThueTraDAO();
	}

}
