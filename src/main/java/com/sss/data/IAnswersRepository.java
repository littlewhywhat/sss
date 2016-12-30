package com.sss.data;

import com.sss.data.entity.Answer;

public interface IAnswersRepository {
	Iterable<Answer> findByQuestionId(Long id);

	Answer save(Answer answer);

	void delete(Long answerId);

}
