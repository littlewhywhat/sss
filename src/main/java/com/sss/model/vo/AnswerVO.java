package com.sss.model.vo;

/**
 * View Object class.
 * Definition of fields of Answer entity that should be filled by user.
 * 
 * @author vaivorom
 *
 */
public class AnswerVO {
	/**
	 * Member variable that stores content
	 */
	private String content;
	/**
	 * setter for content
	 * @param content value of content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * getter for content
	 * @return value of content
	 */
	public String getContent() {
		return content;
	}
}
