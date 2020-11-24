package com.group4.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group4.dao.IChiTietDatGiuDAO;
import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.IDiaDAO;
import com.group4.dao.IKhachHangDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.TrangThaiDia;

class ChiTietThueTraDAOTest {
	IChiTietThueTraDAO dao;
	IDiaDAO diaDAO;
	IKhachHangDAO khachHangDAO;
	
	@BeforeEach
	void setUp() throws Exception {
		dao = new ChiTietThueTraDAO();
		diaDAO = new DiaDAO();
		khachHangDAO = new KhachHangDAO();
	}

	@Test
	void testCreate() {
		ChiTietThueTra chiTietThueTra = new ChiTietThueTra();
		chiTietThueTra.thueDia(khachHangDAO.findById(1L),diaDAO.findById(1L));
		
		dao.create(chiTietThueTra);
		
		assertEquals(1, dao.findAll().size());
		
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

}
