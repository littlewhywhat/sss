package com.sss.data.dao;


import org.springframework.data.repository.CrudRepository;

import com.sss.data.IQuestionsRepository;
import com.sss.data.entity.Question;

/**
 * Interface provided for Spring Framework to create an implementation of CrudRepository for Questions.
 * An implementation can be used as IQuestionsRepository autowired member variable.
 * @author vaivorom
 *
 */
public interface QuestionsRepository extends CrudRepository<Question, Long>, IQuestionsRepository {
}
