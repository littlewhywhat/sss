package com.sss.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.sss.data.ICommentablesRepository;
import com.sss.data.entity.Commentable;

/**
 * Interface provided for Spring Framework to create an implementation of CrudRepository for Commentables.
 * An implementation can be used as ICommentablesRepository autowired member variable.
 * @author vaivorom
 *
 */
public interface CommentablesRepository extends CrudRepository<Commentable, Long>, ICommentablesRepository {

}
