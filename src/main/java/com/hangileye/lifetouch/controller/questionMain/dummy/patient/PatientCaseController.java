package com.hangileye.lifetouch.controller.questionMain.dummy.patient;

import com.hangileye.lifetouch.model.questionMain.dummy.patient.PatientCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.dummy.patient.PatientCaseService;
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
    public ResponseData listSelect(HttpServletRequest request, @RequestBody PatientCaseModel patientCaseModel) {
        return patientCaseService.listSelect(request, patientCaseModel.getUseDat()).getBody();
    }

    /*
     * @Description : 환자 케이스 상세 조회
     * */
    @RequestMapping("detailSelectApi")
    public ResponseData detailSelect(HttpServletRequest request, @RequestBody PatientCaseModel patientCaseModel) {
        return patientCaseService.detailSelect(request, patientCaseModel.getKey()).getBody();
    }

    /*
     * @Description : 환자 케이스 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest request, @RequestBody PatientCaseModel patientCaseModel) {
        patientCaseModel.setCrUserId(CookieManager.getCookie(request, "ID"));
        patientCaseModel.setCrUserIp(InetAddressInfo.getClientIP());
        return patientCaseService.insert(request, patientCaseModel).getBody();
    }

    /*
     * @Description : 환자 케이스 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest request, @RequestBody PatientCaseModel patientCaseModel) {
        patientCaseModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        patientCaseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return patientCaseService.delete(request, patientCaseModel).getBody();
    }

    /*
     * @Description : 환자 케이스 수정
     * */
    @RequestMapping("updateApi")
    public ResponseData update(HttpServletRequest request, @RequestBody PatientCaseModel patientCaseModel) {
        patientCaseModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        patientCaseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return patientCaseService.update(request, patientCaseModel).getBody();
    }
}
