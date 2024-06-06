package com.hangileye.lifetouch.mapper.questionMain.patient;

import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientCaseMapper {

    List<PatientCaseModel> listSelect(String useDat);

    PatientCaseModel detailSelect(String key);

    void insert(PatientCaseModel patientCaseModel);

    void delete(PatientCaseModel patientCaseModel);

    void update(PatientCaseModel patientCaseModel);

    int caseUse(String key);
}
