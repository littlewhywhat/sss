package com.sss.model;

import java.util.List;

import com.sss.model.bo.CommentBO;
import com.sss.model.vo.CommentVO;

/**
 * Interface between presentation and model layer to perform operations on comments
 * 
 * @author vaivorom
 *
 */
public interface ICommentsService {
	/**
	 * This method returns all comments that are available 
	 * to a specified by id commentable.
	 * @param commentableId Id of commentable to receive comments to
	 * @return List of CommentBO's instances
	 */
	List<CommentBO> findByCommentableId(Long commentableId);
	/**
	 * This method adds a new comment to a specified by id commentable.
	 * @param commentVO CommentVO's instance with user's input data
	 * @param commentableId Id of commentable to add a comment to
	 * @return CommentBO's instance for a new created record
	 */
	CommentBO add(CommentVO commentVO, Long commentableId);
	/**
	 * This method updates an existing specified by id comment to a specified by id commentable.
	 * @param commentVO CommentVO's instance with user's changed and old data.
	 * @param commentableId Id of commentable to edit an comment to
	 * @param commentId Id of comment to edit
	 * @return CommentBO's instance for an edited record
	 */
	CommentBO update(CommentVO commentVO, Long commentableId, Long commentId);
	/**
	 * This method deletes a specified by id comment to a specified by id commentable.
	 * @param commentableId Id of commentable to delete an comment to
	 * @param commentId Id of comment to delete
	 */
	void delete(Long commentableId, Long commentId);
}
