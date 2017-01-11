package com.sss.data;

import com.sss.data.entity.Question;

/**
 * Interface between model and data layer to perform data operations on Question entities
 * 
 * @author vaivorom
 *
 */
public interface IQuestionsRepository {
	/**
	 * This method finds a specified by id question
	 * @param id Id of question to look up
	 * @return Question's instance
	 */
	Question findOne(Long id);
	/**
	 * This method finds all questions that are stored in repository
	 * @return Iterable of Question instances
	 */
	Iterable<Question> findAll();
	/**
	 * This method saves data about question. It can be used both for editing and creation of new questions.
	 * If parameter has id equal to null then a new question record will be created in repository.
	 * @param question Question instance 
	 * @return Question instance that represents a new or edited record in repository
	 */
	public Question save(Question question);
	/**
	 * This method deletes a specified by id question
	 * @param id Id of question to delete
	 */
	public void delete(Long id);
}
