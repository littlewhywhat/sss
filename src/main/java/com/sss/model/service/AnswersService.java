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
	private IAnswersRepository m_Repository;

	private Answer vo2entity(AnswerVO answerVO, Long questionId) {
		return new Answer()
				.setContent(answerVO.getContent())
				.setQuestion(new Question().setId(questionId));
	}
	
	@Override
	public List<AnswerBO> findByQuestionId(Long questionId) {
		List<AnswerBO> answers = new ArrayList<>();
		for (Answer answer : m_Repository.findByQuestionId(questionId))
			answers.add(new AnswerBO(answer));
		return answers;
	}

	@Override
	public void add(AnswerVO answerVO, Long questionId) {
		m_Repository.save(vo2entity(answerVO, questionId));
	}

	@Override
	public void update(AnswerVO answerVO, Long questionId, Long answerId) {
		m_Repository.save(vo2entity(answerVO, questionId));
	}

	@Override
	public void delete(Long questionId, Long answerId) {
		m_Repository.delete(answerId);
	}

}
