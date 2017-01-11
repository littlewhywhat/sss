package com.sss.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.data.ICommentsRepository;
import com.sss.data.entity.Comment;
import com.sss.data.entity.Commentable;
import com.sss.model.ICommentsService;
import com.sss.model.bo.CommentBO;
import com.sss.model.vo.CommentVO;

/**
 * Service class.
 * Implementation of interface between presentation and model layer to perform operations on comments.
 * Uses member variable that implements ICommentsRepository.
 * 
 * @author vaivorom
 *
 */
@Service
public class CommentsService implements ICommentsService {

	/**
	 * Member variable that implements ICommentsRepository.
	 * Autowired by Spring Framework.
	 */
	@Autowired
	private ICommentsRepository m_Repository;

	/**
	 * This method constructs a Comment object using data from 
	 * CommentVO instance and commentable id.
	 * @param commentVO CommentVO instance with user's input data
	 * @param commentableId Id of commentable that comment corresponds to 
	 * @return Comment instance
	 */
	private Comment vo2entity(CommentVO commentVO, Long commentableId) {
		return new Comment()
				.setContent(commentVO.getContent())
				.setCommentable(new Commentable().setId(commentableId));
	}
	
	/**
	 * This method adds a new comment to a specified by id commentable.
	 * It first creates an Comment instance using vo2entity. Then
	 * it propagates request to data layer using ICommentsRepository method save.
	 * Returned from save Comment instance is wrapped into CommentBO.
	 * @param commentVO CommentVO's instance with user's input data
	 * @param commentableId Id of commentable to add a comment to
	 * @return CommentBO's instance for a new created record
	 */
	@Override
	public CommentBO add(CommentVO commentVO, Long commentableId) {
		return new CommentBO(m_Repository.save(vo2entity(commentVO, commentableId)));
	}

	/**
	 * This method returns all comments that are available 
	 * to a specified by id commentable.
	 * It propagates request to data layer 
	 * using ICommentsRepository method findByCommentableId.
	 * Then it wraps up each Comment instance into CommentBO and collect them to List.
	 * @param commentableId Id of commentable to receive comments to
	 * @return List of CommentBO's instances
	 */
	@Override
	public List<CommentBO> findByCommentableId(Long commentableId) {
		List<CommentBO> comments = new ArrayList<>();
		for (Comment comment : m_Repository.findByCommentableId(commentableId)) 
			comments.add(new CommentBO(comment));
		return comments;
	}

	/**
	 * This method deletes a specified by id comment to a specified by id commentable.
	 * It propagates request to data layer using ICommentsRepository method delete.
	 * @param commentableId Id of commentable to delete an comment to
	 * @param commentId Id of comment to delete
	 */
	@Override
	public void delete(Long commentableId, Long commentId) {
		m_Repository.delete(commentId);
	}

	/**
	 * This method updates an existing specified by id comment to a specified by id commentable.
	 * It first creates a Comment instance using vo2entity. Then
	 * it propagates request to data layer using ICommentsRepository method save.
	 * Returned from save Comment instance is wrapped into CommentBO.
	 * @param commentVO CommentVO's instance with user's changed and old data.
	 * @param commentableId Id of commentable to edit an comment to
	 * @param commentId Id of comment to edit
	 * @return CommentBO's instance for an edited record
	 */
	@Override
	public CommentBO update(CommentVO commentVO, Long commentableId, Long commentId) {
		return new CommentBO(m_Repository.save(vo2entity(commentVO, commentableId).setId(commentId)));
	}


}
