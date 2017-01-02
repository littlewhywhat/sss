package com.sss.model;

import java.util.List;

import com.sss.model.bo.AnswerBO;
import com.sss.model.vo.AnswerVO;

public interface IAnswersService {
	List<AnswerBO> findByQuestionId(Long questionId);
	AnswerBO add(AnswerVO answerVO, Long questionId);
	AnswerBO update(AnswerVO answerVO, Long questionId, Long answerId);
	void delete(Long questionId, Long answerId); 
}
