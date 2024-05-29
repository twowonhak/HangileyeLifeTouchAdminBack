package com.hangileye.lifetouch.mapper;

import com.hangileye.lifetouch.model.PatientCaseModel;
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
