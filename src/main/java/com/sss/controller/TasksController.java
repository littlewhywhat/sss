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

/**
 * Rest controller class.
 * Accepts all supported requests that start with api/tasks and communicates
 * with model layer using member variable that implements ITasksService interface
 * 
 * @author vaivorom
 *
 */
@RestController
public class TasksController {
	
	/**
	 * Member variable that implements ITasksService.
	 * Autowired by Spring Framework.
	 */
	@Autowired
	private ITasksService tasks;
	
	/**
	 * This method returns all tasks that are available 
	 * It propagates request to model layer 
	 * using ITasksService method all
	 * @return List of TaskBO's instances
	 */
	@RequestMapping("api/tasks")
	public List<TaskBO> index() {
		return tasks.all();
	}
	
	/**
	 * This method looks for a task specified by id.
	 * It propagates request to model layer 
	 * using ITasksService method find
	 * @param taskId Id of task to find
	 * @return TaskBO's instance
	 */
	@RequestMapping("api/tasks/{taskId}")
	public TaskBO find(@PathVariable Long taskId) {
		return tasks.find(taskId);
	}
	
	/**
	 * This method creates a new task.
	 * It propagates request to model layer using ITasksService method create.
	 * @param taskVO TaskVO's instance with user's input data
	 * @return taskBO's instance for a new created record
	 */
	@RequestMapping(method=RequestMethod.POST, value="api/tasks")
	public TaskBO create(@RequestBody TaskVO taskVO) {
		return tasks.create(taskVO);
	}

    /**
	 * This method deletes a specified by id task.
	 * It propagates request to model layer using ITasksService method delete.
	 * @param taskId Id of task to delete
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="api/tasks/{taskId}")
	public void delete(@PathVariable Long taskId) {
		tasks.delete(taskId);
	}
	
	/**
	 * This method updates an existing specified by id task.
	 * It propagates request to model layer using ITasksService method update.
	 * @param taskVO TaskVO's instance with user's changed and old data.
	 * @param taskId Id of task to update
	 * @return TaskBO's instance for an edited record
	 */
	@RequestMapping(method=RequestMethod.PUT, value="api/tasks/{taskId}")
	public TaskBO update(@RequestBody TaskVO taskVO, @PathVariable Long taskId) {
		return tasks.update(taskVO, taskId);
	}
}
