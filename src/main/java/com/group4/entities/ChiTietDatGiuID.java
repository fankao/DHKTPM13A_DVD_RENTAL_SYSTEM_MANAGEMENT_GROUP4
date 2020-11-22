package com.group4.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietDatGiuID implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "khachHangId")
	private Long khachHangId;
	
	@Column(name = "tuaDeId")
	private Long tuaDeId;

	public ChiTietDatGiuID() {
		super();
	}

	public Long getKhachHangId() {
		return khachHangId;
	}

	public void setKhachHangId(Long khachHangId) {
		this.khachHangId = khachHangId;
	}

	public Long getTuaDeId() {
		return tuaDeId;
	}

	public void setTuaDeId(Long tuaDeId) {
		this.tuaDeId = tuaDeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((khachHangId == null) ? 0 : khachHangId.hashCode());
		result = prime * result + ((tuaDeId == null) ? 0 : tuaDeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDatGiuID other = (ChiTietDatGiuID) obj;
		if (khachHangId == null) {
			if (other.khachHangId != null)
				return false;
		} else if (!khachHangId.equals(other.khachHangId))
			return false;
		if (tuaDeId == null) {
			if (other.tuaDeId != null)
				return false;
		} else if (!tuaDeId.equals(other.tuaDeId))
			return false;
		return true;
	}
	
	

}
