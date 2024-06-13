package com.hangileye.lifetouch.mapper.questionMain.queCase;

import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.queCase.CaseModel;
import com.hangileye.lifetouch.model.questionMain.question.QuestionCaseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CaseMapper {

    String keySelect(PatientCaseModel patientCaseModel);

    List<PatientCaseModel> listSelect(String patKey);

    void insert(CaseModel caseModel);

    List<QuestionCaseModel> queListSelect(String queKey);
}
