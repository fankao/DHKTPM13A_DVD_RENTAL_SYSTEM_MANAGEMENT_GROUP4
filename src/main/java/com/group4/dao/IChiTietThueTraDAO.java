package com.group4.dao;

import java.util.List;

import com.group4.entities.ChiTietThueTra;
import com.group4.entities.ChiTietThueTraID;

public interface IChiTietThueTraDAO extends IGenericDAO<ChiTietThueTra, ChiTietThueTraID> {

	List<ChiTietThueTra> getDSDaTraDiaTheoKH(Long khId);
	List<ChiTietThueTra> getDSChuaTraDiaTheoDia(Long khId);

	int demSoDiaDaThue(Long id);

	
	ChiTietThueTra getmotCTTTChuaTraDiaTheoDia(Long diaID);
	
//	ChiTietThueTra getDSChuaTraDiaTheoDiavaKH(Long khId);
	
}
