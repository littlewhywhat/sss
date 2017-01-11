package com.sss.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.sss.data.IAnswersRepository;
import com.sss.data.entity.Answer;

/**
 * Interface provided for Spring Framework to create an implementation of CrudRepository for Answers.
 * An implementation can be used as IAnswersRepository autowired member variable.
 * @author vaivorom
 *
 */
public interface AnswersRepository extends CrudRepository<Answer, Long>, IAnswersRepository {

}
