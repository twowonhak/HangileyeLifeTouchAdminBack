package com.hangileye.lifetouch.service.questionMain.dummy.question;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.dummy.question.DummyExampleMapper;
import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyExampleModel;
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
public class DummyExampleService extends ErrorHistory {

    private final DummyExampleMapper dummyExampleMapper;
    private final ErrorMapper errorMapper;

    public DummyExampleService(DummyExampleMapper dummyExampleMapper, ErrorMapper errorMapper) {
        this.dummyExampleMapper = dummyExampleMapper;
        this.errorMapper = errorMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request, String queKey) {
        ResponseData res = new ResponseData();
        try {
            List<DummyExampleModel> list = dummyExampleMapper.listSelect(queKey);
            res.setData(list);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 상세 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> detailSelect(HttpServletRequest request, DummyExampleModel dummyExampleModel) {
        ResponseData res = new ResponseData();
        try {
            DummyExampleModel model = dummyExampleMapper.detailSelect(dummyExampleModel);
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
    public ResponseEntity<ResponseData> insert(HttpServletRequest request, DummyExampleModel dummyExampleModel) {
        ResponseData res = new ResponseData();
        try {
            dummyExampleMapper.insert(dummyExampleModel);
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
    public ResponseEntity<ResponseData> delete(HttpServletRequest request, DummyExampleModel dummyExampleModel) {
        ResponseData res = new ResponseData();
        try {
            dummyExampleMapper.delete(dummyExampleModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 수정
     * */
    @Transactional
    public ResponseEntity<ResponseData> update(HttpServletRequest request, DummyExampleModel dummyExampleModel) {
        ResponseData res = new ResponseData();
        try {
            dummyExampleMapper.update(dummyExampleModel);
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
    public ResponseEntity<ResponseData> sortUpdate(HttpServletRequest request, @RequestBody List<DummyExampleModel> dummyExampleModelList) {
        ResponseData res = new ResponseData();
        try {
            for (DummyExampleModel dummyExampleModel : dummyExampleModelList) {
                dummyExampleMapper.sortUpdate(dummyExampleModel);
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
