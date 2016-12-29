package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue
	private Long m_Id;
	private String m_Content;
	
	@ManyToOne
	private Question question;
	
	public Answer() {}
	public Answer(String content, Long questionId) {
		m_Content = content;
		question = new Question();
		question.setId(questionId);
	}
	public String getContent() {
		return m_Content;
	}
	public void setContent(String m_Content) {
		this.m_Content = m_Content;
	}
}
