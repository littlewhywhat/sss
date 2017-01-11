package com.sss.data;

import com.sss.data.entity.Task;

/**
 * Interface between model and data layer to perform data operations on Task entities
 * 
 * @author vaivorom
 *
 */
public interface ITasksRepository {
	/**
	 * This method saves data about task. It can be used both for editing and creation of new tasks.
	 * If parameter has id equal to null then a new task record will be created in repository.
	 * @param task Task instance 
	 * @return Task instance that represents a new or edited record in repository
	 */
	Task save(Task task);
	/**
	 * This method deletes a specified by id task
	 * @param id Id of task to delete
	 */
	void delete(Long id);
	/**
	 * This method finds all tasks that are stored in repository
	 * @return Iterable of Task instances
	 */
	Iterable<Task> findAll();
	/**
	 * This method finds a specified by id task
	 * @param id Id of task to look up
	 * @return Task instance that represents a found record
	 */
	Task findOne(Long id);
}
