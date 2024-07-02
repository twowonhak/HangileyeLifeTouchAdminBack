package com.hangileye.lifetouch.controller.questionMain.result;

import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.result.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/case")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    /*
     * @Description : 환자 케이스 정보에 저장된 질문 보기
     * */
    @RequestMapping("resultListSelectApi")
    public ResponseData resultListSelect(@RequestBody PatientCaseModel patientCaseModel) {
        return resultService.resultListSelect(patientCaseModel).getBody();
    }

}
