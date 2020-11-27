package com.group4.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LoaiDia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TenLoaiDia tenLoaiDia;

	private double phiThue;

	private double phiTreHan;

	private int soNgayThue;

	@OneToMany(mappedBy = "loaiDia", orphanRemoval = true)
	private Set<Dia> dsDia = new HashSet<Dia>();

	public LoaiDia() {
		super();
	}

	public LoaiDia(TenLoaiDia tenLoaiDia, double phiThue, double phiTreHan, int soNgayThue) {
		super();
		this.tenLoaiDia = tenLoaiDia;
		this.phiThue = phiThue;
		this.phiTreHan = phiTreHan;
		this.soNgayThue = soNgayThue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TenLoaiDia getTenLoaiDia() {
		return tenLoaiDia;
	}

	public void setTenLoaiDia(TenLoaiDia tenLoaiDia) {
		this.tenLoaiDia = tenLoaiDia;
	}

	public double getPhiThue() {
		return phiThue;
	}

	public void setPhiThue(double phiThue) {
		this.phiThue = phiThue;
	}

	public double getPhiTreHan() {
		return phiTreHan;
	}

	public void setPhiTreHan(double phiTreHan) {
		this.phiTreHan = phiTreHan;
	}

	public int getSoNgayThue() {
		return soNgayThue;
	}

	public void setSoNgayThue(int soNgayThue) {
		this.soNgayThue = soNgayThue;
	}

	public Set<Dia> getDsDia() {
		return dsDia;
	}

	public void setDsDia(Set<Dia> dsDia) {
		this.dsDia = dsDia;
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
		LoaiDia other = (LoaiDia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
