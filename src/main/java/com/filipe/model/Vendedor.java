package com.filipe.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "VENDEDOR")
@SequenceGenerator(name = "SEQ_VENDEDOR", sequenceName = "SQ_VENDEDOR", initialValue = 1, allocationSize = 1)
public class Vendedor extends ObjComEndereco implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name = "ID_VENDEDOR")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VENDEDOR")
//	private Long id;
	
	@Column(name = "NO_NOME")
	private String noNome;
	
	@Column(name = "CD_MATRICULA")
	private String cdMatricula;

	public Vendedor() {
		super();
	}

//	public Vendedor(Long id, String noNome, String cdMatricula) {
//		super();
//		this.id = id;
//		this.noNome = noNome;
//		this.cdMatricula = cdMatricula;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getNoNome() {
		return noNome;
	}

	public void setNoNome(String noNome) {
		this.noNome = noNome;
	}

	public String getCdMatricula() {
		return cdMatricula;
	}

	public void setCdMatricula(String cdMatricula) {
		this.cdMatricula = cdMatricula;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!(obj instanceof Vendedor))
//			return false;
//		Vendedor other = (Vendedor) obj;
//		return id != null && Objects.equals(id, other.id);
//	}
	
}
