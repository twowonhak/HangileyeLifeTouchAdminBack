package com.hangileye.lifetouch.mapper;

import com.hangileye.lifetouch.model.PatientCaseModel;
import com.hangileye.lifetouch.model.QuestionExampleCaseModel;
import com.hangileye.lifetouch.model.SpecialNoteModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionExampleCaseMapper {

    List<QuestionExampleCaseModel> listSelect();

    QuestionExampleCaseModel detailSelect(QuestionExampleCaseModel patientCaseModel);

    void insert(QuestionExampleCaseModel patientCaseModel);

    void delete(QuestionExampleCaseModel patientCaseModel);

    int caseUse(String key);
}
