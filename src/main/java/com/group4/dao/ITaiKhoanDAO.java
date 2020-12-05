package com.group4.dao;

import com.group4.entities.TaiKhoan;

public interface ITaiKhoanDAO extends IGenericDAO<TaiKhoan, Long> {
	TaiKhoan dangNhap(String tenTaiKhoan,String password);

}
