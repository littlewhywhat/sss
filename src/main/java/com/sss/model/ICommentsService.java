package com.sss.model;

import java.util.List;

import com.sss.model.bo.CommentBO;
import com.sss.model.vo.CommentVO;

public interface ICommentsService {
	List<CommentBO> findByCommentableId(Long commentableId);
	void add(CommentVO commentVO, Long commentableId);
	void update(CommentVO commentVO, Long commentableId, Long commentId);
	void delete(Long commentableId, Long commentId);
}
