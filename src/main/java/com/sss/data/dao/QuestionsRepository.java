package com.sss.data.dao;


import org.springframework.data.repository.CrudRepository;

import com.sss.data.IQuestionsRepository;
import com.sss.data.entity.Question;

public interface QuestionsRepository extends CrudRepository<Question, Long>, IQuestionsRepository {

}
