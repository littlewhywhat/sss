package com.sss.model.service;

import com.sss.model.IQuestionService;
import com.sss.model.data.Question;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
class QuestionService implements IQuestionService {

    @Override
    public List<Question> all() {
        return Arrays.asList(new Question("title1", "content1"),
                             new Question("title2", "content2"));
    }
}
