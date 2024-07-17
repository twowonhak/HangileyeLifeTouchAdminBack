package com.hangileye.lifetouch.mapper.questionMain.dummy.queCase;

import com.hangileye.lifetouch.model.questionMain.dummy.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.dummy.queCase.CaseModel;
import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyExampleModel;
import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyQuestionCaseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CaseMapper {

    List<PatientCaseModel> listSelect();

    String keySelect(PatientCaseModel patientCaseModel);

    List<DummyQuestionCaseModel> okListSelect(String patKey);

    void insert(CaseModel caseModel);

    List<DummyQuestionCaseModel> noListSelect(String queKey);

    void delete(CaseModel caseModel);

    void sortUpdate(CaseModel caseModel);

    List<CaseModel> sortListSelect(String patKey);

    List<DummyExampleModel> exampleListSelect(String queKey);

}
