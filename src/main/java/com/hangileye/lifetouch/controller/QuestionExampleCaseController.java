package com.hangileye.lifetouch.controller;

import com.hangileye.lifetouch.model.PatientCaseModel;
import com.hangileye.lifetouch.model.QuestionExampleCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.QuestionExampleCaseService;
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
@RequestMapping("/api/question")
public class QuestionExampleCaseController {

    private final QuestionExampleCaseService questionExampleCaseCaseMapper;

    public QuestionExampleCaseController(QuestionExampleCaseService questionExampleCaseCaseMapper) {
        this.questionExampleCaseCaseMapper = questionExampleCaseCaseMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("listSelectApi")
    public ResponseData listSelect(@RequestBody QuestionExampleCaseModel questionExampleCaseModel) {
        return questionExampleCaseCaseMapper.listSelect().getBody();
    }

    /*
     * @Description : 상세 조회
     * */
    @RequestMapping("detailSelectApi")
    public ResponseData detailSelect(@RequestBody QuestionExampleCaseModel questionExampleCaseModel) {
        return questionExampleCaseCaseMapper.detailSelect(questionExampleCaseModel).getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest response, @RequestBody QuestionExampleCaseModel questionExampleCaseModel) {
        questionExampleCaseModel.setCrUserId(CookieManager.getCookie(response, "ID"));
        questionExampleCaseModel.setCrUserIp(InetAddressInfo.getClientIP());
        return questionExampleCaseCaseMapper.insert(questionExampleCaseModel).getBody();
    }

    /*
     * @Description : 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest response, @RequestBody QuestionExampleCaseModel questionExampleCaseModel) {
        questionExampleCaseModel.setDelUserId(CookieManager.getCookie(response, "ID"));
        questionExampleCaseModel.setDelUserIp(InetAddressInfo.getClientIP());
        return questionExampleCaseCaseMapper.delete(questionExampleCaseModel).getBody();
    }
}
