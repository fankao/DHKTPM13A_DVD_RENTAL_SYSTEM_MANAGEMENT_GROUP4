package com.group4.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ChiTietDatGiu {
	@EmbeddedId
	private ChiTietDatGiuID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("khachHangId")
	@JoinColumn(name = "khachHangId")
	private KhachHang khachHang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("tuaDeId")
	@JoinColumn(name = "tuaDeId")
	private TuaDe tuaDe;

	public ChiTietDatGiu() {
		super();
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
	
	

}
