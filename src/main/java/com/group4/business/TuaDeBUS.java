package com.group4.business;
import static com.group4.Injection.*;
import com.group4.dao.IChiTietDatGiuDAO;
import com.group4.dao.IDiaDAO;
import com.group4.dao.ITuaDeDAO;
import com.group4.dao.impl.ChiTietDatGiuDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.dao.impl.TuaDeDAO;
import com.group4.entities.TuaDe;

public class TuaDeBUS {
	/**
	 * Xóa tựa đề
	 * @param tuaDe: Tựa đề cần xóa
	 * @return true: nếu xóa tựa đề thành công/ false: nếu tựa đề có trong đĩa, đang được đặt giữ 
	 */
	
	public boolean xoaTuaDe(TuaDe tuaDe) {
		if(tuaDeCoDia(tuaDe.getId())==true || 
				tuaDeDaDatGiu(tuaDe.getId())==true) {
			return false;
		}
		return tuaDeDAO.delete(tuaDe);
	}
	
	public boolean tuaDeCoDia(Long tuaDeId) {
		return diaDAO.findAll().stream().
				filter(x -> x.getTuaDe().getId() == tuaDeId).count() > 0;
	}
	
	public boolean tuaDeDaDatGiu(Long tuaDeId) {
		return chiTietDatGiuDAO.findAll().stream()
				.filter(x -> x.getTuaDe().getId() == tuaDeId).count() > 0;
	}
	
	
}
