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

@RestController
class QuestionsController {

    @Autowired
    IQuestionsService questions;

    @RequestMapping("/questions")
    public List<QuestionBO> index() {
        return questions.all();
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/questions")
    public QuestionBO add(@RequestBody QuestionVO questionVO) {    	
    	return questions.add(questionVO);
    }

    @RequestMapping(method=RequestMethod.PUT, value="questions/{questionId}")
    public void update(@RequestBody QuestionVO questionVO, @PathVariable Long questionId) {
    	questions.update(questionVO, questionId);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="questions/{questionId}")
    public void delete(@PathVariable Long questionId) {
    	questions.delete(questionId);
    }
}
