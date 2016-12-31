package com.sss.controller;

import com.sss.model.IQuestionsService;
import com.sss.model.bo.QuestionBO;
import com.sss.model.vo.QuestionVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
class QuestionsController {

	private static final String QUESTION = "question"; 
	private static final String QUESTIONS = QUESTION + "s";
	private static final String INDEX = QUESTIONS + "/index";
	private static final String QUESTION_ID = QUESTIONS + "/{" + QUESTION + "Id}";
	private static final String SHOW = QUESTIONS + "/show";
	private static final String NEW = QUESTIONS + "/new"; 
	
    @Autowired
    private IQuestionsService questions;

    @ModelAttribute(QUESTIONS)
    public List<QuestionBO> all() {
    	return questions.all();
    }
    
    @RequestMapping(QUESTIONS)
    public String index() {
        return INDEX;
    }

    @RequestMapping(NEW)
    public String create(Model model) {
    	model.addAttribute(QUESTION, new QuestionVO());
    	return NEW;
    }
    
    @RequestMapping(method=RequestMethod.POST, value=QUESTIONS)
    public String add(@ModelAttribute QuestionVO questionVO) {    	
    	questions.add(questionVO);
    	return INDEX;
    }

    @RequestMapping(QUESTION_ID)
    public String show(@PathVariable Long questionId, Model model) {
    	model.addAttribute(QUESTION, questions.find(questionId));
    	return SHOW;
    }
    
    @RequestMapping(method=RequestMethod.PUT, value=QUESTION_ID)
    public void update(@RequestBody QuestionVO questionVO, @PathVariable Long questionId) {
    	questions.update(questionVO, questionId);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value=QUESTION_ID)
    public void delete(@PathVariable Long questionId) {
    	questions.delete(questionId);
    }
}
