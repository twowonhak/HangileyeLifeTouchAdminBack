package com.hangileye.lifetouch.service.questionMain;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.QueCodeMapper;
import com.hangileye.lifetouch.mapper.questionMain.QuestionMapper;
import com.hangileye.lifetouch.model.questionMain.QueCodeModel;
import com.hangileye.lifetouch.model.questionMain.QuestionModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class QuestionService extends ErrorHistory {

    private final QuestionMapper questionMapper;
    private final QueCodeMapper queCodeMapper;
    private final ErrorMapper errorMapper;

    public QuestionService(QuestionMapper questionMapper, QueCodeMapper queCodeMapper, ErrorMapper errorMapper) {
        this.questionMapper = questionMapper;
        this.queCodeMapper = queCodeMapper;
        this.errorMapper = errorMapper;
    }

    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> codeListSelect(HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            Map<String, List<QueCodeModel>> map = new HashMap<>();
            map.put("lrgCtg", queCodeMapper.lrgCtgListSelect(null));
            map.put("midCtg", queCodeMapper.midCtgListSelect(null));
            res.setData(map);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request, QuestionModel questionModel) {
        ResponseData res = new ResponseData();
        try {
            List<QuestionModel> list = questionMapper.listSelect(questionModel);
            if (list == null) {
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
            QuestionModel model = questionMapper.detailSelect(key);
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
    public ResponseEntity<ResponseData> insert(HttpServletRequest request, QuestionModel questionModel) {
        ResponseData res = new ResponseData();
        try {
            questionMapper.insert(questionModel);
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
    public ResponseEntity<ResponseData> delete(HttpServletRequest request, QuestionModel questionModel) {
        ResponseData res = new ResponseData();
        try {
            questionMapper.delete(questionModel);
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
    public ResponseEntity<ResponseData> update(HttpServletRequest request, QuestionModel questionModel) {
        ResponseData res = new ResponseData();
        try {
            questionMapper.update(questionModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseData> sortUpdate(HttpServletRequest request, List<QuestionModel> questionModelList) {
        ResponseData res = new ResponseData();
        try {
            for(QuestionModel questionModel : questionModelList){
                questionMapper.sortUpdate(questionModel);
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
