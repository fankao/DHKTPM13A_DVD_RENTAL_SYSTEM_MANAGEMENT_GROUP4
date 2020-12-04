package com.group4.dao;

import com.group4.entities.Dia;

public interface IDiaDAO extends IGenericDAO<Dia, Long> {
	
	boolean checkDiaCoTrenKe(Long diaId);


}
