package com.sss.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.sss.data.ICommentableRepository;
import com.sss.data.entity.Commentable;

public interface CommentableRepository extends CrudRepository<Commentable, Long>, ICommentableRepository {

}
