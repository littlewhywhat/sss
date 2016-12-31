package com.sss.controller;

class Questions {

	private static final String EDIT = "/edit";
	static final String QUESTION = "question";
	static final String QUESTIONS = QUESTION + "s";
	static final String INDEX = QUESTIONS + "/index";
	static final String ID = QUESTION + "Id";
	static final String ID_PATH = QUESTIONS + "/{" + ID +"}";
	static final String SHOW = QUESTIONS + "/show";
	static final String NEW = QUESTIONS + "/new";
	static final String EDIT_VIEW = QUESTIONS + EDIT;
	static final String EDIT_PATH = ID_PATH + EDIT;

}
