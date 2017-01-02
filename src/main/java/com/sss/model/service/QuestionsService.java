package com.sss.model.service;

import com.sss.data.ICommentableRepository;
import com.sss.data.IQuestionsRepository;
import com.sss.data.entity.Commentable;
import com.sss.data.entity.Question;
import com.sss.model.IQuestionsService;
import com.sss.model.bo.QuestionBO;
import com.sss.model.vo.QuestionVO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class QuestionsService implements IQuestionsService  {

	@Autowired
	private IQuestionsRepository m_Repository;

	@Autowired
	private ICommentableRepository m_CommentableRepository;
	
	private Question vo2entity(QuestionVO questionVO) {
		return new Question()
				.setTitle(questionVO.getTitle())
				.setContent(questionVO.getContent());
	}
	
    @Override
    public List<QuestionBO> all() {
    	List<QuestionBO> questions = new ArrayList<>();
    	for (Question question : m_Repository.findAll())
    		questions.add(new QuestionBO(question));
        return questions;
    }
    
    @Override
    public QuestionBO find(Long id) {
    	return new QuestionBO(m_Repository.findOne(id));
    }

	@Override
	public QuestionBO add(QuestionVO questionVO) {
		return new QuestionBO(m_Repository.save(vo2entity(questionVO).setCommentable(new Commentable())));		
	}

	@Override
	public QuestionBO update(QuestionVO questionVO, Long questionId) {
		return new QuestionBO(m_Repository.save(vo2entity(questionVO).setId(questionId)));
	}

	@Override
	@Transactional
	public void delete(Long questionId) {
		m_Repository.delete(questionId);
		m_CommentableRepository.delete(questionId);
	}
}
