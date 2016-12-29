package com.sss.controller;

import com.sss.model.IQuestionsService;
import com.sss.model.bo.QuestionBO;
import com.sss.model.vo.QuestionVO;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void add(@RequestBody QuestionVO questionVO) {    	
    	questions.create(questionVO);
    }

}
