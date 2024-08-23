package com.hangileye.lifetouch.controller.questionMain;

import com.hangileye.lifetouch.model.questionMain.QueResultModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.QueResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/question/result")
public class QueResultController {

    private final QueResultService queResultService;

    public QueResultController(QueResultService queResultService) {
        this.queResultService = queResultService;
    }

    @RequestMapping("/listSelectApi")
    public ResponseData listSelect(HttpServletRequest request, @RequestBody QueResultModel queResultModel) {
        return queResultService.listSelect(request, queResultModel).getBody();
    }
}
