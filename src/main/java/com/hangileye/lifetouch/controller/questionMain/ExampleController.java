package com.hangileye.lifetouch.controller.questionMain;

import com.hangileye.lifetouch.model.questionMain.ExampleModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.ExampleService;
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
@RequestMapping("/api/question/example")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("/listSelectApi")
    public ResponseData listSelect(HttpServletRequest request, @RequestBody ExampleModel exampleModel) {
        return exampleService.listSelect(request, exampleModel.getKey()).getBody();
    }

    /*
     * @Description : 상세 조회
     * */
    @RequestMapping("/detailSelectApi")
    public ResponseData detailSelect(HttpServletRequest request, @RequestBody ExampleModel exampleModel) {
        return exampleService.detailSelect(request, exampleModel).getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("/insertApi")
    public ResponseData insert(HttpServletRequest request, @RequestBody ExampleModel exampleModel) {
        exampleModel.setCrUserId(CookieManager.getCookie(request, "ID"));
        exampleModel.setCrUserIp(InetAddressInfo.getClientIP());
        return exampleService.insert(request, exampleModel).getBody();
    }

    /*
     * @Description : 삭제
     * */
    @RequestMapping("/deleteApi")
    public ResponseData delete(HttpServletRequest request, @RequestBody ExampleModel exampleModel) {
        exampleModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        exampleModel.setUpUserIp(InetAddressInfo.getClientIP());
        return exampleService.delete(request, exampleModel).getBody();
    }

    /*
     * @Description : 수정
     * */
    @RequestMapping("/updateApi")
    public ResponseData update(HttpServletRequest request, @RequestBody ExampleModel exampleModel) {
        exampleModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        exampleModel.setUpUserIp(InetAddressInfo.getClientIP());
        return exampleService.update(request, exampleModel).getBody();
    }

    /*
     * @Description : 순서 수정
     * */
    @RequestMapping("/sortUpdateApi")
    public ResponseData sortUpdate(HttpServletRequest request, @RequestBody List<ExampleModel> exampleModelList) {
        for (ExampleModel exampleModel : exampleModelList) {
            exampleModel.setUpUserId(CookieManager.getCookie(request, "ID"));
            exampleModel.setUpUserIp(InetAddressInfo.getClientIP());
        }
        return exampleService.sortUpdate(request, exampleModelList).getBody();
    }



}
