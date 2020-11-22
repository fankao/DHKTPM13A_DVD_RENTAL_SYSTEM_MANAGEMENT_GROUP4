package com.group4.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LoaiDia implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long Id;
	private String tenLoaiDia;
	private double phiThue;
	private double phiTreHan;
	private int soNgayThue;
	
	@OneToMany(mappedBy = "loaiDia",fetch =  FetchType.LAZY, orphanRemoval = true)
	private Set<Dia> dsDia = new HashSet<Dia>();

	public LoaiDia() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTenLoaiDia() {
		return tenLoaiDia;
	}

	public void setTenLoaiDia(String tenLoaiDia) {
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
		LoaiDia other = (LoaiDia) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
	
}
