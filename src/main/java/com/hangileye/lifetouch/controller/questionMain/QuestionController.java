package com.hangileye.lifetouch.controller.questionMain;

import com.hangileye.lifetouch.model.questionMain.QueCodeModel;
import com.hangileye.lifetouch.model.questionMain.QuestionModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.QuestionService;
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
@RequestMapping("/api/question/question")
public class QuestionController {

    private final QuestionService questionService;


    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("/codeListSelectApi")
    public ResponseData codeListSelect(HttpServletRequest request) {
        return questionService.codeListSelect(request).getBody();
    }

    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("/listSelectApi")
    public ResponseData listSelect(HttpServletRequest request, @RequestBody QuestionModel questionModel) {
        return questionService.listSelect(request, questionModel).getBody();
    }

    /*
     * @Description : 상세 조회
     * */
    @RequestMapping("/detailSelectApi")
    public ResponseData detailSelect(HttpServletRequest request, @RequestBody QuestionModel questionModel) {
        return questionService.detailSelect(request, questionModel.getKey()).getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("/insertApi")
    public ResponseData insert(HttpServletRequest request, @RequestBody QuestionModel questionModel) {
        questionModel.setCrUserId(CookieManager.getCookie(request, "ID"));
        questionModel.setCrUserIp(InetAddressInfo.getClientIP());
        return questionService.insert(request, questionModel).getBody();
    }

    /*
     * @Description : 삭제
     * */
    @RequestMapping("/deleteApi")
    public ResponseData delete(HttpServletRequest request, @RequestBody QuestionModel questionModel) {
        questionModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        questionModel.setUpUserIp(InetAddressInfo.getClientIP());
        return questionService.delete(request, questionModel).getBody();
    }

    /*
     * @Description : 수정
     * */
    @RequestMapping("/updateApi")
    public ResponseData update(HttpServletRequest request, @RequestBody QuestionModel questionModel) {
        questionModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        questionModel.setUpUserIp(InetAddressInfo.getClientIP());
        return questionService.update(request, questionModel).getBody();
    }

    @RequestMapping("/sortUpdateApi")
    public ResponseData sortUpdate(HttpServletRequest request, @RequestBody List<QuestionModel> questionModelList) {
        for (QuestionModel questionModel : questionModelList) {
            questionModel.setUpUserId(CookieManager.getCookie(request, "ID"));
            questionModel.setUpUserIp(InetAddressInfo.getClientIP());
        }
        return questionService.sortUpdate(request, questionModelList).getBody();
    }


}
