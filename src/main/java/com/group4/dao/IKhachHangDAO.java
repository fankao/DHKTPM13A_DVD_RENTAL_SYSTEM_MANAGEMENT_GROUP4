package com.group4.dao;

import com.group4.entities.KhachHang;

public interface IKhachHangDAO extends IGenericDAO<KhachHang, Long> {
	boolean khachHangDaThueDia(Long khachHangId);
	boolean khachHangDaDatDia(Long khachHangId);
}
