package com.hangileye.lifetouch.mapper.questionMain.dummy.question;

import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyExampleModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DummyExampleMapper {

    List<DummyExampleModel> listSelect(String queKey);

    DummyExampleModel detailSelect(DummyExampleModel questionCaseModel);

    void insert(DummyExampleModel questionCaseModel);

    void delete(DummyExampleModel questionCaseModel);

    void update(DummyExampleModel questionCaseModel);

    void sortUpdate(DummyExampleModel dummyExampleModel);
}
