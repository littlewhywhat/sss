package com.sss.model.service;

import com.sss.data.IQuestionsRepository;
import com.sss.data.entity.Question;
import com.sss.model.IQuestionsService;
import com.sss.model.bo.QuestionBO;
import com.sss.model.vo.QuestionVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class QuestionsService implements IQuestionsService  {

	@Autowired
	private IQuestionsRepository m_Repository;
	
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
	public void create(QuestionVO questionVO) {
		m_Repository.save(new Question()
								.setTitle(questionVO.getTitle())
								.setContent(questionVO.getContent()));		
	}
}