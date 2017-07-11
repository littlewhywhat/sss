package com.sss.model.service;

import com.sss.data.ICommentablesRepository;
import com.sss.data.IQuestionsRepository;
import com.sss.data.entity.Commentable;
import com.sss.data.entity.Question;
import com.sss.model.IQuestionsService;
import com.sss.model.bo.QuestionBO;
import com.sss.model.vo.QuestionVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class.
 * Implementation of interface between presentation and model layer to perform operations on questions.
 * Uses member variables that implements IQuestionsRepository, ICommentablesRepository
 * 
 * @author vaivorom
 *
 */
@Service
public class QuestionsService implements IQuestionsService  {

	/**
	 * Member variable that implements IQuestionsRepository.
	 * Autowired by Spring Framework.
	 */
	@Autowired
	private IQuestionsRepository m_Repository;

	/**
	 * Member variable that implements ICommentablesRepository.
	 * Autowired by Spring Framework.
	 */
	@Autowired
	private ICommentablesRepository m_CommentableRepository;
	
	/**
	 * This method constructs a Question object using data from 
	 * QuestionVO instance.
	 * @param questionVO QuestionVO instance with user's input data
	 * @return Question instance
	 */
	private Question vo2entity(QuestionVO questionVO) {
		return new Question()
				.setTitle(questionVO.getTitle())
				.setContent(questionVO.getContent());
	}
	
	/**
	 * This method returns all questions
	 * It propagates request to data layer 
	 * using IQuestionsRepository method findAll.
	 * Then it wraps up each Question instance into QuestionBO and collect them to List.
	 * @return List of QuestionBO's instances
	 */
    @Override
    public List<QuestionBO> all() {
    	List<QuestionBO> questions = new ArrayList<>();
    	for (Question question : m_Repository.findAll())
    		questions.add(new QuestionBO(question));
        return questions;
    }
    
	/**
	 * This method finds a specified by id question
	 * It propagates request to data layer 
	 * using IQuestionsRepository method findOne.
	 * Then it wraps up received Question instance into QuestionBO.
	 * @param questionId Id of question to look up
	 * @return QuestionBO's instance
	 */
    @Override
    public QuestionBO find(Long questionId) {
    	return new QuestionBO(m_Repository.findOne(questionId));
    }

	/**
	 * This method adds a new question.
	 * It first creates a Question instance using vo2entity. Then
	 * it propagates request to data layer using IQuestionsRepository method save.
	 * Returned from save Question instance is wrapped into QuestionBO.
	 * @param questionVO QuestionVO's instance with user's input data
	 * @return QuestionBO's instance for a new created record
	 */
	@Override
	public QuestionBO add(QuestionVO questionVO) {
		return new QuestionBO(m_Repository.save(vo2entity(questionVO).setCommentable(new Commentable())));		
	}

	/**
	 * This method updates an existing specified by id question.
	 * It first creates a Question instance using vo2entity. Then
	 * it propagates request to data layer using IQuestionsRepository method save.
	 * Returned from save Question instance is wrapped into QuestionBO.
	 * @param questionVO QuestionVO's instance with user's changed and old data.
	 * @param questionId Id of question to edit
	 * @return questionBO's instance for an edited record
	 */
	@Override
	public QuestionBO update(QuestionVO questionVO, Long questionId) {
		return new QuestionBO(m_Repository.save(vo2entity(questionVO).setId(questionId)));
	}

	/**
	 * This method deletes a specified by id question.
	 * It propagates request to data layer using IQuestionsRepository and ICommentablesRepository methods delete.
	 * To realize cascade rule for relation between Commentable and Question entities it first calls delete 
	 * using a record with questionId in IQuestionsRepository and then calls same method in ICommentablesRepository.
	 * @param questionId Id of question to delete
	 */
	@Override
	@Transactional
	public void delete(Long questionId) {
		m_Repository.delete(questionId);
		m_CommentableRepository.delete(questionId);
	}
}
