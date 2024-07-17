package com.hangileye.lifetouch.service.questionMain.dummy.result;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.dummy.result.ResultMapper;
import com.hangileye.lifetouch.model.questionMain.dummy.patient.PatientCaseModel;
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
public class ResultService extends ErrorHistory {

    private final ResultMapper resultMapper;
    private final ErrorMapper errorMapper;

    public ResultService(ResultMapper resultMapper, ErrorMapper errorMapper) {
        this.resultMapper = resultMapper;
        this.errorMapper = errorMapper;
    }

    /*
     * @Description : 환자 케이스 정보에 저장된 질문 보기
     * */
    @Transactional
    public ResponseEntity<ResponseData> resultListSelect(HttpServletRequest request, PatientCaseModel patientCaseModel) {
        ResponseData res = new ResponseData();
        try {
            List<DummyQuestionCaseModel> arrList = resultMapper.resultListSelect(patientCaseModel);

            if (arrList.size() == 0) {
                res.setErrNoData();
            } else {
                for (DummyQuestionCaseModel list : arrList) {
                    list.setExampleArr(resultMapper.exampleListSelect(list.getKey()));
                }
                res.setData(arrList);
                res.setSuccess();
            }


            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
