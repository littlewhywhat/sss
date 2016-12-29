package com.sss.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.sss.data.ICommentsRepository;
import com.sss.data.entity.Comment;

public interface CommentsRepository extends CrudRepository<Comment, Long>, ICommentsRepository {

}
