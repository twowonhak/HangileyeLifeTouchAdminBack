package com.hangileye.lifetouch.service.questionMain;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.ExampleMapper;
import com.hangileye.lifetouch.model.questionMain.ExampleModel;
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
public class ExampleService extends ErrorHistory {

    private final ExampleMapper exampleMapper;
    private final ErrorMapper errorMapper;


    public ExampleService(ExampleMapper exampleMapper, ErrorMapper errorMapper) {
        this.exampleMapper = exampleMapper;
        this.errorMapper = errorMapper;
    }

    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request, String queKey) {
        ResponseData res = new ResponseData();
        try {
            List<ExampleModel> list = exampleMapper.listSelect(queKey);
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
    public ResponseEntity<ResponseData> detailSelect(HttpServletRequest request, ExampleModel exampleModel) {
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
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 저장
     * */
    @Transactional
    public ResponseEntity<ResponseData> insert(HttpServletRequest request, ExampleModel exampleModel) {
        ResponseData res = new ResponseData();
        try {
            exampleMapper.insert(exampleModel);
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
    public ResponseEntity<ResponseData> delete(HttpServletRequest request, ExampleModel exampleModel) {
        ResponseData res = new ResponseData();
        try {
            exampleMapper.delete(exampleModel);
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
    public ResponseEntity<ResponseData> update(HttpServletRequest request, ExampleModel exampleModel) {
        ResponseData res = new ResponseData();
        try {
            exampleMapper.update(exampleModel);
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
    public ResponseEntity<ResponseData> sortUpdate(HttpServletRequest request, @RequestBody List<ExampleModel> exampleModelList) {
        ResponseData res = new ResponseData();
        try {
            for (ExampleModel exampleModel : exampleModelList) {
                exampleMapper.sortUpdate(exampleModel);
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

}
