package com.sss.model.bo;

import com.sss.data.entity.Comment;

/**
 * Business Object Class (Wrapper)
 * Definition of fields in Comment entity that will be converted in JSON format.
 * 
 * @author vaivorom
 *
 */
public class CommentBO {
	/**
	 * Member variable that stores corresponding Comment's instance
	 */
	private Comment m_Comment;
	/**
	 * Constructor using Comment's instance
	 * @param comment Comment's instance to wrap up
	 */
	public CommentBO(Comment comment) {
		this.m_Comment = comment;
	}
	/**
	 * getter for id
	 * @return
	 */
	public Long getId() {
		return m_Comment.getId();
	}
	/**
	 * getter for content
	 * @return
	 */
	public String getContent() {
		return m_Comment.getContent();
	}
}
