package com.sss.model.vo;

import java.util.List;

/**
 * View Object class.
 * Definition of fields of Task entity that should be filled by user.
 * 
 * @author vaivorom
 *
 */
public class TaskVO {
	/**
	 * Member variable that stores title
	 */
	private String title;
	/**
	 * Member variable that stores ids of questions that are included in the task
	 */
	private List<Long> questionIds;
	/**
	 * getter for title
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * getter for questionIds
	 * @return
	 */
	public List<Long> getQuestionIds() {
		return questionIds;
	}
	/**
	 * setter for title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * setter for questionIds
	 * @param questionIds
	 */
	public void setQuestionIds(List<Long> questionIds) {
		this.questionIds = questionIds;
	}
}
