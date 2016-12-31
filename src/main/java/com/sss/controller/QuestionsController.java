package com.sss.controller;

import com.sss.model.IQuestionsService;
import com.sss.model.bo.QuestionBO;
import com.sss.model.vo.QuestionVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
class QuestionsController {

	@Autowired
    private IQuestionsService questions;

    @ModelAttribute(Questions.QUESTIONS)
    public List<QuestionBO> all() {
    	return questions.all();
    }
    
    @RequestMapping(Questions.QUESTIONS)
    public String index() {
        return Questions.INDEX;
    }

    @RequestMapping(Questions.NEW)
    public String create(Model model) {
    	model.addAttribute(Questions.QUESTION, new QuestionVO());
    	return Questions.NEW;
    }
    
    @RequestMapping(method=RequestMethod.POST, value=Questions.QUESTIONS)
    public String add(@ModelAttribute QuestionVO questionVO) {    	
    	questions.add(questionVO);
    	return Questions.INDEX;
    }

    @RequestMapping(Questions.EDIT_PATH)
    public String edit(@PathVariable Long questionId, Model model) {
    	model.addAttribute(Questions.ID, questionId);
    	model.addAttribute(Questions.QUESTION, new QuestionVO());
    	return Questions.EDIT_VIEW;
    }
    
    @RequestMapping(Questions.ID_PATH)
    public String show(@PathVariable Long questionId, Model model) {
    	model.addAttribute(Questions.QUESTION, questions.find(questionId));
    	return Questions.SHOW;
    }
    
    @RequestMapping(method=RequestMethod.PUT, value=Questions.ID_PATH)
    public String update(@ModelAttribute QuestionVO questionVO, @PathVariable Long questionId, Model model) {
    	questions.update(questionVO, questionId);
    	model.addAttribute(Questions.QUESTION, questions.find(questionId));
    	return Questions.SHOW;
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value=Questions.ID_PATH)
    public String delete(@PathVariable Long questionId) {
    	questions.delete(questionId);
    	return Questions.INDEX;
    }
}
