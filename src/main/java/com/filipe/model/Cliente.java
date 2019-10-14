package com.filipe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CLIENTE", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID_CLIENTE", name = "UK_ID_CLIENTE")})
@SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SQ_CLIENTE", initialValue = 1, allocationSize = 1)
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CLIENTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
	private Long id;
	
	@Column(name = "NO_NOME")
	private String noNome;
	
	@Column(name = "NO_SOBRENOME")
	private String noSobreNome;
	
	@Column(name = "COD_CPF")
	private String codCpf;
	
//	@ElementCollection
//	@CollectionTable(name="ENDERECO")
	/*
	 * uniqueConstraints = {
							@UniqueConstraint(columnNames = "ID_CLIENTE", name = "UK_ID_CLIENTE"),
							@UniqueConstraint(columnNames = "ID_ENDERECO", name = "UK_ID_ENDERECO")},
	 * */
	@OneToMany
	@JoinTable(
			name = "ENDERECO_CLIENTE", uniqueConstraints = {
					@UniqueConstraint(columnNames = "ID_ENDERECO", name = "UK_ID_ENDERECO")},
			joinColumns = @JoinColumn(name = "ID_CLIENTE",foreignKey = @ForeignKey(name = "FK_ENDERECO_CLIENTE")), 
			inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_CLIENTE_ENDERECO"))
			)
	private Set<Endereco> enderecos = new HashSet<>();
	
	public Cliente() {}
	
	public Cliente(Long id, String noNome, String noSobreNome, String codCpf) {
		super();
		this.id = id;
		this.noNome = noNome;
		this.noSobreNome = noSobreNome;
		this.codCpf = codCpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoNome() {
		return noNome;
	}

	public void setNoNome(String noNome) {
		this.noNome = noNome;
	}

	public String getNoSobreNome() {
		return noSobreNome;
	}

	public void setNoSobreNome(String noSobreNome) {
		this.noSobreNome = noSobreNome;
	}

	public String getCodCpf() {
		return codCpf;
	}

	public void setCodCpf(String codCpf) {
		this.codCpf = codCpf;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return id != null && Objects.equals(id, other.id);
	}
}
