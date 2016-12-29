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
	private ICommentsRepository repository;
	
	@Override
	public void add(CommentVO commentVO, Long commentableId) {
		repository.save(new Comment()
							.setContent(commentVO.getContent())
							.setCommentable(new Commentable().setId(commentableId)));
	}

	@Override
	public List<CommentBO> findByCommentableId(Long commentableId) {
		List<CommentBO> comments = new ArrayList<>();
		for (Comment comment : repository.findByCommentableId(commentableId)) 
			comments.add(new CommentBO(comment));
		return comments;
	}

}
