package com.hangileye.lifetouch.controller.questionMain.queCase;

import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.queCase.CaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.queCase.CaseService;
import com.hangileye.lifetouch.utill.CookieManager;
import com.hangileye.lifetouch.utill.InetAddressInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/case")
public class CaseController {

    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    /*
     * @Description : 질문 조회
     * */
    @RequestMapping("queListSelectApi")
    public ResponseData queListSelect(@RequestBody PatientCaseModel patientCaseModel) {
        return caseService.queListSelect(patientCaseModel.getKey()).getBody();
    }

    /*
     * @Description : 환자 키 조회
     * */
    @RequestMapping("keySelectApi")
    public ResponseData keySelect(@RequestBody PatientCaseModel patientCaseModel) {
        return caseService.keySelect(patientCaseModel).getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest response, @RequestBody CaseModel caseModel) {
        caseModel.setCrUserId(CookieManager.getCookie(response, "ID"));
        caseModel.setCrUserIp(InetAddressInfo.getClientIP());
        return caseService.insert(caseModel).getBody();
    }

}
