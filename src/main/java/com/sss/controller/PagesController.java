package com.sss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {
	
	@RequestMapping(value={ "/", "questions/"})
    public String index() {
    	return "questions/index";
    }
	
	@RequestMapping("questions/{questionId}")
    public String show() {
    	return "questions/show";
    }
    
}
