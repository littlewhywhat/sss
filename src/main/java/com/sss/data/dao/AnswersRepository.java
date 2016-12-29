package com.sss.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.sss.data.IAnswersRepository;
import com.sss.data.entity.Answer;

public interface AnswersRepository extends CrudRepository<Answer, Long>, IAnswersRepository {

}
