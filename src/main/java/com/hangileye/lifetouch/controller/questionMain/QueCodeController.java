package com.hangileye.lifetouch.controller.questionMain;

import com.hangileye.lifetouch.model.questionMain.QueCodeModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.QueCodeService;
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
@RequestMapping("/api/question/queCode")
public class QueCodeController {

    private final QueCodeService queCodeService;

    public QueCodeController(QueCodeService queCodeService) {
        this.queCodeService = queCodeService;
    }

    @RequestMapping("/ctgListSelectApi")
    public ResponseData ctgListSelect(HttpServletRequest request, @RequestBody QueCodeModel queCodeModel) {
        return queCodeService.ctgListSelect(request, queCodeModel).getBody();
    }

    @RequestMapping("/lrgCtgInsertApi")
    public ResponseData lrgCtgInsert(HttpServletRequest request, @RequestBody QueCodeModel queCodeModel) {
        queCodeModel.setCrUserId(CookieManager.getCookie(request, "ID"));
        queCodeModel.setCrUserIp(InetAddressInfo.getClientIP());
        return queCodeService.lrgCtgInsert(request, queCodeModel).getBody();
    }

    @RequestMapping("/migCtgInsertApi")
    public ResponseData migCtgInsert(HttpServletRequest request, @RequestBody QueCodeModel queCodeModel) {
        queCodeModel.setCrUserId(CookieManager.getCookie(request, "ID"));
        queCodeModel.setCrUserIp(InetAddressInfo.getClientIP());
        return queCodeService.migCtgInsert(request, queCodeModel).getBody();
    }

    @RequestMapping("/lrgCtgUpdateApi")
    public ResponseData lrgCtgUpdate(HttpServletRequest request, @RequestBody QueCodeModel queCodeModel) {
        queCodeModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        queCodeModel.setUpUserIp(InetAddressInfo.getClientIP());
        return queCodeService.lrgCtgUpdate(request, queCodeModel).getBody();
    }

    @RequestMapping("/midCtgUpdateApi")
    public ResponseData midCtgUpdate(HttpServletRequest request, @RequestBody QueCodeModel queCodeModel) {
        queCodeModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        queCodeModel.setUpUserIp(InetAddressInfo.getClientIP());
        return queCodeService.midCtgUpdate(request, queCodeModel).getBody();
    }

    @RequestMapping("/lrgCtgDeleteApi")
    public ResponseData lrgCtgDelete(HttpServletRequest request, @RequestBody QueCodeModel queCodeModel) {
        queCodeModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        queCodeModel.setUpUserIp(InetAddressInfo.getClientIP());
        return queCodeService.lrgCtgDelete(request, queCodeModel).getBody();
    }

    @RequestMapping("/midCtgDeleteApi")
    public ResponseData midCtgDelete(HttpServletRequest request, @RequestBody QueCodeModel queCodeModel) {
        queCodeModel.setUpUserId(CookieManager.getCookie(request, "ID"));
        queCodeModel.setUpUserIp(InetAddressInfo.getClientIP());
        return queCodeService.midCtgDelete(request, queCodeModel).getBody();
    }

    @RequestMapping("/lrgCtgSortUpdateApi")
    public ResponseData lrgCtgSortUpdate(HttpServletRequest request, @RequestBody List<QueCodeModel> queCodeModelList) {
        for (QueCodeModel queCodeModel : queCodeModelList) {
            queCodeModel.setUpUserId(CookieManager.getCookie(request, "ID"));
            queCodeModel.setUpUserIp(InetAddressInfo.getClientIP());
        }
        return queCodeService.lrgCtgSortUpdate(request, queCodeModelList).getBody();
    }

    @RequestMapping("/midCtgSortUpdateApi")
    public ResponseData midCtgSortUpdate(HttpServletRequest request, @RequestBody List<QueCodeModel> queCodeModelList) {
        for (QueCodeModel queCodeModel : queCodeModelList) {
            queCodeModel.setUpUserId(CookieManager.getCookie(request, "ID"));
            queCodeModel.setUpUserIp(InetAddressInfo.getClientIP());
        }
        return queCodeService.midCtgSortUpdate(request, queCodeModelList).getBody();
    }
}
