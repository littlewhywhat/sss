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

@Service
public class TasksService implements ITasksService {

	@Autowired
	ITasksRepository m_Repository;
	
	private Task vo2entity(TaskVO taskVO) {
		Task task = new Task()
				.setTitle(taskVO.getTitle());
		List<Question> questions = new ArrayList<>();
		for (Long id : taskVO.getQuestionIds())
			questions.add(new Question().setId(id));
		task.setQuestions(questions);
		return task;
	}
	
	@Override
	public List<TaskBO> all() {
		List<TaskBO> tasks = new ArrayList<>();
		for (Task task : m_Repository.findAll()) 
			tasks.add(new TaskBO(task));
		return tasks;
	}

	@Override
	public TaskBO create(TaskVO taskVO) {
		return new TaskBO(m_Repository.save(vo2entity(taskVO)));
	}

	@Override
	public void delete(Long taskId) {
		m_Repository.delete(taskId);
	}

	@Override
	public TaskBO update(TaskVO taskVO, Long taskId) {
		return new TaskBO(m_Repository.save(vo2entity(taskVO).setId(taskId)));
	}

	@Override
	public TaskBO find(Long taskId) {
		return new TaskBO(m_Repository.findOne(taskId));
	}

}
