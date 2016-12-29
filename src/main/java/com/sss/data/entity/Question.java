package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;
    private String title;
    private String content;
	public String getTitle() {
		return title;
	}
	public Question setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Question setContent(String content) {
		this.content = content;
		return this;
	}
	public Question setId(Long id) {
		this.id = id;
		return this;
	}
	public Long getId() {
		return id;
	}
}
