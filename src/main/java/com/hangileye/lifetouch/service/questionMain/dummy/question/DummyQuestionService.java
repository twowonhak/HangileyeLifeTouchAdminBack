package com.hangileye.lifetouch.service.questionMain.dummy.question;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.dummy.question.DummyQuestionMapper;
import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyQuestionCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class DummyQuestionService extends ErrorHistory {

    private final DummyQuestionMapper dummyQuestionMapper;
    private final ErrorMapper errorMapper;

    public DummyQuestionService(DummyQuestionMapper dummyQuestionMapper, ErrorMapper errorMapper) {
        this.dummyQuestionMapper = dummyQuestionMapper;
        this.errorMapper = errorMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request, DummyQuestionCaseModel dummyQuestionCaseModel) {
        ResponseData res = new ResponseData();
        try {
            List<DummyQuestionCaseModel> list = dummyQuestionMapper.listSelect(dummyQuestionCaseModel.getUseYn());
            if (list.size() == 0) {
                res.setErrNoData();
            } else {
                res.setData(list);
                res.setSuccess();
            }
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 상세 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> detailSelect(HttpServletRequest request, String key) {
        ResponseData res = new ResponseData();
        try {
            DummyQuestionCaseModel model = dummyQuestionMapper.detailSelect(key);
            if (model == null) {
                res.setErrNoData();
            } else {
                res.setData(model);
                res.setSuccess();
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
    public ResponseEntity<ResponseData> insert(HttpServletRequest request, DummyQuestionCaseModel dummyQuestionCaseModel) {
        ResponseData res = new ResponseData();

        try {
            dummyQuestionMapper.insert(dummyQuestionCaseModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 삭제
     * */
    @Transactional
    public ResponseEntity<ResponseData> delete(HttpServletRequest request, DummyQuestionCaseModel dummyQuestionCaseModel) {
        ResponseData res = new ResponseData();
        try {
            dummyQuestionMapper.delete(dummyQuestionCaseModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 삭제
     * */
    @Transactional
    public ResponseEntity<ResponseData> update(HttpServletRequest request, DummyQuestionCaseModel dummyQuestionCaseModel) {
        ResponseData res = new ResponseData();
        try {
            dummyQuestionMapper.update(dummyQuestionCaseModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
