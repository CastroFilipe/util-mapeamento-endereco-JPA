package com.filipe.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.filipe.model.enums.UF;

/**
 * classe endereco utilizada pelas entidades Cliente e Unidade
 * */
@Entity
@Table(name = "ENDERECO", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID_ENDERECO", name = "UK_ID_ENDERECO") })
@SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SQ_ENDERECO", initialValue = 1, allocationSize = 1)
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ENDERECO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENDERECO")
	private Long id;

	@Column(name = "NO_RUA")
	private String rua;

	@Column(name = "NU_NUMERO")
	private String numero;

	@Column(name = "DS_COMPLEMENTO")
	private String complemento;

	@Column(name = "CD_CEP")
	private String cep;

	@Column(name = "NO_CIDADE")
	private String cidade;

	@Column(name = "NO_BAIRRO")
	private String bairro;

	@Column(name = "NO_PAIS")
	private String pais;

	@Column(name = "EN_ESTADO")
	@Enumerated(EnumType.STRING)
	private UF estado;
	
//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name= "ID_OBJ_COM_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO_OBJCOMENDERECO"))
//	private ObjComEndereco objComEndereco;

	public Endereco() {
	}

	public Endereco(Long id, String rua, String numero, String complemento, String cep, String cidade, String bairro,
			String pais, UF estado) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.pais = pais;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public UF getEstado() {
		return estado;
	}

	public void setEstado(UF estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Endereco))
			return false;
		Endereco other = (Endereco) obj;
		return id != null && Objects.equals(id, other.id);
	}

}
