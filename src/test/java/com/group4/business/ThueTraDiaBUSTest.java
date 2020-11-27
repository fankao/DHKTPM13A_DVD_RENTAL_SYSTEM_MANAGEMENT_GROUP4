package com.group4.business;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group4.dao.IDiaDAO;
import com.group4.dao.IKhachHangDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.Dia;
import com.group4.test.Testing;

/**
 * @author NMC
 *
 */
class ThueTraDiaBUSTest {
	private ThueTraDiaBUS thueTraDiaBUS;
	private IKhachHangDAO khachHangDAO;
	private IDiaDAO diaDAO;
	
	@BeforeEach
	void setUp() throws Exception {
		Testing.main();
		
		thueTraDiaBUS = new ThueTraDiaBUS();
		khachHangDAO = new KhachHangDAO();
		diaDAO = new DiaDAO();
	}

	@Test
	void testXuLyThueDia() {
		Set<Dia> dsDiaThue = new HashSet<Dia>();
		dsDiaThue.add(diaDAO.findById(1L));
		dsDiaThue.add(diaDAO.findById(2L));
		
		assertTrue(thueTraDiaBUS.xuLyThueDia(khachHangDAO.findById(1L), dsDiaThue));
	}

}
