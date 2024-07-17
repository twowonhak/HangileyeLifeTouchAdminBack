package com.hangileye.lifetouch.mapper.questionMain.dummy.result;

import com.hangileye.lifetouch.model.questionMain.dummy.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyExampleModel;
import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyQuestionCaseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResultMapper {

    List<DummyQuestionCaseModel> resultListSelect(PatientCaseModel patientCaseModel);

    List<DummyExampleModel> exampleListSelect(String key);
}
