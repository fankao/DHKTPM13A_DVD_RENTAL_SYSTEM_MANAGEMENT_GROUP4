package com.group4.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietThueTraID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "khachHangId")
	private Long khachHangId;

	@Column(name = "diaId")
	private Long diaId;

	public ChiTietThueTraID() {
		super();
	}

	public Long getKhachHangId() {
		return khachHangId;
	}

	public void setKhachHangId(Long khachHangId) {
		this.khachHangId = khachHangId;
	}

	public Long getDiaId() {
		return diaId;
	}

	public void setDiaId(Long diaId) {
		this.diaId = diaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaId == null) ? 0 : diaId.hashCode());
		result = prime * result + ((khachHangId == null) ? 0 : khachHangId.hashCode());
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
		ChiTietThueTraID other = (ChiTietThueTraID) obj;
		if (diaId == null) {
			if (other.diaId != null)
				return false;
		} else if (!diaId.equals(other.diaId))
			return false;
		if (khachHangId == null) {
			if (other.khachHangId != null)
				return false;
		} else if (!khachHangId.equals(other.khachHangId))
			return false;
		return true;
	}

}
