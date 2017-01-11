package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
/**
 * Question Entity class
 * @author vaivorom
 *
 */
@Entity
public class Question {
	/**
	 * Member that stores id. 
	 * Value copied from id of a corresponding instance of Commentable.
	 */
	@Id
	private Long id;
	/**
	 * Member that stores an question's title.
	 */
    private String title;
	/**
	 * Member that stores an question's content.
	 */
    private String content;
	/**
	 * Member that stores a corresponding instance of Commentable.
	 */
    @OneToOne @MapsId
    private Commentable commentable;
	/**
	 * getter for id
	 * @return
	 */
    public Long getId() {
    	return id;
    }
	/**
	 * fluent setter for id
	 * @param id
	 * @return
	 */
    public Question setId(Long id) {
    	this.id = id;
    	return this;
    }	
    /**
	 * getter for title
	 * @return
	 */
    public String getTitle() {
		return title;
	}
	/**
	 * fluent setter for title
	 * @param title
	 * @return
	 */
	public Question setTitle(String title) {
		this.title = title;
		return this;
	}
	/**
	 * getter for content
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * fluent setter for content
	 * @param content
	 * @return
	 */
	public Question setContent(String content) {
		this.content = content;
		return this;
	}
	/**
	 * fluent setter for commentable
	 * @param commentable
	 * @return
	 */
	public Question setCommentable(Commentable commentable) {
		this.commentable = commentable;
		return this;
	}
}
