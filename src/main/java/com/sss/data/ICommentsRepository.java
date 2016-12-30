package com.sss.data;

import com.sss.data.entity.Comment;

public interface ICommentsRepository {

	Iterable<Comment> findByCommentableId(Long commentableId);

	Comment save(Comment setCommentable);

	void delete(Long commentId);

}
