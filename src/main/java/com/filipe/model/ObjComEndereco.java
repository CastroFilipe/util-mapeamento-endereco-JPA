package com.filipe.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * @Inheritance Anotação usada em uma super Classe. A anotação garante que qualquer subclasse
 * que herde de ObjComEndereco será salva no banco de dados de acordo com o tipo strategy.
 * Para @InheritanceType.JOINED cada uma das subclasses terão sua própria tabela no banco de dados. Essa é a estratégia mais adotada.
 * */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ObjComEndereco {
	
	@Id
	@Column(name = "ID_OBJ")
	private Long id;
	
	@OneToMany(mappedBy = "objComEndereco", cascade = CascadeType.ALL)
	private Set<Adress> enderecos = new HashSet<>();
	
	public ObjComEndereco() {
		super();
	}
	
	public ObjComEndereco(Set<Adress> enderecos) {
		super();
		this.enderecos = enderecos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Adress> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Adress> enderecos) {
		this.enderecos = enderecos;
	}
	
}
