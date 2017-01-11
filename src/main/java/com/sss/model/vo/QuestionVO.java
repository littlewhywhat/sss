package com.sss.model.vo;

/**
 * View Object class.
 * Definition of fields of Question entity that should be filled by user.
 * 
 * @author vaivorom
 *
 */
public class QuestionVO {
	/**
	 * Member variable that stores title
	 */
	private String title;
	/**
	 * Member variable that stores content
	 */
	private String content;
	/**
	 * getter for title
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * setter for title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * getter for content
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * setter for content
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
