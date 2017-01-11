package com.sss.model;

import java.util.List;

import com.sss.model.bo.TaskBO;
import com.sss.model.vo.TaskVO;

/**
 * Interface between presentation and model layer to perform operations on tasks
 * 
 * @author vaivorom
 *
 */
public interface ITasksService {
	/**
	 * This method returns all tasks that are available 
	 * @return List of TaskBO's instances
	 */
	public List<TaskBO> all();
	/**
	 * This method creates a new task.
	 * @param taskVO TaskVO's instance with user's input data
	 * @return taskBO's instance for a new created record
	 */
	public TaskBO create(TaskVO taskVO);
    
	/**
	 * This method deletes a specified by id task.
	 * @param taskId Id of task to delete
	 */
	public void delete(Long taskId);

	/**
	 * This method updates an existing specified by id task.
	 * @param taskVO TaskVO's instance with user's changed and old data.
	 * @param taskId Id of task to update
	 * @return TaskBO's instance for an edited record
	 */
	public TaskBO update(TaskVO taskVO, Long taskId);
	
	/**
	 * This method looks for a task specified by id.
	 * @param taskId Id of task to find
	 * @return TaskBO's instance
	 */
	public TaskBO find(Long taskId);

}
