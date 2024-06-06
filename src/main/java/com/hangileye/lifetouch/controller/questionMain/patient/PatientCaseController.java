package com.hangileye.lifetouch.controller.questionMain.patient;

import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.patient.PatientCaseService;
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
@RequestMapping("/api/patientCase")
public class PatientCaseController {

    private final PatientCaseService patientCaseService;

    public PatientCaseController(PatientCaseService patientCaseService) {
        this.patientCaseService = patientCaseService;
    }


    /*
     * @Description : 환자 케이스 목록 조회
     * */
    @RequestMapping("listSelectApi")
    public ResponseData listSelect(@RequestBody PatientCaseModel patientCaseModel) {
        return patientCaseService.listSelect(patientCaseModel.getUseDat()).getBody();
    }

    /*
     * @Description : 환자 케이스 상세 조회
     * */
    @RequestMapping("detailSelectApi")
    public ResponseData detailSelect(@RequestBody PatientCaseModel patientCaseModel) {
        return patientCaseService.detailSelect(patientCaseModel.getKey()).getBody();
    }

    /*
     * @Description : 환자 케이스 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest response, @RequestBody PatientCaseModel patientCaseModel) {
        patientCaseModel.setCrUserId(CookieManager.getCookie(response, "ID"));
        patientCaseModel.setCrUserIp(InetAddressInfo.getClientIP());
        return patientCaseService.insert(patientCaseModel).getBody();
    }

    /*
     * @Description : 환자 케이스 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest response, @RequestBody PatientCaseModel patientCaseModel) {
        patientCaseModel.setUpUserId(CookieManager.getCookie(response, "ID"));
        patientCaseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return patientCaseService.delete(patientCaseModel).getBody();
    }

    /*
     * @Description : 환자 케이스 수정
     * */
    @RequestMapping("updateApi")
    public ResponseData update(HttpServletRequest response, @RequestBody PatientCaseModel patientCaseModel) {
        patientCaseModel.setUpUserId(CookieManager.getCookie(response, "ID"));
        patientCaseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return patientCaseService.update(patientCaseModel).getBody();
    }
}
