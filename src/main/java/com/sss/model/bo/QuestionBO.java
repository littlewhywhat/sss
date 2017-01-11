package com.sss.model.bo;

import com.sss.data.entity.Question;

/**
 * Business Object Class (Wrapper)
 * Definition of fields in Question entity that will be converted in JSON format.
 * 
 * @author vaivorom
 *
 */
public class QuestionBO {
	/**
	 * Member variable that stores corresponding Question's instance
	 */
	private Question m_Question;
	/**
	 * Constructor using Question's instance
	 * @param question Question's instance to wrap up
	 */
	public QuestionBO(Question question) {
		m_Question = question;
	}
	/**
	 * getter for id
	 * @return
	 */
	public Long getId() {
		return m_Question.getId();
	}
	/**
	 * getter for title
	 * @return
	 */
	public String getTitle() {
		return m_Question.getTitle();
	}
	/**
	 * getter for content
	 * @return
	 */
	public String getContent() {
		return m_Question.getContent();
	}
}
