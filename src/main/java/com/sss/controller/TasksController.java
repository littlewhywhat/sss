package com.sss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.model.ITasksService;
import com.sss.model.bo.TaskBO;
import com.sss.model.vo.TaskVO;

@RestController
public class TasksController {
	
	@Autowired
	private ITasksService tasks;
	
	@RequestMapping("api/tasks")
	public List<TaskBO> index() {
		return tasks.all();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="api/tasks")
	public TaskBO create(@RequestBody TaskVO taskVO) {
		return tasks.create(taskVO);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="api/tasks/{taskId}")
	public void delete(@PathVariable Long taskId) {
		tasks.delete(taskId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="api/tasks/{taskId}")
	public TaskBO update(@RequestBody TaskVO taskVO, @PathVariable Long taskId) {
		return tasks.update(taskVO, taskId);
	}
}
