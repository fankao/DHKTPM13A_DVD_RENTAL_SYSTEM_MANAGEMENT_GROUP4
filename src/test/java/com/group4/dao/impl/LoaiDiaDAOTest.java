package com.group4.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group4.dao.ILoaiDiaDAO;
import com.group4.entities.LoaiDia;

class LoaiDiaDAOTest {
	ILoaiDiaDAO loaiDiaDAO;

	@BeforeEach
	void setUp() throws Exception {
		loaiDiaDAO = new LoaiDiaDAO();
	}

	@Test
	void testCreate() {
		LoaiDia loaiDia = new LoaiDia();
		loaiDia.setId(1L);
		loaiDiaDAO.create(loaiDia);
		assertEquals(1, loaiDiaDAO.findAll().size());
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
