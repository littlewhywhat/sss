package com.sss.model;

import java.util.List;

import com.sss.model.bo.QuestionBO;
import com.sss.model.vo.QuestionVO;

public interface IQuestionsService {
    List<QuestionBO> all();
    QuestionBO find(Long id);
    void create(QuestionVO questionVO);
}
