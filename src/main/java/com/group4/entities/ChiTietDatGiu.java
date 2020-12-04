package com.group4.entities;

import java.time.LocalDateTime;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
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

	public void datGiuDia(KhachHang kh, TuaDe tuaDe) {
		this.setKhachHang(kh);
		this.setTuaDe(tuaDe);
		
	}
	
	
	
	

}
