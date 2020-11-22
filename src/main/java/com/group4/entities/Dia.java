package com.group4.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Dia implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Long Id;

	@Enumerated(EnumType.STRING)
	private TrangThaiDia trangThai;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tuaDeId")
	private TuaDe tuaDe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loaiDiaId")
	private LoaiDia loaiDia;
	
	@OneToMany(mappedBy = "dia", fetch =  FetchType.LAZY)
	private Set<ChiTietThueTra> dsChiTietThueTra;

	public Dia() {
		super();
	}

	public Dia(Long id, TrangThaiDia trangThai) {
		super();
		Id = id;
		this.trangThai = trangThai;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public TrangThaiDia getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiDia trangThai) {
		this.trangThai = trangThai;
	}

	public TuaDe getTuaDe() {
		return tuaDe;
	}

	public void setTuaDe(TuaDe tuaDe) {
		this.tuaDe = tuaDe;
	}

	public LoaiDia getLoaiDia() {
		return loaiDia;
	}

	public void setLoaiDia(LoaiDia loaiDia) {
		this.loaiDia = loaiDia;
	}
	

	public Set<ChiTietThueTra> getDsChiTietThueTra() {
		return dsChiTietThueTra;
	}

	public void setDsChiTietThueTra(Set<ChiTietThueTra> dsChiTietThueTra) {
		this.dsChiTietThueTra = dsChiTietThueTra;
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
		Dia other = (Dia) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
