package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Commentable {
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	public Commentable setId(Long id) {
		this.id = id;
		return this;
	}
}
