package com.sss.controller;

import com.sss.model.IQuestionService;
import com.sss.model.data.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class QuestionsController {

    @Autowired
    IQuestionService questions;

    @RequestMapping("/questions")
    public List<Question> index() {
        return questions.all();
    }
}
