package com.hangileye.lifetouch.service.questionMain.queCase;

import com.hangileye.lifetouch.mapper.questionMain.queCase.CaseMapper;
import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.queCase.CaseModel;
import com.hangileye.lifetouch.model.questionMain.question.QuestionCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
public class CaseService {

    private final CaseMapper caseMapper;

    public CaseService(CaseMapper caseMapper) {
        this.caseMapper = caseMapper;
    }

    /*
     * @Description : 케이스 목록
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect() {
        ResponseData res = new ResponseData();
        try {
            res.setData(caseMapper.listSelect());
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 추가 된 질문 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> okListSelect(String queKey) {
        ResponseData res = new ResponseData();
        try {
            List<QuestionCaseModel> arrList = caseMapper.okListSelect(queKey);
            for (QuestionCaseModel list: arrList) {
                list.setExampleArr(caseMapper.exampleListSelect(list.getKey()));
            }
            res.setData(arrList);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 추가 할 질문 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> noListSelect(String queKey) {
        ResponseData res = new ResponseData();
        try {
            List<QuestionCaseModel> arrList = caseMapper.noListSelect(queKey);
            for (QuestionCaseModel list: arrList) {
                list.setExampleArr(caseMapper.exampleListSelect(list.getKey()));
            }
            res.setData(arrList);
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

    /*
     * @Description : 저장 된 질문 삭제
     * */
    @Transactional
    public ResponseEntity<ResponseData> delete(CaseModel caseModel) {
        ResponseData res = new ResponseData();
        try {
            caseMapper.delete(caseModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 순서 수정
     * */
    @Transactional
    public ResponseEntity<ResponseData> sortUpdate(@RequestBody List<CaseModel> caseModelList) {
        ResponseData res = new ResponseData();
        try {
            for (CaseModel caseModel : caseModelList) {
                caseMapper.sortUpdate(caseModel);
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 등록 된 질문 순서 목록
     * */
    @Transactional
    public ResponseEntity<ResponseData> sortListSelect(String patKey) {
        ResponseData res = new ResponseData();
        try {
            List<CaseModel> list = caseMapper.sortListSelect(patKey);
            res.setData(list);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }
}
