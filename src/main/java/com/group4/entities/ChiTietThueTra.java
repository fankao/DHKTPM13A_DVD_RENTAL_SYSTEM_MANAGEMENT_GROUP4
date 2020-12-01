package com.group4.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;

import org.hibernate.annotations.CreationTimestamp;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

@Entity
public class ChiTietThueTra {
	@EmbeddedId
	private ChiTietThueTraID id = new ChiTietThueTraID();

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("khachHangId")
	@JoinColumn(name = "khachHangId")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("diaId")
	@JoinColumn(name = "diaId")
	private Dia dia;

	@Column(insertable = true,updatable = false)
	private LocalDate ngayThue;

	@Column(insertable = true,updatable = false)
	private LocalDate ngayToiHan;

	private LocalDate ngayTra;

	private double phiThueHienTai;

	private boolean daThanhToanPhiTreHan;

	public ChiTietThueTra() {
	}

	public ChiTietThueTra(ChiTietThueTraID id, KhachHang khachHang, Dia dia, LocalDate ngayThue, LocalDate ngayTra) {
		super();
		this.id = id;
		this.khachHang = khachHang;
		this.dia = dia;
		this.ngayThue = ngayThue;
		this.ngayTra = ngayTra;
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

	public boolean isDaThanhToanPhiTreHan() {
		return daThanhToanPhiTreHan;
	}

	public void setDaThanhToanPhiTreHan(boolean daThanhToanPhiTreHan) {
		this.daThanhToanPhiTreHan = daThanhToanPhiTreHan;
	}

	public LocalDate getNgayToiHan() {
		return ngayToiHan;
	}

	public void setNgayToiHan(LocalDate ngayToiHan) {
		this.ngayToiHan = ngayToiHan;
	}

	public double getPhiThueHienTai() {
		return phiThueHienTai;
	}

	public void setPhiThueHienTai(double phiThueHienTai) {
		this.phiThueHienTai = phiThueHienTai;
	}

	public void thueDia(KhachHang khachHang, Dia diaThue) {
		this.setKhachHang(khachHang);
		diaThue.setTrangThai(TrangThaiDia.RENTED);
		this.setDia(diaThue);
	}

	public void traDia(KhachHang khachHang, Dia diaTra,LocalDate ngaytra) {
//		this.setKhachHang(khachHang);
		diaTra.setTrangThai(TrangThaiDia.ON_SHEFT);
//		this.setDia(diaTra);
		this.setNgayTra(ngaytra);
	}
	
	public LocalDate ngayTraDuKien() {
		return ngayThue.plusDays(dia.getLoaiDia().getSoNgayThue());
	}

	@PrePersist
	public void prePersist() {
		this.setNgayThue(LocalDate.now());
		this.setNgayToiHan(ngayTraDuKien());
		this.setPhiThueHienTai(dia.getPhiThue());
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
		ChiTietThueTra other = (ChiTietThueTra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChiTietThueTra [id=" + id + ", ngayThue=" + ngayThue + ", ngayTra=" + ngayTra + "]";
	}

}
