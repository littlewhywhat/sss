package com.sss.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sss.data.IAnswersRepository;
import com.sss.data.ICommentablesRepository;
import com.sss.data.entity.Answer;
import com.sss.data.entity.Commentable;
import com.sss.data.entity.Question;
import com.sss.model.IAnswersService;
import com.sss.model.bo.AnswerBO;
import com.sss.model.vo.AnswerVO;

/**
 * Service class.
 * Implementation of interface between presentation and model layer to perform operations on answers.
 * Uses member variables that implements IAnswersRepository and ICommentablesRepository interfaces
 * 
 * @author vaivorom
 *
 */
@Service
public class AnswersService implements IAnswersService {

	/**
	 * Member variable that implements IAnswersRepository.
	 * Autowired by Spring Framework.
	 */
	@Autowired
	private IAnswersRepository m_Repository;

	/**
	 * Member variable that implements ICommentablesRepository.
	 * Autowired by Spring Framework.
	 */
	@Autowired
	private ICommentablesRepository m_CommentableRepository;
	
	/**
	 * This method constructs an Answer object using data from 
	 * AnswerVO instance and question id.
	 * @param answerVO AnswerVO instance with user's input data
	 * @param questionId Id of question that answers corresponds to 
	 * @return Answer instance
	 */
	private Answer vo2entity(AnswerVO answerVO, Long questionId) {
		return new Answer()
				.setContent(answerVO.getContent())
				.setQuestion(new Question().setId(questionId));
	}
	
	/**
	 * This method returns all answers that are available 
	 * to a specified by id question.
	 * It propagates request to data layer 
	 * using IAnswersRepository method findByQuestionId.
	 * Then it wraps up each Answer instance into AnswerBO and collect them to List.
	 * @param questionId Id of question to receive answers to
	 * @return List of AnswerBO's instances
	 */
	@Override
	public List<AnswerBO> findByQuestionId(Long questionId) {
		List<AnswerBO> answers = new ArrayList<>();
		for (Answer answer : m_Repository.findByQuestionId(questionId))
			answers.add(new AnswerBO(answer));
		return answers;
	}

	/**
	 * This method adds a new answer to a specified by id question.
	 * It first creates an Answer instance using vo2entity. Then
	 * it propagates request to data layer using IAnswersRepository method save.
	 * Returned from save Answer instance is wrapped into AnswerBO.
	 * @param answerVO AnswerVO's instance with user's input data
	 * @param questionId Id of question to add an answer to
	 * @return AnswerBO's instance for a new created record
	 */
	@Override
	public AnswerBO add(AnswerVO answerVO, Long questionId) {
		return new AnswerBO(m_Repository.save(vo2entity(answerVO, questionId).setCommentable(new Commentable())));
	}

	/**
	 * This method updates an existing specified by id answer to a specified by id question.
	 * It first creates an Answer instance using vo2entity. Then
	 * it propagates request to data layer using IAnswersRepository method save.
	 * Returned from save Answer instance is wrapped into AnswerBO.
	 * @param answerVO AnswerVO's instance with user's changed and old data.
	 * @param questionId Id of question to edit an answer to
	 * @param answerId Id of answer to edit
	 * @return AnswerBO's instance for an edited record
	 */
	@Override
	public AnswerBO update(AnswerVO answerVO, Long questionId, Long answerId) {
		return new AnswerBO(m_Repository.save(vo2entity(answerVO, questionId).setId(answerId)));
	}

	/**
	 * This method deletes a specified by id answer to a specified by id question.
	 * It propagates request to data layer using IAnswersRepository and ICommentablesRepository methods delete.
	 * To realize cascade rule for relation between Commentable and Answer entity it first calls delete 
	 * using a record with answerId in IAnswersRepository and then calls same method in ICommentablesRepository.
	 * @param questionId Id of question to delete an answer to
	 * @param answerId Id of answer to delete
	 */
	@Override
	@Transactional
	public void delete(Long questionId, Long answerId) {
		m_Repository.delete(answerId);
		m_CommentableRepository.delete(answerId);
	}

}
