package com.sss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.model.IAnswersService;
import com.sss.model.bo.AnswerBO;
import com.sss.model.vo.AnswerVO;

/**
 * Rest controller class.
 * Accepts all supported requests that start with api/questions and communicates
 * with model layer using member variable that implements IAnswersService interface
 * 
 * @author vaivorom
 *
 */

@RestController
public class AnswersController {
    
	/**
	 * Member variable that implements IAnswersService.
	 * Autowired by Spring Framework.
	 */
	@Autowired
	private IAnswersService answers;
	
	/**
	 * This method returns all answers that are available 
	 * to a specified by id question.
	 * It propagates request to model layer 
	 * using IAnswersService method findByQuestionId
	 * @param questionId Id of question to receive answers to
	 * @return List of AnswerBO's instances
	 */
    @RequestMapping("api/questions/{questionId}/answers") 
    public List<AnswerBO> answers(@PathVariable Long questionId) {    	
    	return answers.findByQuestionId(questionId);
    }
    
    /**
	 * This method adds a new answer to a specified by id question.
	 * It propagates request to model layer using IAnswersService method add.
	 * @param answerVO AnswerVO's instance with user's input data
	 * @param questionId Id of question to add an answer to
	 * @return AnswerBO's instance for a new created record
	 */
    @RequestMapping(method=RequestMethod.POST, value="api/questions/{questionId}/answers")
    public AnswerBO add(@RequestBody AnswerVO answerVO, @PathVariable Long questionId) {
    	return answers.add(answerVO, questionId);
    }
    
    /**
	 * This method updates an existing specified by id answer to a specified by id question.
	 * It propagates request to model layer using IAnswersService method update.
	 * @param answerVO AnswerVO's instance with user's changed and old data.
	 * @param questionId Id of question to edit an answer to
	 * @param answerId Id of answer to edit
	 * @return AnswerBO's instance for an edited record
	 */
    @RequestMapping(method=RequestMethod.PUT, value="api/questions/{questionId}/answers/{answerId}")
    public AnswerBO update(@RequestBody AnswerVO answerVO, @PathVariable Long questionId, @PathVariable Long answerId) {
    	return answers.update(answerVO, questionId, answerId);
    }
    
    /**
	 * This method deletes a specified by id answer to a specified by id question.
	 * It propagates request to model layer using IAnswersService method delete.
	 * @param questionId Id of question to delete an answer to
	 * @param answerId Id of answer to delete
	 */
    @RequestMapping(method=RequestMethod.DELETE, value="api/questions/{questionId}/answers/{answerId}")
    public void delete(@PathVariable Long questionId, @PathVariable Long answerId) {
    	answers.delete(questionId, answerId);
    }
}
