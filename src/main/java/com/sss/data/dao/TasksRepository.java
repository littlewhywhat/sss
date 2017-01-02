package com.sss.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.sss.data.ITasksRepository;
import com.sss.data.entity.Task;

public interface TasksRepository extends CrudRepository<Task, Long>, ITasksRepository {

}
