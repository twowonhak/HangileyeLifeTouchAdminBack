package com.hangileye.lifetouch.controller.questionMain.dummy.patient;

import com.hangileye.lifetouch.model.questionMain.dummy.patient.SpecialNoteModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.dummy.patient.SpecialNoteService;
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
    public ResponseData listSelect(HttpServletRequest request) {
        return specialNoteService.listSelect(request).getBody();
    }

    /*
     * @Description : 특이사항 상세 조회
     * */
    @RequestMapping("detailSelectApi")
    public ResponseData detailSelect(HttpServletRequest request, @RequestBody SpecialNoteModel specialNoteModel) {
        return specialNoteService.detailSelect(request, specialNoteModel).getBody();
    }

    /*
     * @Description : 특이사항 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(HttpServletRequest request, @RequestBody SpecialNoteModel specialNoteModel) {
        specialNoteModel.setCrUserId(CookieManager.getCookie(request, "ID"));
        specialNoteModel.setCrUserIp(InetAddressInfo.getClientIP());
        return specialNoteService.insert(request, specialNoteModel).getBody();
    }

    /*
     * @Description : 특이사항 삭제
     * */
    @RequestMapping("deleteApi")
    public ResponseData delete(HttpServletRequest request, @RequestBody SpecialNoteModel specialNoteModel) {
        specialNoteModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        specialNoteModel.setUpUserIp(InetAddressInfo.getClientIP());
        return specialNoteService.delete(request, specialNoteModel).getBody();
    }
}
