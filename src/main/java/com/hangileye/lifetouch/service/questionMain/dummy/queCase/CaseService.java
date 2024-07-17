package com.hangileye.lifetouch.service.questionMain.dummy.queCase;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.dummy.queCase.CaseMapper;
import com.hangileye.lifetouch.model.questionMain.dummy.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.dummy.queCase.CaseModel;
import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyQuestionCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class CaseService extends ErrorHistory {

    private final CaseMapper caseMapper;
    private final ErrorMapper errorMapper;

    public CaseService(CaseMapper caseMapper, ErrorMapper errorMapper) {
        this.caseMapper = caseMapper;
        this.errorMapper = errorMapper;
    }

    /*
     * @Description : 케이스 목록
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            res.setData(caseMapper.listSelect());
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 추가 된 질문 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> okListSelect(HttpServletRequest request, String queKey) {
        ResponseData res = new ResponseData();
        try {
            List<DummyQuestionCaseModel> arrList = caseMapper.okListSelect(queKey);
            for (DummyQuestionCaseModel list: arrList) {
                list.setExampleArr(caseMapper.exampleListSelect(list.getKey()));
            }
            res.setData(arrList);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 추가 할 질문 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> noListSelect(HttpServletRequest request, String queKey) {
        ResponseData res = new ResponseData();
        try {
            List<DummyQuestionCaseModel> arrList = caseMapper.noListSelect(queKey);
            for (DummyQuestionCaseModel list: arrList) {
                list.setExampleArr(caseMapper.exampleListSelect(list.getKey()));
            }
            res.setData(arrList);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 환자 키 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> keySelect(HttpServletRequest request, PatientCaseModel patientCaseModel) {
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
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 저장
     * */
    @Transactional
    public ResponseEntity<ResponseData> insert(HttpServletRequest request, CaseModel caseModel) {
        ResponseData res = new ResponseData();
        try {
            for (int i = 0; i < caseModel.getQueKeyArr().length; i++) {
                caseModel.setQueKey(caseModel.getQueKeyArr()[i]);
                caseMapper.insert(caseModel);
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 저장 된 질문 삭제
     * */
    @Transactional
    public ResponseEntity<ResponseData> delete(HttpServletRequest request, CaseModel caseModel) {
        ResponseData res = new ResponseData();
        try {
            caseMapper.delete(caseModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 순서 수정
     * */
    @Transactional
    public ResponseEntity<ResponseData> sortUpdate(HttpServletRequest request, @RequestBody List<CaseModel> caseModelList) {
        ResponseData res = new ResponseData();
        try {
            for (CaseModel caseModel : caseModelList) {
                caseMapper.sortUpdate(caseModel);
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 등록 된 질문 순서 목록
     * */
    @Transactional
    public ResponseEntity<ResponseData> sortListSelect(HttpServletRequest request, String patKey) {
        ResponseData res = new ResponseData();
        try {
            List<CaseModel> list = caseMapper.sortListSelect(patKey);
            res.setData(list);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
