package com.hangileye.lifetouch.controller.stockMain.state;

import com.hangileye.lifetouch.model.common.ExcelModel;
import com.hangileye.lifetouch.model.stockMain.state.StateModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.stockMain.state.StateService;
import com.hangileye.lifetouch.utill.Excel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/stock/state")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @RequestMapping("/listSelectApi")
    public ResponseData listSelect(HttpServletRequest request, @RequestBody StateModel stateModel) {
        return stateService.listSelect(request, stateModel).getBody();
    }

    @RequestMapping("/excelExportApi")
    public void excelExportApi(HttpServletResponse response, HttpServletRequest request, @RequestBody ExcelModel excelModel) throws Exception {
        excelModel.setFileName("재고조사상태");
        String[] list = stateService.excelExport(response, request, excelModel);
        try {
            if (list.length > 0) {
                String[] header = {"대분류", "중분류", "입고 or 안전재고 (미사용)", "사용", "폐기 대기", "폐기 완료"};
                Excel.ExcelExport(response, request, header, excelModel, list);
            } else {
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

}
