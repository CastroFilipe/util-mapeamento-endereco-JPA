package com.filipe.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OlaMundo {
	
	@Id
	private Integer id;

	public OlaMundo() {
		super();
	}

	public OlaMundo(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
