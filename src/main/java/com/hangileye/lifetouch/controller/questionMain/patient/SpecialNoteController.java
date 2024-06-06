package com.hangileye.lifetouch.controller.questionMain.patient;

import com.hangileye.lifetouch.model.questionMain.patient.SpecialNoteModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.patient.SpecialNoteService;
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
@RequestMapping("/api/specialNote")
public class SpecialNoteController {

    private final SpecialNoteService specialNoteService;

    public SpecialNoteController(SpecialNoteService specialNoteService) {
        this.specialNoteService = specialNoteService;
    }

    /*
     * @Description : 특이사항 목록 조회
     * */
    @RequestMapping("listSelectApi")
    public ResponseData listSelect() {
        return specialNoteService.listSelect().getBody();
    }

    /*
     * @Description : 특이사항 상세 조회
     * */
    @RequestMapping("detailSelectApi")
    public ResponseData detailSelect(@RequestBody SpecialNoteModel specialNoteModel) {
        return specialNoteService.detailSelect(specialNoteModel).getBody();
    }

    /*
     * @Description : 특이사항 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest response, @RequestBody SpecialNoteModel specialNoteModel) {
        specialNoteModel.setCrUserId(CookieManager.getCookie(response, "ID"));
        specialNoteModel.setCrUserIp(InetAddressInfo.getClientIP());
        return specialNoteService.insert(specialNoteModel).getBody();
    }

    /*
     * @Description : 특이사항 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest response, @RequestBody SpecialNoteModel specialNoteModel) {
        specialNoteModel.setUpUserId(CookieManager.getCookie(response, "ID"));
        specialNoteModel.setUpUserIp(InetAddressInfo.getClientIP());
        return specialNoteService.delete(specialNoteModel).getBody();
    }
}
