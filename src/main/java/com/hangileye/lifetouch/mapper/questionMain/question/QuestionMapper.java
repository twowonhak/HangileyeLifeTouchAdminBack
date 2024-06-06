package com.hangileye.lifetouch.mapper.questionMain.question;

import com.hangileye.lifetouch.model.questionMain.question.QuestionCaseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    List<QuestionCaseModel> listSelect();

    QuestionCaseModel detailSelect(String key);

    void insert(QuestionCaseModel questionCaseModel);

    void delete(QuestionCaseModel questionCaseModel);

    void update(QuestionCaseModel questionCaseModel);

    int caseUse(String key);
}
