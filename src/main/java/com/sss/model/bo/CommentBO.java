package com.sss.model.bo;

import com.sss.data.entity.Comment;

public class CommentBO {

	private Comment m_Comment;

	public CommentBO(Comment comment) {
		this.m_Comment = comment;
	}

	public Long getId() {
		return m_Comment.getId();
	}
	
	public String getContent() {
		return m_Comment.getContent();
	}
}
