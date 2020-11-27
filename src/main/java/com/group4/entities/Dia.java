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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Dia")
public class Dia implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TrangThaiDia trangThai;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tuaDeId")
	private TuaDe tuaDe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loaiDiaId")
	private LoaiDia loaiDia;
	
	@OneToMany(mappedBy = "dia")
	private Set<ChiTietThueTra> dsChiTietThueTra = new HashSet<ChiTietThueTra>();

	public Dia() {
		super();
	}

	public Dia(Long id, TrangThaiDia trangThai) {
		super();
		this.id = id;
		this.trangThai = trangThai;
	}
	
	public Dia(TrangThaiDia trangThai, TuaDe tuaDe, LoaiDia loaiDia) {
		super();
		this.trangThai = trangThai;
		this.tuaDe = tuaDe;
		this.loaiDia = loaiDia;
	}

	public Dia(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Dia other = (Dia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
