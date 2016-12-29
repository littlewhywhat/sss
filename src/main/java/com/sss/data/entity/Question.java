package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	private Long id;
    private String title;
    private String content;
    
    @OneToOne @MapsId
    private Commentable commentable;
    
    public Long getId() {
    	return id;
    }
    public Question setId(Long id) {
    	this.id = id;
    	return this;
    }
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
	public Question setCommentable(Commentable commentable) {
		this.commentable = commentable;
		return this;
	}
}
