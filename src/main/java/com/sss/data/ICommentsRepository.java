package com.sss.data;

import com.sss.data.entity.Comment;

/**
 * Interface between model and data layer to perform data operations on Comment entities
 * 
 * @author vaivorom
 *
 */
public interface ICommentsRepository {

	/**
	 * This method finds all comments to a specified by id commentable
	 * @param commentableId Id of commentable to receive comments to
	 * @return Iterable of Comment instances
	 */
	Iterable<Comment> findByCommentableId(Long commentableId);

	/**
	 * This method saves data about comment. It can be used both for editing and creation of new comments.
	 * If parameter has id equal to null then a new comment record will be created in repository.
	 * @param comment Comment instance 
	 * @return Comment instance that represents a new or edited record in repository
	 */
	Comment save(Comment comment);
	
	/**
	 * This method deletes a specified by id comment
	 * @param id Id of comment to delete
	 */
	void delete(Long id);

}
