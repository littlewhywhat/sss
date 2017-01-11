package com.sss.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.data.ITasksRepository;
import com.sss.data.entity.Question;
import com.sss.data.entity.Task;
import com.sss.model.ITasksService;
import com.sss.model.bo.TaskBO;
import com.sss.model.vo.TaskVO;

/**
 * Service class.
 * Implementation of interface between presentation and model layer to perform operations on tasks.
 * Uses member variable that implements ITasksRepository
 * 
 * @author vaivorom
 *
 */
@Service
public class TasksService implements ITasksService {

	/**
	 * Member variable that implements ITasksRepository.
	 * Autowired by Spring Framework.
	 */
	@Autowired
	ITasksRepository m_Repository;
	
	/**
	 * This method constructs a Task object using data from 
	 * TaskVO instance.
	 * @param taskVO TaskVO instance with user's input data
	 * @return Task instance
	 */
	private Task vo2entity(TaskVO taskVO) {
		Task task = new Task()
				.setTitle(taskVO.getTitle());
		List<Question> questions = new ArrayList<>();
		for (Long id : taskVO.getQuestionIds())
			questions.add(new Question().setId(id));
		task.setQuestions(questions);
		return task;
	}
	
	/**
	 * This method returns all tasks
	 * It propagates request to data layer 
	 * using ITasksRepository method findAll.
	 * Then it wraps up each Task instance into TaskBO and collect them to List.
	 * @return List of TaskBO's instances
	 */
	@Override
	public List<TaskBO> all() {
		List<TaskBO> tasks = new ArrayList<>();
		for (Task task : m_Repository.findAll()) 
			tasks.add(new TaskBO(task));
		return tasks;
	}

	/**
	 * This method adds a new task.
	 * It first creates a Task instance using vo2entity. Then
	 * it propagates request to data layer using ITasksRepository method save.
	 * Returned from save Task instance is wrapped into TaskBO.
	 * @param taskVO TaskVO's instance with user's input data
	 * @return TaskBO's instance for a new created record
	 */
	@Override
	public TaskBO create(TaskVO taskVO) {
		return new TaskBO(m_Repository.save(vo2entity(taskVO)));
	}

	/**
	 * This method deletes a specified by id task.
	 * It propagates request to data layer using ITasksRepository method delete.
	 * @param taskId Id of task to delete
	 */
	@Override
	public void delete(Long taskId) {
		m_Repository.delete(taskId);
	}

	/**
	 * This method updates an existing specified by id task.
	 * It first creates a Task instance using vo2entity. Then
	 * it propagates request to data layer using ITaskRepository method save.
	 * Returned from save Task instance is wrapped into TaskBO.
	 * @param taskVO TaskVO's instance with user's changed and old data.
	 * @param taskId Id of task to edit
	 * @return TaskBO's instance for an edited record
	 */
	@Override
	public TaskBO update(TaskVO taskVO, Long taskId) {
		return new TaskBO(m_Repository.save(vo2entity(taskVO).setId(taskId)));
	}

	/**
	 * This method finds a specified by id task
	 * It propagates request to data layer 
	 * using ITasksRepository method findOne.
	 * Then it wraps up received Task instance into TaskBO.
	 * @param taskId Id of task to look up
	 * @return TaskBO's instance
	 */
	@Override
	public TaskBO find(Long taskId) {
		return new TaskBO(m_Repository.findOne(taskId));
	}

}
