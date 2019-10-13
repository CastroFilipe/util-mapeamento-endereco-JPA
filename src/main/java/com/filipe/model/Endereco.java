package com.filipe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.filipe.model.enums.UF;

@Entity
@Table(name = "ENDERECO", uniqueConstraints = @UniqueConstraint(columnNames = "ID_ENDERECO", name = "UK_ID_ENDERECO"))
@SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SQ_ENDERECO", initialValue = 1, allocationSize = 1)
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ENDERECO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
	private Long id;

	@Column(name = "NO_LOGRADOURO")
	private String noLogradouro;

	@Column(name = "NU_NUMERO")
	private String nuNumero;

	@Column(name = "EN_UF")
	private UF uf;

//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name= "ID_OBJ_COM_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO_OBJCOMENDERECO"))
//	private ObjComEndereco objComEndereco;

	public Endereco() {
	}

	public Endereco(Long id, String noLogradouro, String nuNumero, UF uf) {
		super();
		this.id = id;
		this.noLogradouro = noLogradouro;
		this.nuNumero = nuNumero;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoLogradouro() {
		return noLogradouro;
	}

	public void setNoLogradouro(String noLogradouro) {
		this.noLogradouro = noLogradouro;
	}

	public String getNuNumero() {
		return nuNumero;
	}

	public void setNuNumero(String nuNumero) {
		this.nuNumero = nuNumero;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}
}
