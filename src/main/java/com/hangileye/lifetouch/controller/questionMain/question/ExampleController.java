package com.hangileye.lifetouch.controller.questionMain.question;

import com.hangileye.lifetouch.model.questionMain.question.ExampleModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.question.ExampleService;
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
@RequestMapping("/api/example")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }


    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("listSelectApi")
    public ResponseData listSelect(@RequestBody ExampleModel exampleModel) {
        return exampleService.listSelect(exampleModel.getKey()).getBody();
    }

    /*
     * @Description : 상세 조회
     * */
    @RequestMapping("detailSelectApi")
    public ResponseData detailSelect(@RequestBody ExampleModel exampleModel) {
        return exampleService.detailSelect(exampleModel).getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest response, @RequestBody ExampleModel exampleModel) {
        exampleModel.setCrUserId(CookieManager.getCookie(response, "ID"));
        exampleModel.setCrUserIp(InetAddressInfo.getClientIP());
        return exampleService.insert(exampleModel).getBody();
    }

    /*
     * @Description : 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest response, @RequestBody ExampleModel exampleModel) {
        exampleModel.setUpUserId(CookieManager.getCookie(response, "ID"));
        exampleModel.setUpUserIp(InetAddressInfo.getClientIP());
        return exampleService.delete(exampleModel).getBody();
    }

    /*
     * @Description : 수정
     * */
    @RequestMapping("updateApi")
    public ResponseData update(HttpServletRequest response, @RequestBody ExampleModel exampleModel) {
        exampleModel.setUpUserId(CookieManager.getCookie(response, "ID"));
        exampleModel.setUpUserIp(InetAddressInfo.getClientIP());
        return exampleService.update(exampleModel).getBody();
    }

    /*
     * @Description : 순서 수정
     * */
    @RequestMapping("sortUpdateApi")
    public ResponseData sortUpdate(HttpServletRequest response, @RequestBody List<ExampleModel> exampleModelList) {
        for (ExampleModel exampleModel : exampleModelList) {
            exampleModel.setUpUserId(CookieManager.getCookie(response, "ID"));
            exampleModel.setUpUserIp(InetAddressInfo.getClientIP());
        }
        return exampleService.sortUpdate(exampleModelList).getBody();
    }
}
