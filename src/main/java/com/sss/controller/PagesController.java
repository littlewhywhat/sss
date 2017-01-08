package com.sss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {
	
	@RequestMapping(value={ "/"})
    public String index() {
    	return "index";
    }
	
	@RequestMapping("questions/{questionId}")
    public String show() {
    	return "questions/show";
    }
    
	@RequestMapping("tasks/{taskId}") 
	public String createTask() {
		return "tasks/show";
	}
}
