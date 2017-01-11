package com.sss.model.bo;

import java.util.ArrayList;
import java.util.List;

import com.sss.data.entity.Question;
import com.sss.data.entity.Task;

/**
 * Business Object Class (Wrapper)
 * Definition of fields in Task entity that will be converted in JSON format.
 * 
 * @author vaivorom
 *
 */
public class TaskBO {
	/**
	 * Member variable that stores corresponding Task's instance
	 */
	private Task m_Task;
	/**
	 * Member variable that stores list of Question ids that task contains
	 */
	private List<Long> m_QuestionIds;
	/**
	 * Constructor using Task's instance
	 * @param task Task's instance to wrap up
	 */
	public TaskBO(Task task) {
		this.m_Task = task;
		this.m_QuestionIds = new ArrayList<>();
		for (Question question : task.getQuestions())
			this.m_QuestionIds.add(question.getId());
	}
	/**
	 * getter for questionIds
	 * @return
	 */
	public List<Long> getQuestionIds() {
		return m_QuestionIds; 
	}
	/**
	 * getter for id
	 * @return
	 */
	public Long getId() {
		return m_Task.getId();
	}
	/**
	 * getter for title
	 * @return
	 */
	public String getTitle() {
		return m_Task.getTitle();
	}
}
