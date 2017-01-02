package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue
	private Long id;
	private String content;
	
	@OneToOne @MapsId
	private Commentable commentable;
	
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
	public Long getId() {
		return this.id;
	}
	public Answer setCommentable(Commentable commentable) {
		this.commentable = commentable;
		return this;
	}
	public Answer setId(Long id) {
		this.id = id;
		return this;
	}
}
