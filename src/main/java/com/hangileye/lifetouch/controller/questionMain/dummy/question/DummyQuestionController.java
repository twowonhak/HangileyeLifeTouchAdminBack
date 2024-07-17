package com.hangileye.lifetouch.controller.questionMain.dummy.question;

import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyQuestionCaseModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.dummy.question.DummyQuestionService;
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
public class DummyQuestionController {

    private final DummyQuestionService dummyQuestionService;

    public DummyQuestionController(DummyQuestionService dummyQuestionService) {
        this.dummyQuestionService = dummyQuestionService;
    }


    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("listSelectApi")
    public ResponseData listSelect(HttpServletRequest request, @RequestBody DummyQuestionCaseModel dummyQuestionCaseModel) {
        return dummyQuestionService.listSelect(request, dummyQuestionCaseModel).getBody();
    }

    /*
     * @Description : 상세 조회
     * */
    @RequestMapping("detailSelectApi")
    public ResponseData detailSelect(HttpServletRequest request, @RequestBody DummyQuestionCaseModel dummyQuestionCaseModel) {
        return dummyQuestionService.detailSelect(request, dummyQuestionCaseModel.getKey()).getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest request, @RequestBody DummyQuestionCaseModel dummyQuestionCaseModel) {
        dummyQuestionCaseModel.setCrUserId(CookieManager.getCookie(request, "ID"));
        dummyQuestionCaseModel.setCrUserIp(InetAddressInfo.getClientIP());
        return dummyQuestionService.insert(request, dummyQuestionCaseModel).getBody();
    }

    /*
     * @Description : 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest request, @RequestBody DummyQuestionCaseModel dummyQuestionCaseModel) {
        dummyQuestionCaseModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        dummyQuestionCaseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return dummyQuestionService.delete(request, dummyQuestionCaseModel).getBody();
    }

    /*
     * @Description : 수정
     * */
    @RequestMapping("updateApi")
    public ResponseData update(HttpServletRequest request, @RequestBody DummyQuestionCaseModel dummyQuestionCaseModel) {
        dummyQuestionCaseModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        dummyQuestionCaseModel.setUpUserIp(InetAddressInfo.getClientIP());
        return dummyQuestionService.update(request, dummyQuestionCaseModel).getBody();
    }
}
