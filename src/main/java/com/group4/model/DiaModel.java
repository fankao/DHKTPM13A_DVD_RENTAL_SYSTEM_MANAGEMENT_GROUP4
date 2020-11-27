package com.group4.model;

import com.group4.entities.Dia;

public class DiaModel {
	private DiaModel() {
		// TODO Auto-generated constructor stub
	}
	
	public static Dia getDiaWithId(Long id) {
		return new Dia(id);
	}
}
