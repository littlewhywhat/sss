package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;
	private String content;
	
	@ManyToOne
	private Commentable commentable;

	public Comment setId(Long id) {
		this.id = id;
		return this;
	}
	
	public String getContent() {
		return content;
	}

	public Comment setContent(String content) {
		this.content = content;
		return this;
	}

	public Comment setCommentable(Commentable commentable) {
		this.commentable = commentable;
		return this;
	}

	public Long getId() {
		return this.id;
	}
}
