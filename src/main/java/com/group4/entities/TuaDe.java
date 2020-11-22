package com.group4.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class TuaDe implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Long Id;

	private String tenTuaDe;

	@OneToMany(mappedBy = "tuaDe", fetch = FetchType.LAZY)
	private Set<Dia> dsDia = new HashSet<Dia>();
	
	@OneToMany(mappedBy = "tuaDe",fetch = FetchType.LAZY)
	private Set<ChiTietDatGiu> dsChiTietDatGiu = new HashSet<ChiTietDatGiu>();

	public TuaDe() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTenTuaDe() {
		return tenTuaDe;
	}

	public void setTenTuaDe(String tenTuaDe) {
		this.tenTuaDe = tenTuaDe;
	}

	public Set<Dia> getDsDia() {
		return dsDia;
	}

	public void setDsDia(Set<Dia> dsDia) {
		this.dsDia = dsDia;
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
		TuaDe other = (TuaDe) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TuaDe [Id=" + Id + ", tenTuaDe=" + tenTuaDe + "]";
	}

}
