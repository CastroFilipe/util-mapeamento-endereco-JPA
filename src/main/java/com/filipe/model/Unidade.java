package com.filipe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Uma Unidade de uma Loja
 */
@Entity
@Table(name = "UNIDADE", uniqueConstraints = { @UniqueConstraint(columnNames = "ID_UNIDADE", name = "UK_ID_UNIDADE") })
@SequenceGenerator(name = "SEQ_UNIDADE", sequenceName = "SQ_UNIDADE", initialValue = 1, allocationSize = 1)
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_UNIDADE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UNIDADE")
	private Long id;

	@Column(name = "NO_UNIDADE")
	private String noUnidade;

	@Column(name = "CD_UNIDADE")
	private String cdUnidade;

	@OneToOne
	@JoinColumn(name = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_UNIDADE_ENDERECO"))
	private Endereco endereco;

	public Unidade() {
		super();
	}

	public Unidade(Long id, String noUnidade, String cdUnidade, Endereco endereco) {
		super();
		this.id = id;
		this.noUnidade = noUnidade;
		this.cdUnidade = cdUnidade;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoUnidade() {
		return noUnidade;
	}

	public void setNoUnidade(String noUnidade) {
		this.noUnidade = noUnidade;
	}

	public String getCdUnidade() {
		return cdUnidade;
	}

	public void setCdUnidade(String cdUnidade) {
		this.cdUnidade = cdUnidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
