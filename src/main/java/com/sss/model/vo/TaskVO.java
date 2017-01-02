package com.sss.model.vo;

import java.util.List;

public class TaskVO {
	private String m_Title;
	private List<Long> m_QuestionIds;
	
	public String getTitle() {
		return m_Title;
	}
	public List<Long> getQuestionIds() {
		return m_QuestionIds;
	}
	public void setTitle(String title) {
		this.m_Title = title;
	}
	public void setQuestionIds(List<Long> questionIds) {
		this.m_QuestionIds = questionIds;
	}
}
