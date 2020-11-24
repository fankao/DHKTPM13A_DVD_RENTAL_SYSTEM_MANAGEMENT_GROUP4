package com.group4.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class ChiTietThueTra implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChiTietThueTraID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("khachHangId")
	@JoinColumn(name = "khachHangId")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("diaId")
	@JoinColumn(name = "diaId")
	private Dia dia;

	@CreationTimestamp
	private LocalDate ngayThue;

	private LocalDate ngayTra;

	public ChiTietThueTra() {
		super();
	}

	public ChiTietThueTraID getId() {
		return id;
	}

	public void setId(ChiTietThueTraID id) {
		this.id = id;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public LocalDate getNgayThue() {
		return ngayThue;
	}

	public void setNgayThue(LocalDate ngayThue) {
		this.ngayThue = ngayThue;
	}

	public LocalDate getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(LocalDate ngayTra) {
		this.ngayTra = ngayTra;
	}

	public void thueDia(KhachHang khachHang, Dia dia) {
		this.setKhachHang(khachHang);
		this.setDia(dia);
	}

	@Override
	public String toString() {
		return "ChiTietThueTra [id=" + id + ", ngayThue=" + ngayThue + ", ngayTra=" + ngayTra + "]";
	}

}
