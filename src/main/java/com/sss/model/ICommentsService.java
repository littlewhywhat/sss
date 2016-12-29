package com.sss.model;

import java.util.List;

import com.sss.model.bo.CommentBO;
import com.sss.model.vo.CommentVO;

public interface ICommentsService {

	void add(CommentVO commentVO, Long commentableId);

	List<CommentBO> findByCommentableId(Long commentableId);

}
