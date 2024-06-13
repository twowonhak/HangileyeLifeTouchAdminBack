package com.hangileye.lifetouch.service.questionMain.question;

import com.hangileye.lifetouch.mapper.questionMain.question.ExampleMapper;
import com.hangileye.lifetouch.model.questionMain.question.ExampleModel;
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
public class ExampleService {

    private final ExampleMapper exampleMapper;

    public ExampleService(ExampleMapper exampleMapper) {
        this.exampleMapper = exampleMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(String queKey) {
        ResponseData res = new ResponseData();
        try {
            List<ExampleModel> list = exampleMapper.listSelect(queKey);
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
     * @Description : 상세 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> detailSelect(ExampleModel exampleModel) {
        ResponseData res = new ResponseData();
        try {
            ExampleModel model = exampleMapper.detailSelect(exampleModel);
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
    public ResponseEntity<ResponseData> insert(ExampleModel exampleModel) {
        ResponseData res = new ResponseData();
        try {
            exampleMapper.insert(exampleModel);
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
    public ResponseEntity<ResponseData> delete(ExampleModel exampleModel) {
        ResponseData res = new ResponseData();
        try {
            exampleMapper.delete(exampleModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 수정
     * */
    @Transactional
    public ResponseEntity<ResponseData> update(ExampleModel exampleModel) {
        ResponseData res = new ResponseData();
        try {
            exampleMapper.update(exampleModel);
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
    public ResponseEntity<ResponseData> sortUpdate(@RequestBody List<ExampleModel> exampleModelList) {
        ResponseData res = new ResponseData();
        try {
            for (ExampleModel exampleModel : exampleModelList) {
                exampleMapper.sortUpdate(exampleModel);
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
