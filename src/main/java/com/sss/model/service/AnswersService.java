package com.sss.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.data.IAnswersRepository;
import com.sss.data.ICommentableRepository;
import com.sss.data.entity.Answer;
import com.sss.data.entity.Commentable;
import com.sss.data.entity.Question;
import com.sss.model.IAnswersService;
import com.sss.model.bo.AnswerBO;
import com.sss.model.vo.AnswerVO;

@Service
public class AnswersService implements IAnswersService {

	@Autowired
	private IAnswersRepository m_Repository;

	@Autowired
	private ICommentableRepository m_CommentableRepository;
	
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
	public AnswerBO add(AnswerVO answerVO, Long questionId) {
		return new AnswerBO(m_Repository.save(vo2entity(answerVO, questionId).setCommentable(new Commentable())));
	}

	@Override
	public AnswerBO update(AnswerVO answerVO, Long questionId, Long answerId) {
		return new AnswerBO(m_Repository.save(vo2entity(answerVO, questionId).setId(answerId)));
	}

	@Override
	@Transactional
	public void delete(Long questionId, Long answerId) {
		m_Repository.delete(answerId);
		m_CommentableRepository.delete(answerId);
	}

}
