package com.sss.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@ManyToMany
	private List<Question> questions;
	public Task setQuestions(List<Question> questions) {
		this.questions = questions;
		return this;
	}
	public Task setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getTitle() {
		return this.title;
	}
	public List<Question> getQuestions() {
		return this.questions;
	}
	public Task setId(Long id) {
		this.id = id;
		return this;
	}
	public Long getId() {
		return this.id;
	}
}
