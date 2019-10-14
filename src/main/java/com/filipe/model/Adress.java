package com.filipe.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.filipe.model.enums.UF;

/**
 * uma outra classe endereco para utilizar o mapeamento em conjunto com herança no ObjComEndereco
 * */
@Entity
@Table(name = "ADRESS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID_ADRESS", name = "UK_ID_ADRESS") })
@SequenceGenerator(name = "SEQ_ADRESS", sequenceName = "SQ_ADRESS", initialValue = 1, allocationSize = 1)
public class Adress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ADRESS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADRESS")
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
	@ManyToOne
	@JoinColumn(name= "ID_OBJ_COM_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO_OBJCOMENDERECO"))
	private ObjComEndereco objComEndereco;

	public Adress() {
	}

	public Adress(Long id, String rua, String numero, String complemento, String cep, String cidade, String bairro,
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
		if (!(obj instanceof Adress))
			return false;
		Adress other = (Adress) obj;
		return id != null && Objects.equals(id, other.id);
	}

}
