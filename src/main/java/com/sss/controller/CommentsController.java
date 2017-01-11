package com.sss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.model.ICommentsService;
import com.sss.model.bo.CommentBO;
import com.sss.model.vo.CommentVO;

/**
 * Rest controller class.
 * Accepts all supported requests that start with api/commentables and communicates
 * with model layer using member variable that implements ICommentsService interface
 * 
 * @author vaivorom
 *
 */

@RestController
public class CommentsController {
	
	/**
	 * Member variable that implements ICommentsService.
	 * Autowired by Spring Framework.
	 */
	@Autowired
	private ICommentsService comments;
	
	/**
	 * This method adds a new comment to a specified by id commentable.
	 * It propagates request to model layer using ICommentsService method add.
	 * @param commentVO CommentVO's instance with user's input data
	 * @param commentableId Id of commentable to add a comment to
	 * @return CommentBO's instance for a new created record
	 */
	@RequestMapping(method=RequestMethod.POST, value="api/commentables/{commentableId}/comments")
	public CommentBO add(@RequestBody CommentVO commentVO, @PathVariable Long commentableId) {
		return comments.add(commentVO, commentableId);
	}
	
	/**
	 * This method returns all comments that are available 
	 * to a specified by id commentable.
	 * It propagates request to model layer 
	 * using ICommentsService method findByCommentableId
	 * @param commentableId Id of commentable to receive comments to
	 * @return List of CommentBO's instances
	 */
	
	@RequestMapping("api/commentables/{commentableId}/comments")
	public List<CommentBO> comments(@PathVariable Long commentableId) {
		return comments.findByCommentableId(commentableId);
	}
	
	/**
	 * This method updates an existing specified by id comment to a specified by id commentable.
	 * It propagates request to model layer using ICommentsService method update.
	 * @param commentVO CommentVO's instance with user's changed and old data.
	 * @param commentableId Id of commentable to edit an comment to
	 * @param commentId Id of comment to edit
	 * @return CommentBO's instance for an edited record
	 */
	@RequestMapping(method=RequestMethod.PUT, value="api/commentables/{commentableId}/comments/{commentId}")
    public CommentBO update(@RequestBody CommentVO commentVO, @PathVariable Long commentableId,@PathVariable Long commentId) {
    	return comments.update(commentVO, commentableId, commentId);
    }
	
	/**
	 * This method deletes a specified by id comment to a specified by id commentable.
	 * It propagates request to model layer using ICommentsService method delete.
	 * @param commentableId Id of commentable to delete an comment to
	 * @param commentId Id of comment to delete
	 */
    @RequestMapping(method=RequestMethod.DELETE, value="api/commentables/{commentableId}/comments/{commentId}")
    public void delete(@PathVariable Long commentableId, @PathVariable Long commentId) {
    	comments.delete(commentableId, commentId);
    }
}
