package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Comment Entity class
 * @author vaivorom
 *
 */
@Entity
public class Comment {
	/**
	 * Member that stores id. 
	 * Value generated by Spring Framework.
	 */
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * Member that stores a comment's content.
	 */
	private String content;
	/**
	 * Member that stores a commentable that comment is referred to.
	 */
	@ManyToOne
	private Commentable commentable;
	/**
	 * fluent setter for id
	 * @param id
	 * @return
	 */
	public Comment setId(Long id) {
		this.id = id;
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
	public Comment setContent(String content) {
		this.content = content;
		return this;
	}
	/**
	 * fluent setter for Commentable
	 * @param commentable
	 * @return
	 */
	public Comment setCommentable(Commentable commentable) {
		this.commentable = commentable;
		return this;
	}
	/**
	 * getter for id
	 * @return
	 */
	public Long getId() {
		return this.id;
	}
}
