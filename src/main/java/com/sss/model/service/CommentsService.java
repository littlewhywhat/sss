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

@Service
public class CommentsService implements ICommentsService {

	@Autowired
	private ICommentsRepository m_Repository;

	private Comment vo2entity(CommentVO commentVO, Long commentableId) {
		return new Comment()
				.setContent(commentVO.getContent())
				.setCommentable(new Commentable().setId(commentableId));
	}
	
	@Override
	public CommentBO add(CommentVO commentVO, Long commentableId) {
		return new CommentBO(m_Repository.save(vo2entity(commentVO, commentableId)));
	}

	@Override
	public List<CommentBO> findByCommentableId(Long commentableId) {
		List<CommentBO> comments = new ArrayList<>();
		for (Comment comment : m_Repository.findByCommentableId(commentableId)) 
			comments.add(new CommentBO(comment));
		return comments;
	}

	@Override
	public void delete(Long commentableId, Long commentId) {
		m_Repository.delete(commentId);
	}

	@Override
	public CommentBO update(CommentVO commentVO, Long commentableId, Long commentId) {
		return new CommentBO(m_Repository.save(vo2entity(commentVO, commentableId).setId(commentId)));
	}


}
