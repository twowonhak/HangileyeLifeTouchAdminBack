package com.hangileye.lifetouch.mapper.questionMain.result;

import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.question.QuestionCaseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResultMapper {

    List<QuestionCaseModel> resultListSelect(PatientCaseModel patientCaseModel);

    String exampleListSelect(String key);
}
