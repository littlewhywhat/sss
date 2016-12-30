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

@RestController
public class AnswersController {
    
	@Autowired
	private IAnswersService answers;
	
    @RequestMapping("/questions/{questionId}/answers") 
    public List<AnswerBO> answers(@PathVariable Long questionId) {    	
    	return answers.findByQuestionId(questionId);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="questions/{questionId}/answers")
    public void add(@RequestBody AnswerVO answerVO, @PathVariable Long questionId) {
    	answers.add(answerVO, questionId);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="questions/{questionId}/answers/{answerId}")
    public void update(@RequestBody AnswerVO answerVO, @PathVariable Long questionId, @PathVariable Long answerId) {
    	answers.update(answerVO, questionId, answerId);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="questions/{questionId}/answers/{answerId}")
    public void delete(@PathVariable Long questionId, @PathVariable Long answerId) {
    	answers.delete(questionId, answerId);
    }
}
