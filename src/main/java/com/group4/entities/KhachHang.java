package com.group4.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long Id;
	private String hoVaTen;
	private String soDienThoai;
	private String diaChi;

	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
	private Set<ChiTietThueTra> dsChiTietThueTra;

	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
	private Set<ChiTietDatGiu> dsChiTietDatGiu = new HashSet<ChiTietDatGiu>();

	public KhachHang() {
		super();
	}

	public KhachHang(Long id, String hoVaTen) {
		super();
		Id = id;
		this.hoVaTen = hoVaTen;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Set<ChiTietThueTra> getDsChiTietThueTra() {
		return dsChiTietThueTra;
	}

	public void setDsChiTietThueTra(Set<ChiTietThueTra> dsChiTietThueTra) {
		this.dsChiTietThueTra = dsChiTietThueTra;
	}
	
	

	public Set<ChiTietDatGiu> getDsChiTietDatGiu() {
		return dsChiTietDatGiu;
	}

	public void setDsChiTietDatGiu(Set<ChiTietDatGiu> dsChiTietDatGiu) {
		this.dsChiTietDatGiu = dsChiTietDatGiu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
