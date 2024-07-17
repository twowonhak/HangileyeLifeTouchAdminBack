package com.hangileye.lifetouch.controller.questionMain.dummy.question;

import com.hangileye.lifetouch.model.questionMain.dummy.question.DummyExampleModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.dummy.question.DummyExampleService;
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
public class DummyExampleController {

    private final DummyExampleService exampleService;

    public DummyExampleController(DummyExampleService exampleService) {
        this.exampleService = exampleService;
    }


    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("listSelectApi")
    public ResponseData listSelect(HttpServletRequest request, @RequestBody DummyExampleModel dummyExampleModel) {
        return exampleService.listSelect(request, dummyExampleModel.getKey()).getBody();
    }

    /*
     * @Description : 상세 조회
     * */
    @RequestMapping("detailSelectApi")
    public ResponseData detailSelect(HttpServletRequest request, @RequestBody DummyExampleModel dummyExampleModel) {
        return exampleService.detailSelect(request, dummyExampleModel).getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest request, @RequestBody DummyExampleModel dummyExampleModel) {
        dummyExampleModel.setCrUserId(CookieManager.getCookie(request, "ID"));
        dummyExampleModel.setCrUserIp(InetAddressInfo.getClientIP());
        return exampleService.insert(request, dummyExampleModel).getBody();
    }

    /*
     * @Description : 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest request, @RequestBody DummyExampleModel dummyExampleModel) {
        dummyExampleModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        dummyExampleModel.setUpUserIp(InetAddressInfo.getClientIP());
        return exampleService.delete(request, dummyExampleModel).getBody();
    }

    /*
     * @Description : 수정
     * */
    @RequestMapping("updateApi")
    public ResponseData update(HttpServletRequest request, @RequestBody DummyExampleModel dummyExampleModel) {
        dummyExampleModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        dummyExampleModel.setUpUserIp(InetAddressInfo.getClientIP());
        return exampleService.update(request, dummyExampleModel).getBody();
    }

    /*
     * @Description : 순서 수정
     * */
    @RequestMapping("sortUpdateApi")
    public ResponseData sortUpdate(HttpServletRequest request, @RequestBody List<DummyExampleModel> dummyExampleModelList) {
        for (DummyExampleModel dummyExampleModel : dummyExampleModelList) {
            dummyExampleModel.setUpUserId(CookieManager.getCookie(request, "ID"));
            dummyExampleModel.setUpUserIp(InetAddressInfo.getClientIP());
        }
        return exampleService.sortUpdate(request, dummyExampleModelList).getBody();
    }
}
