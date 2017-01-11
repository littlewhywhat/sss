package com.sss.model.bo;

import com.sss.data.entity.Answer;

/**
 * Business Object Class (Wrapper)
 * Definition of fields in Answer entity that will be converted in JSON format.
 * 
 * @author vaivorom
 *
 */
public class AnswerBO {
	/**
	 * Member variable that stores corresponding Answer's instance
	 */
	private Answer answer;
	/**
	 * Constructor using Answer's instance
	 * @param answer Answer's instance to wrap up
	 */
	public AnswerBO(Answer answer) {
		this.answer = answer;
	}
	/**
	 * getter for id
	 * @return
	 */
	public Long getId() {
		return this.answer.getId();
	}
	/**
	 * getter for content
	 * @return
	 */
	public String getContent() {
		return this.answer.getContent();
	}
}
