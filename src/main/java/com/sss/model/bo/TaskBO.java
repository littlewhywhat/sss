package com.sss.model.bo;

import java.util.ArrayList;
import java.util.List;

import com.sss.data.entity.Question;
import com.sss.data.entity.Task;

public class TaskBO {
	private Task m_Task;
	private List<Long> m_QuestionIds;
	public TaskBO(Task task) {
		this.m_Task = task;
		this.m_QuestionIds = new ArrayList<>();
		for (Question question : task.getQuestions())
			this.m_QuestionIds.add(question.getId());
	}
	public List<Long> getQuestionIds() {
		return m_QuestionIds; 
	}
	public Long getId() {
		return m_Task.getId();
	}
	public String getTitle() {
		return m_Task.getTitle();
	}
}
