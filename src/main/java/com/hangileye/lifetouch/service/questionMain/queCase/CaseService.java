package com.hangileye.lifetouch.service.questionMain.queCase;

import com.hangileye.lifetouch.mapper.questionMain.queCase.CaseMapper;
import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.queCase.CaseModel;
import com.hangileye.lifetouch.model.questionMain.question.ExampleModel;
import com.hangileye.lifetouch.model.questionMain.question.QuestionCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CaseService {

    private final CaseMapper caseMapper;

    public CaseService(CaseMapper caseMapper) {
        this.caseMapper = caseMapper;
    }

    /*
     * @Description : 질문 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> queListSelect(String queKey) {
        ResponseData res = new ResponseData();
        try {
            List<QuestionCaseModel> list = caseMapper.queListSelect(queKey);
            res.setData(list);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 환자 키 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> keySelect(PatientCaseModel patientCaseModel) {
        ResponseData res = new ResponseData();
        try {
            String patKey = caseMapper.keySelect(patientCaseModel);
            if (patKey != null) {
                res.setData(patKey);
                res.setSuccess();
            } else {
                res.setNoPatKey();
            }
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 저장
     * */
    @Transactional
    public ResponseEntity<ResponseData> insert(CaseModel caseModel) {
        ResponseData res = new ResponseData();
        try {
            for (int i = 0; i < caseModel.getQueKeyArr().length; i++) {
                caseModel.setQueKey(caseModel.getQueKeyArr()[i]);
                caseMapper.insert(caseModel);
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

}
