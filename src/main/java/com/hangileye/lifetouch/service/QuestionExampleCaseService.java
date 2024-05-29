package com.hangileye.lifetouch.service;

import com.hangileye.lifetouch.mapper.QuestionExampleCaseMapper;
import com.hangileye.lifetouch.model.PatientCaseModel;
import com.hangileye.lifetouch.model.QuestionExampleCaseModel;
import com.hangileye.lifetouch.model.SpecialNoteModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class QuestionExampleCaseService {

    private final QuestionExampleCaseMapper QuestionExampleCaseMapper;

    public QuestionExampleCaseService(QuestionExampleCaseMapper questionExampleCaseMapper) {
        QuestionExampleCaseMapper = questionExampleCaseMapper;
    }

    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect() {
        ResponseData res = new ResponseData();
        try {
            List<QuestionExampleCaseModel> list = QuestionExampleCaseMapper.listSelect();
            if (list.size() == 0) {
                res.setErrNoData();
            } else {
                res.setData(list);
                res.setSuccess();
            }
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 상세 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> detailSelect(QuestionExampleCaseModel questionExampleCaseModel) {
        ResponseData res = new ResponseData();
        try {
            QuestionExampleCaseModel model = QuestionExampleCaseMapper.detailSelect(questionExampleCaseModel);
            if (model == null) {
                res.setErrNoData();
            } else {
                res.setData(model);
                res.setSuccess();
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
    public ResponseEntity<ResponseData> insert(QuestionExampleCaseModel questionExampleCaseModel) {
        ResponseData res = new ResponseData();
        try {
            QuestionExampleCaseMapper.insert(questionExampleCaseModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 삭제
     * */
    @Transactional
    public ResponseEntity<ResponseData> delete(QuestionExampleCaseModel questionExampleCaseModel) {
        ResponseData res = new ResponseData();
        try {
            if (QuestionExampleCaseMapper.caseUse(questionExampleCaseModel.getKey()) == 1) {
                res.setErrUse();
                return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
            } else {
                QuestionExampleCaseMapper.delete(questionExampleCaseModel);
                res.setSuccess();
            }
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }
}
