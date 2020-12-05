package com.group4.dao;

import java.util.List;

import com.group4.entities.ChiTietDatGiu;
import com.group4.entities.ChiTietDatGiuID;
import com.group4.entities.TuaDe;

public interface IChiTietDatGiuDAO extends IGenericDAO<ChiTietDatGiu, ChiTietDatGiuID>{
	List<TuaDe> getDSTuaDeMaKhacHangChuaDat(Long khachHangId);
	List<ChiTietDatGiu> getDSDatBanSaoTheoKH(Long khachHangId);
}
