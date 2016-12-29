package com.sss.model;

import java.util.List;

import com.sss.model.bo.AnswerBO;
import com.sss.model.vo.AnswerVO;

public interface IAnswersService {
	public List<AnswerBO> findByQuestionId(Long questionId);
	public void add(AnswerVO answerVO, Long questionId); 
}
