package com.hangileye.lifetouch.mapper.questionMain.dummy.question;

import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyQuestionCaseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DummyQuestionMapper {

    List<DummyQuestionCaseModel> listSelect(String useYn);

    DummyQuestionCaseModel detailSelect(String key);

    void insert(DummyQuestionCaseModel dummyQuestionCaseModel);

    void delete(DummyQuestionCaseModel dummyQuestionCaseModel);

    void update(DummyQuestionCaseModel dummyQuestionCaseModel);

    int caseUse(String key);
}
