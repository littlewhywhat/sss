package com.sss.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.sss.data.ICommentsRepository;
import com.sss.data.entity.Comment;

/**
 * Interface provided for Spring Framework to create an implementation of CrudRepository for Comments.
 * An implementation can be used as ICommentsRepository autowired member variable.
 * @author vaivorom
 *
 */
public interface CommentsRepository extends CrudRepository<Comment, Long>, ICommentsRepository {

}
