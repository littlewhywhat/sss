package com.sss.data;

/**
 * Interface between model and data layer to perform data operations on Commentable entities
 * 
 * @author vaivorom
 *
 */
public interface ICommentablesRepository {
	/**
	 * This method deletes a specified by id commentable
	 * @param id Id of commentable to delete
	 */
	void delete(Long id);
}
