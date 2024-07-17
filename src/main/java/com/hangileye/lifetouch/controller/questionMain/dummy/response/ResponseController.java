package com.hangileye.lifetouch.controller.questionMain.dummy.response;

import com.hangileye.lifetouch.model.common.AppointmentModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.dummy.response.ResponseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/response")
public class ResponseController {

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    /*
     * @Description : 작성된 문진표 답변 조회
     * */
    @RequestMapping("/responseResultListSelectApi")
    public ResponseData responseResultListSelect(HttpServletRequest request, @RequestBody AppointmentModel appointmentModel) {
        return responseService.responseResultListSelect(request, appointmentModel).getBody();
    }


}
