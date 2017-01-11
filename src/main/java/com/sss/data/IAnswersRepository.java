package com.sss.data;

import com.sss.data.entity.Answer;

/**
 * Interface between model and data layer to perform data operations on Answer entities
 * 
 * @author vaivorom
 *
 */
public interface IAnswersRepository {
	
	/**
	 * This method finds all answers to a specified by id question
	 * @param id Id of question to receive answers to
	 * @return Iterable of Answer instances
	 */
	Iterable<Answer> findByQuestionId(Long id);

	/**
	 * This method saves data about answer. It can be used both for editing and creation of new answers.
	 * If parameter has id equal to null then a new answer record will be created in repository.
	 * @param answer Answer instance 
	 * @return Answer instance that represents a new or edited record in repository
	 */
	Answer save(Answer answer);

	/**
	 * This method deletes a specified by id answer
	 * @param id Id of answer to delete
	 */
	void delete(Long id);

}
