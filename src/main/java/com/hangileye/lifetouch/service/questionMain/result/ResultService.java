package com.hangileye.lifetouch.service.questionMain.result;

import com.hangileye.lifetouch.mapper.questionMain.result.ResultMapper;
import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.question.QuestionCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ResultService {

    private final ResultMapper resultMapper;

    public ResultService(ResultMapper resultMapper) {
        this.resultMapper = resultMapper;
    }

    /*
     * @Description : 환자 케이스 정보에 저장된 질문 보기
     * */
    @Transactional
    public ResponseEntity<ResponseData> resultListSelect(PatientCaseModel patientCaseModel) {
        ResponseData res = new ResponseData();
        try {
            String[] stringArray;
            // TODO : 여기야!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//            if(patientCaseModel.getType()){
//
//            }





            List<QuestionCaseModel> arrList = resultMapper.resultListSelect(patientCaseModel);
            for (QuestionCaseModel list: arrList) {
                list.setExampleArr(resultMapper.exampleListSelect(list.getKey()));
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
}
