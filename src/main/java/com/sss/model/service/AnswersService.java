package com.sss.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.data.IAnswersRepository;
import com.sss.data.entity.Answer;
import com.sss.data.entity.Question;
import com.sss.model.IAnswersService;
import com.sss.model.bo.AnswerBO;
import com.sss.model.vo.AnswerVO;

@Service
public class AnswersService implements IAnswersService {

	@Autowired
	private IAnswersRepository repository;
	
	@Override
	public List<AnswerBO> findByQuestionId(Long questionId) {
		List<AnswerBO> answers = new ArrayList<>();
		for (Answer answer : repository.findByQuestionId(questionId))
			answers.add(new AnswerBO(answer));
		return answers;
	}

	@Override
	public void add(AnswerVO answerVO, Long questionId) {
		repository.save(new Answer()
								.setContent(answerVO.getContent())
								.setQuestion(new Question().setId(questionId)));
	}

}
