package com.sss.model;

import java.util.List;

import com.sss.model.bo.AnswerBO;
import com.sss.model.vo.AnswerVO;
/**
 * Interface between model and controller.
 * Contains methods to change or receive data referred to answers.
 */
public interface IAnswersService {
	/**
	 * Method to receive answers to the question that is specified by it's id
	 * @param questionId Id of question answers to which are requested
	 * @return List of Answer's business objects
	 */
	List<AnswerBO> findByQuestionId(Long questionId);
	/**
	 * Method to add new answer to the question
	 * @param answerVO View object that contains answer's data from user
	 * @param questionId Id of question to which the answer will be added
	 * @return Answer's business object that corresponds to the added answer
	 */
	AnswerBO add(AnswerVO answerVO, Long questionId);
	/**
	 * Method to edit an answer to the question
	 * @param answerVO View object that contains edited answer's data from user
	 * @param questionId Id of question to which the answer will be updated
	 * @param answerId Id of answer to be edited
	 * @return Answer's business object that corresponds to the edited answer
	 */
	AnswerBO update(AnswerVO answerVO, Long questionId, Long answerId);
	/**
	 * Method to delete an answer to the question
	 * @param questionId Id of question to which the answer will be deleted
	 * @param answerId Id of answer to be deleted
	 */
	void delete(Long questionId, Long answerId); 
}
