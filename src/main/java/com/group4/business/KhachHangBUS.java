package com.group4.business;

import com.group4.dao.IChiTietDatGiuDAO;
import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.IKhachHangDAO;
import com.group4.dao.impl.ChiTietDatGiuDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.dao.impl.KhachHangDAO;

public class KhachHangBUS {
	private static IKhachHangDAO khachHangDAO;
	private static IChiTietDatGiuDAO chiTietDatGiuDAO;
	private static IChiTietThueTraDAO chiTietThueTraDAO;
	static {
		khachHangDAO = new KhachHangDAO();
		chiTietDatGiuDAO = new ChiTietDatGiuDAO	();
		chiTietThueTraDAO = new ChiTietThueTraDAO();
	}
	
	

}
