package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue
	private Long id;
	private String content;
	
	@ManyToOne
	private Question question;
	
	public String getContent() {
		return content;
	}
	public Answer setContent(String m_Content) {
		this.content = m_Content;
		return this;
	}
	public Answer setQuestion(Question question) {
		this.question = question;
		return this;
	}
}
