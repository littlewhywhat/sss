package com.sss.model.bo;

import com.sss.data.entity.Question;

public class QuestionBO {
	private Question m_Question;
	public QuestionBO(Question question) {
		m_Question = question;
	}
	public Question getQuestion() {
		return m_Question;
	}
	
	public String getTitle() {
		return m_Question.getTitle();
	}
	
	public String getContent() {
		return m_Question.getContent();
	}
}
