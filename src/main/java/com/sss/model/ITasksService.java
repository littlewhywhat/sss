package com.sss.model;

import java.util.List;

import com.sss.model.bo.TaskBO;
import com.sss.model.vo.TaskVO;

public interface ITasksService {

	public List<TaskBO> all();

	public TaskBO create(TaskVO taskVO);

	public void delete(Long taskId);

	public TaskBO update(TaskVO taskVO, Long taskId);

	public TaskBO find(Long taskId);

}
