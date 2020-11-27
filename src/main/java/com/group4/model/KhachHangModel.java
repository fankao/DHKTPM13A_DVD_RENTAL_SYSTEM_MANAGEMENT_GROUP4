package com.group4.model;

import com.group4.entities.KhachHang;

public class KhachHangModel {
	
	private KhachHangModel() {
		// TODO Auto-generated constructor stub
	}
	
	public static KhachHang getKhachHangWithId(Long id) {
		return new KhachHang(id);
	}

}
