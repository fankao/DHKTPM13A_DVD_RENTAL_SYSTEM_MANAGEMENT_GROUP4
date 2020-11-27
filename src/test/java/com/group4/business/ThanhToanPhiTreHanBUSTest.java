package com.group4.business;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.group4.entities.ChiTietThueTra;
import com.group4.test.TestingThanhToanPhiTreHan;

class ThanhToanPhiTreHanBUSTest {
	private static ThanhToanPhiTreHanBUS thanhToanPhiTreHanBUS;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		TestingThanhToanPhiTreHan.main();
		thanhToanPhiTreHanBUS = new ThanhToanPhiTreHanBUS();
		
	}

	@Test
	void testGhiNhanThanhToanPhiTreHan() {
		List<ChiTietThueTra> ds = thanhToanPhiTreHanBUS.getDSThueTraTraHanTheoKH(1L);
		assertTrue(thanhToanPhiTreHanBUS.ghiNhanThanhToanPhiTreHan(ds));
	}

}
