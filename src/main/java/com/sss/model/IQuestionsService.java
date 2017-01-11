package com.sss.model;

import java.util.List;

import com.sss.model.bo.QuestionBO;
import com.sss.model.vo.QuestionVO;

/**
 * Interface between presentation and model layer to perform operations on questions
 * 
 * @author vaivorom
 *
 */
public interface IQuestionsService {
	/**
	 * This method returns all questions that are available 
	 * @return List of QuestionBO's instances
	 */
    List<QuestionBO> all();
    /**
	 * This method looks for a question specified by id.
	 * @param id Id of question to find
	 * @return QuestionBO's instance
	 */
    QuestionBO find(Long id);
    /**
	 * This method adds a new question.
	 * @param questionVO QuestionVO's instance with user's input data
	 * @return QuestionBO's instance for a new created record
	 */
    QuestionBO add(QuestionVO questionVO);
	/**
	 * This method updates an existing specified by id question.
	 * @param questionVO QuestionVO's instance with user's changed and old data.
	 * @param questionId Id of question to edit
	 * @return QuestionBO's instance for an edited record
	 */
	QuestionBO update(QuestionVO questionVO, Long questionId);
    /**
	 * This method deletes a specified by id question.
	 * @param questionId Id of question to delete
	 */
    void delete(Long questionId);
}
