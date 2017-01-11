package com.sss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class.
 * Accepts all supported requests that doesn't start with api.
 * Maps requests to html templates.
 * 
 * @author vaivorom
 *
 */
@Controller
public class PagesController {
	
	/**
	 * This method maps specified request to index.html template
	 * @return Path to file with omitted html extension
	 */
	@RequestMapping(value={ "/"})
    public String index() {
    	return "index";
    }
	
	/**
	 * This method maps specified request to questions/show.html template
	 * @return Path to file with omitted html extension
	 */
	@RequestMapping("questions/{questionId}")
    public String show() {
    	return "questions/show";
    }

	/**
	 * This method maps specified request to tasks/show.html template
	 * @return Path to file with omitted html extension
	 */
	@RequestMapping("tasks/{taskId}") 
	public String createTask() {
		return "tasks/show";
	}
}
