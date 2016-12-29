package com.sss.model.bo;

import com.sss.data.entity.Answer;

public class AnswerBO {
	private Answer answer;
	public AnswerBO(Answer answer) {
		this.answer = answer;
	}
	public String getContent() {
		return this.answer.getContent();
	}
}
