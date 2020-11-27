package com.group4.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class TuaDe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "NVARCHAR(500)")
	private String tenTuaDe;

	@OneToMany(mappedBy = "tuaDe", fetch = FetchType.LAZY)
	private Set<Dia> dsDia = new HashSet<Dia>();

	@OneToMany(mappedBy = "tuaDe")
	private Set<ChiTietDatGiu> dsChiTietDatGiu = new HashSet<ChiTietDatGiu>();

	public TuaDe() {
		super();
	}


	public TuaDe(String tenTuaDe) {
		super();
		this.tenTuaDe = tenTuaDe;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		TuaDe other = (TuaDe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TuaDe [id=" + id + ", tenTuaDe=" + tenTuaDe + "]";
	}

}
