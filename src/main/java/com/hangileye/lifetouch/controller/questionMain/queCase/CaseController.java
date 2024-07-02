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
import java.util.List;

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
     * @Description : 케이스 목록
     * */
    @RequestMapping("listSelectApi")
    public ResponseData listSelect() {
        return caseService.listSelect().getBody();
    }

    /*
     * @Description : 등록 된 질문 조회
     * */
    @RequestMapping("okListSelectApi")
    public ResponseData okListSelect(@RequestBody PatientCaseModel patientCaseModel) {
        return caseService.okListSelect(patientCaseModel.getKey()).getBody();
    }

    /*
     * @Description : 추가 할 질문 조회
     * */
    @RequestMapping("noListSelectApi")
    public ResponseData noListSelect(@RequestBody PatientCaseModel patientCaseModel) {
        return caseService.noListSelect(patientCaseModel.getKey()).getBody();
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

    /*
     * @Description : 저장 된 질문 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest response, @RequestBody CaseModel caseModel) {
        caseModel.setUpUserId(CookieManager.getCookie(response, "ID"));
        caseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return caseService.delete(caseModel).getBody();
    }

    /*
     * @Description : 등록 된 질문 순서 목록
     * */
    @RequestMapping("sortListSelectApi")
    public ResponseData sortListSelect(@RequestBody CaseModel caseModel) {
        return caseService.sortListSelect(caseModel.getPatKey()).getBody();
    }

    /*
     * @Description : 순서 수정
     * */
    @RequestMapping("sortUpdateApi")
    public ResponseData sortUpdate(HttpServletRequest response, @RequestBody List<CaseModel> caseModelList) {
        for (CaseModel caseModel : caseModelList) {
            caseModel.setUpUserId(CookieManager.getCookie(response, "ID"));
            caseModel.setUpUserIp(InetAddressInfo.getClientIP());
        }
        return caseService.sortUpdate(caseModelList).getBody();
    }

}
