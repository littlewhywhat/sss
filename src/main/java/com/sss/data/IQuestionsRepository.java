package com.sss.data;

import com.sss.data.entity.Question;

public interface IQuestionsRepository {
	Question findOne(Long id);
	Iterable<Question> findAll();
	public Question save(Question question);
	public void delete(Long id);
}
