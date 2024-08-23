package com.hangileye.lifetouch.controller;

import com.hangileye.lifetouch.model.common.MenuModel;
import com.hangileye.lifetouch.model.common.PatInfoModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.CommonService;
import com.hangileye.lifetouch.utill.CookieManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
     * @Description : 관리자 메인 메뉴 목록
     * */
    @RequestMapping("/mainMenuSelectApi")
    public ResponseData mainMenuSelect(HttpServletRequest request, MenuModel menuModel) {
        menuModel.setUserId(CookieManager.getCookie(request, "ID"));
        return commonService.mainMenuSelect(request,menuModel).getBody();
    }

    /*
     * @Description : 과 리스트 조회
     * */
    @RequestMapping("/diagListSelect")
    public ResponseData diagListSelect(HttpServletRequest request) {
        return commonService.diagListSelect(request).getBody();
    }

    /*
     * @Description : 환자 조회
     * */
    @RequestMapping("/chartNoSelectApi")
    public ResponseData chartNoSelect(HttpServletRequest request, @RequestBody PatInfoModel patInfoModel) {
        return commonService.chartNoSelect(request, patInfoModel.getChartNo()).getBody();
    }

    /*
     * @Description : 예약 조회
     * */
    @RequestMapping("/appointmentListSelectApi")
    public ResponseData appointmentListSelect(HttpServletRequest request, @RequestBody PatInfoModel patInfoModel) {
        return commonService.appointmentListSelect(request, patInfoModel.getChartNo()).getBody();
    }

}
