package com.hangileye.lifetouch.controller.questionMain.dummy.queCase;

import com.hangileye.lifetouch.model.questionMain.dummy.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.questionMain.dummy.queCase.CaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.dummy.queCase.CaseService;
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
    public ResponseData listSelect(HttpServletRequest request) {
        return caseService.listSelect(request).getBody();
    }

    /*
     * @Description : 등록 된 질문 조회
     * */
    @RequestMapping("okListSelectApi")
    public ResponseData okListSelect(HttpServletRequest request, @RequestBody PatientCaseModel patientCaseModel) {
        return caseService.okListSelect(request, patientCaseModel.getKey()).getBody();
    }

    /*
     * @Description : 추가 할 질문 조회
     * */
    @RequestMapping("noListSelectApi")
    public ResponseData noListSelect(HttpServletRequest request, @RequestBody PatientCaseModel patientCaseModel) {
        return caseService.noListSelect(request, patientCaseModel.getKey()).getBody();
    }

    /*
     * @Description : 환자 키 조회
     * */
    @RequestMapping("keySelectApi")
    public ResponseData keySelect(HttpServletRequest request, @RequestBody PatientCaseModel patientCaseModel) {
        return caseService.keySelect(request, patientCaseModel).getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest request, @RequestBody CaseModel caseModel) {
        caseModel.setCrUserId(CookieManager.getCookie(request, "ID"));
        caseModel.setCrUserIp(InetAddressInfo.getClientIP());
        return caseService.insert(request, caseModel).getBody();
    }

    /*
     * @Description : 저장 된 질문 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest request, @RequestBody CaseModel caseModel) {
        caseModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        caseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return caseService.delete(request, caseModel).getBody();
    }

    /*
     * @Description : 등록 된 질문 순서 목록
     * */
    @RequestMapping("sortListSelectApi")
    public ResponseData sortListSelect(HttpServletRequest request, @RequestBody CaseModel caseModel) {
        return caseService.sortListSelect(request, caseModel.getPatKey()).getBody();
    }

    /*
     * @Description : 순서 수정
     * */
    @RequestMapping("sortUpdateApi")
    public ResponseData sortUpdate(HttpServletRequest request, @RequestBody List<CaseModel> caseModelList) {
        for (CaseModel caseModel : caseModelList) {
            caseModel.setUpUserId(CookieManager.getCookie(request, "ID"));
            caseModel.setUpUserIp(InetAddressInfo.getClientIP());
        }
        return caseService.sortUpdate(request, caseModelList).getBody();
    }



}
