package com.group4.dao;

import java.util.List;

import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.TrangThaiDia;

public interface IDiaDAO extends IGenericDAO<Dia, Long> {
	
	boolean checkDiaCoTrenKe(Long diaId);

	List<Dia> getDSDiaTheoTrangThai(TrangThaiDia trangthai);
}
