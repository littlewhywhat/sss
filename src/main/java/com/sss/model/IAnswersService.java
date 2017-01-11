package com.sss.model;

import java.util.List;

import com.sss.model.bo.AnswerBO;
import com.sss.model.vo.AnswerVO;

/**
 * Interface between presentation and model layer to perform operations on answers
 * 
 * @author vaivorom
 *
 */
public interface IAnswersService {
	/**
	 * This method returns all answers that are available 
	 * to a specified by id question.
	 * @param questionId Id of question to receive answers to
	 * @return List of AnswerBO's instances
	 */
	List<AnswerBO> findByQuestionId(Long questionId);
    /**
	 * This method adds a new answer to a specified by id question.
	 * @param answerVO AnswerVO's instance with user's input data
	 * @param questionId Id of question to add an answer to
	 * @return AnswerBO's instance for a new created record
	 */
	AnswerBO add(AnswerVO answerVO, Long questionId);
    /**
	 * This method updates an existing specified by id answer to a specified by id question.
	 * @param answerVO AnswerVO's instance with user's changed and old data.
	 * @param questionId Id of question to edit an answer to
	 * @param answerId Id of answer to edit
	 * @return AnswerBO's instance for an edited record
	 */
	AnswerBO update(AnswerVO answerVO, Long questionId, Long answerId);
    /**
	 * This method deletes a specified by id answer to a specified by id question.
	 * @param questionId Id of question to delete an answer to
	 * @param answerId Id of answer to delete
	 */
	void delete(Long questionId, Long answerId); 
}
