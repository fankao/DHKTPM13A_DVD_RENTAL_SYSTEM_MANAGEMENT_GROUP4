package com.group4.business;

import java.util.Set;

import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;

public class ThueTraDiaBUS {
	private static IChiTietThueTraDAO chiTietThueTraDAO;
	static {
		chiTietThueTraDAO = new ChiTietThueTraDAO();
	}

	public boolean xuLyThueDia(KhachHang khachHang, Set<Dia> dsDiaThue) {
		int check = 0;
		for (Dia dia : dsDiaThue) {
			ChiTietThueTra chiTietThueTra = new ChiTietThueTra();
			chiTietThueTra.thueDia(khachHang, dia);
			if(chiTietThueTraDAO.create(chiTietThueTra)!=null) {
				check++;
			}
			
		}
		return check > 0;

	}

	public boolean traDia() {
		return false;
	}

}
