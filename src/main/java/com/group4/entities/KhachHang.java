package com.group4.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "NVARCHAR(255)")
	private String hoVaTen;
	
	private String soDienThoai;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String diaChi;

	@OneToMany(mappedBy = "khachHang")
	private Set<ChiTietThueTra> dsChiTietThueTra = new HashSet<ChiTietThueTra>();

	@OneToMany(mappedBy = "khachHang")
	private Set<ChiTietDatGiu> dsChiTietDatGiu = new HashSet<ChiTietDatGiu>();

	public KhachHang() {
		super();
	}


	public KhachHang(Long id) {
		super();
		this.id = id;
	}



	public KhachHang(String hoVaTen, String soDienThoai, String diaChi) {
		super();
		this.hoVaTen = hoVaTen;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}



	public KhachHang(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		KhachHang other = (KhachHang) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
