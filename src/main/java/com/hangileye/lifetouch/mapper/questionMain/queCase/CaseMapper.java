package com.hangileye.lifetouch.mapper.questionMain.queCase;

import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.queCase.CaseModel;
import com.hangileye.lifetouch.model.questionMain.question.QuestionCaseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CaseMapper {

    List<PatientCaseModel> listSelect();

    String keySelect(PatientCaseModel patientCaseModel);

    List<QuestionCaseModel> okListSelect(String patKey);

    void insert(CaseModel caseModel);

    List<QuestionCaseModel> noListSelect(String queKey);

    void delete(CaseModel caseModel);

    void sortUpdate(CaseModel caseModel);

    List<CaseModel> sortListSelect(String patKey);

    String exampleListSelect(String queKey);

}
