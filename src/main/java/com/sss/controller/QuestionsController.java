package com.sss.controller;

import com.sss.model.IQuestionsService;
import com.sss.model.bo.QuestionBO;
import com.sss.model.vo.QuestionVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller class.
 * Accepts all supported requests that start with api/questions and communicates
 * with model layer using member variable that implements IQuestionsService interface
 * 
 * @author vaivorom
 *
 */
@RestController
class QuestionsController {

	/**
	 * Member variable that implements IQuestionsService.
	 * Autowired by Spring Framework.
	 */
	@Autowired
    private IQuestionsService questions;
	
	/**
	 * This method returns all questions that are available 
	 * It propagates request to model layer 
	 * using IQuestionsService method all
	 * @return List of QuestionBO's instances
	 */
    @RequestMapping("api/questions")
    public List<QuestionBO> index() {
        return questions.all();
    }
    
    /**
	 * This method adds a new question.
	 * It propagates request to model layer using IQuestionsService method add.
	 * @param questionVO QuestionVO's instance with user's input data
	 * @return QuestionBO's instance for a new created record
	 */
    @RequestMapping(method=RequestMethod.POST, value="api/questions")
    public QuestionBO add(@RequestBody QuestionVO questionVO) {    	
    	return questions.add(questionVO);
    }

    /**
	 * This method looks for a question specified by id.
	 * It propagates request to model layer 
	 * using IQuestionsService method find
	 * @param questionId Id of question to find
	 * @return QuestionBO's instance
	 */
    @RequestMapping("api/questions/{questionId}")
    public QuestionBO find(@PathVariable Long questionId) {
    	return questions.find(questionId);
    }
    
	/**
	 * This method updates an existing specified by id question.
	 * It propagates request to model layer using IQuestionsService method update.
	 * @param questionVO QuestionVO's instance with user's changed and old data.
	 * @param questionId Id of question to edit
	 * @return QuestionBO's instance for an edited record
	 */
    @RequestMapping(method=RequestMethod.PUT, value="api/questions/{questionId}")
    public QuestionBO update(@RequestBody QuestionVO questionVO, @PathVariable Long questionId) {
    	return questions.update(questionVO, questionId);
    }
    
    /**
	 * This method deletes a specified by id question.
	 * It propagates request to model layer using IQuestionsService method delete.
	 * @param questionId Id of question to delete
	 */
    @RequestMapping(method=RequestMethod.DELETE, value="api/questions/{questionId}")
    public void delete(@PathVariable Long questionId) {
    	questions.delete(questionId);
    }
}
