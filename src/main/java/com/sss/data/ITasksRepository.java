package com.sss.data;

import com.sss.data.entity.Task;

public interface ITasksRepository {
	Task save(Task task);
	void delete(Long id);
	Iterable<Task> findAll();
	Task findOne(Long taskId);
}
