package com.hangileye.lifetouch.controller.questionMain.question;

import com.hangileye.lifetouch.model.questionMain.question.QuestionCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.question.QuestionService;
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
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("listSelectApi")
    public ResponseData listSelect(@RequestBody QuestionCaseModel questionCaseModel) {
        return questionService.listSelect().getBody();
    }

    /*
     * @Description : 상세 조회
     * */
    @RequestMapping("detailSelectApi")
    public ResponseData detailSelect(@RequestBody QuestionCaseModel questionCaseModel) {
        return questionService.detailSelect(questionCaseModel.getKey()).getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest response, @RequestBody QuestionCaseModel questionCaseModel) {
        questionCaseModel.setCrUserId(CookieManager.getCookie(response, "ID"));
        questionCaseModel.setCrUserIp(InetAddressInfo.getClientIP());
        return questionService.insert(questionCaseModel).getBody();
    }

    /*
     * @Description : 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest response, @RequestBody QuestionCaseModel questionCaseModel) {
        questionCaseModel.setUpUserId(CookieManager.getCookie(response, "ID"));
        questionCaseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return questionService.delete(questionCaseModel).getBody();
    }

    /*
     * @Description : 수정
     * */
    @RequestMapping("updateApi")
    public ResponseData update(HttpServletRequest response, @RequestBody QuestionCaseModel questionCaseModel) {
        questionCaseModel.setUpUserId(CookieManager.getCookie(response, "ID"));
        questionCaseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return questionService.update(questionCaseModel).getBody();
    }
}
