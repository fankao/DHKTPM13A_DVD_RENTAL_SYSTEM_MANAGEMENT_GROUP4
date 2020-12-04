package com.group4.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class ChiTietDatGiu {
	@EmbeddedId
	private ChiTietDatGiuID id = new ChiTietDatGiuID();

	@ManyToOne(cascade = {CascadeType.MERGE},fetch = FetchType.LAZY)
	@MapsId("khachHangId")
	@JoinColumn(name = "khachHangId")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("tuaDeId")
	@JoinColumn(name = "tuaDeId")
	private TuaDe tuaDe;

	@CreationTimestamp
	private LocalDateTime ngayDat;

	private boolean daGanDia;

	public ChiTietDatGiu() {
		super();
	}

	public ChiTietDatGiu(ChiTietDatGiuID id) {
		super();
		this.id = id;
	}

	public ChiTietDatGiuID getId() {
		return id;
	}

	public void setId(ChiTietDatGiuID id) {
		this.id = id;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public TuaDe getTuaDe() {
		return tuaDe;
	}

	public void setTuaDe(TuaDe tuaDe) {
		this.tuaDe = tuaDe;
	}

	public boolean isDaGanDia() {
		return daGanDia;
	}

	public void setDaGanDia(boolean daGanDia) {
		this.daGanDia = daGanDia;
	}

	public LocalDateTime getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(LocalDateTime ngayDat) {
		this.ngayDat = ngayDat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ChiTietDatGiu other = (ChiTietDatGiu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void datGiuDia(KhachHang kh, TuaDe tuaDe) {
		this.setKhachHang(kh);
		this.setTuaDe(tuaDe);
	}

}
