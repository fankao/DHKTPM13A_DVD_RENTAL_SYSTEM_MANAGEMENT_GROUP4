package com.group4.business;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.group4.dao.IDiaDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.test.TestingThanhToanPhiTreHan;

class DatTruocDiaBUSTest {
	private static DatTruocDiaBUS bus;
	private static IDiaDAO diaDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		TestingThanhToanPhiTreHan.main();
		bus = new DatTruocDiaBUS();
		diaDAO = new DiaDAO();
	}

	@Test
	void testLayChiTietDatGiuSomNhat() {
		assertNotNull(bus.layChiTietDatGiuSomNhat(diaDAO.findById(10L)));
	}

	@Test
	void testGanDia() {
		fail("Not yet implemented");
	}

}
