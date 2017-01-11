package com.sss.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.sss.data.ITasksRepository;
import com.sss.data.entity.Task;

/**
 * Interface provided for Spring Framework to create an implementation of CrudRepository for Tasks.
 * An implementation can be used as ITasksRepository autowired member variable.
 * @author vaivorom
 *
 */
public interface TasksRepository extends CrudRepository<Task, Long>, ITasksRepository {

}
