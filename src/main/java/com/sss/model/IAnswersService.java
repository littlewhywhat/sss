package com.sss.model;

import java.util.List;

import com.sss.model.bo.AnswerBO;
import com.sss.model.vo.AnswerVO;

public interface IAnswersService {
	List<AnswerBO> findByQuestionId(Long questionId);
	void add(AnswerVO answerVO, Long questionId);
	void update(AnswerVO answerVO, Long questionId, Long answerId);
	void delete(Long questionId, Long answerId); 
}
