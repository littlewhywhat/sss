package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 * Answer Entity class
 * @author vaivorom
 *
 */
@Entity
public class Answer {
	
	/**
	 * Member that stores id. 
	 * Value copied from id of a corresponding instance of Commentable.
	 */
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * Member that stores an answer's content.
	 */
	private String content;
	/**
	 * Member that stores a corresponding instance of Commentable.
	 */
	@OneToOne @MapsId
	private Commentable commentable;
	/**
	 * Member that stores a question that answer is referred to.
	 */
	@ManyToOne
	private Question question;
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
	public Answer setContent(String content) {
		this.content = content;
		return this;
	}
	/**
	 * fluent setter for question
	 * @param question Question to set in relation.
	 * @return
	 */
	public Answer setQuestion(Question question) {
		this.question = question;
		return this;
	}
	/**
	 * getter for id
	 * @return
	 */
	public Long getId() {
		return this.id;
	}
	/**
	 * fluent setter for Commentable
	 * @param commentable
	 * @return
	 */
	public Answer setCommentable(Commentable commentable) {
		this.commentable = commentable;
		return this;
	}
	/**
	 * fluent setter for id
	 * @param id
	 * @return
	 */
	public Answer setId(Long id) {
		this.id = id;
		return this;
	}
}
