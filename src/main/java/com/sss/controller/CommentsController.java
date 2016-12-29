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

@RestController
public class CommentsController {
	
	@Autowired
	private ICommentsService comments;
	
	@RequestMapping(method=RequestMethod.POST, value="/commentable/{commentableId}/comments")
	public void add(@RequestBody CommentVO commentVO, @PathVariable Long commentableId) {
		comments.add(commentVO, commentableId);
	}
	
	@RequestMapping("/commentable/{commentableId}/comments")
	public List<CommentBO> comments(@PathVariable Long commentableId) {
		return comments.findByCommentableId(commentableId);
	}
}
