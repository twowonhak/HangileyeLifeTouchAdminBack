package com.hangileye.lifetouch.controller.questionMain;

import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/common")
public class CommonController {

    private final CommonService commonService;

    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }


    /*
     * @Description : 과 리스트 조회
     * */
    @RequestMapping("/diagListSelect")
    public ResponseData diagListSelect() {
        return commonService.diagListSelect().getBody();
    }

}
