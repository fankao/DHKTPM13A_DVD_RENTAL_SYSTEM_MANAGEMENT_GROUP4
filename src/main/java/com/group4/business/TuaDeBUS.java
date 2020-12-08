package com.group4.business;

import static com.group4.Injection.chiTietDatGiuDAO;
import static com.group4.Injection.diaDAO;
import static com.group4.Injection.tuaDeDAO;

import java.util.List;
import java.util.stream.Collectors;

import com.group4.entities.TuaDe;

public class TuaDeBUS {
	/**
	 * Xóa tựa đề
	 * 
	 * @param tuaDe: Tựa đề cần xóa
	 * @return true: nếu xóa tựa đề thành công/ false: nếu tựa đề có trong đĩa, đang
	 *         được đặt giữ
	 */

	public boolean xoaTuaDe(TuaDe tuaDe) {
		if (tuaDeCoDia(tuaDe.getId()) == true || tuaDeDaDatGiu(tuaDe.getId()) == true) {
			return false;
		}
		return tuaDeDAO.delete(tuaDe);
	}

	public boolean tuaDeCoDia(Long tuaDeId) {
		return diaDAO.findAll().stream().filter(x -> x.getTuaDe().getId() == tuaDeId).count() > 0;
	}

	public boolean tuaDeDaDatGiu(Long tuaDeId) {
		return chiTietDatGiuDAO.findAll().stream().filter(x -> x.getTuaDe().getId() == tuaDeId).count() > 0;
	}

	public List<TuaDe> timKiemTuaDe(String tenTuaDe) {
		return tuaDeDAO.findAll().stream().filter(x -> x.getTenTuaDe().trim().toLowerCase().contains(tenTuaDe))
				.collect(Collectors.toList());

	}

}
