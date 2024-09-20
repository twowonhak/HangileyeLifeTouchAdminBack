package com.hangileye.lifetouch.controller.questionMain;

import com.hangileye.lifetouch.model.common.ExcelModel;
import com.hangileye.lifetouch.model.questionMain.QueResultModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.questionMain.QueResultService;
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

    @RequestMapping("/stateExcelExportApi")
    public void stateExcelExport(HttpServletResponse response, HttpServletRequest request, @RequestBody ExcelModel excelModel) throws Exception {
        excelModel.setFileName("문진결과통계");
        String[] list = queResultService.stateExcelExport(response, request, excelModel);
        try {
            if (list.length > 0) {
                String[] header = {"차트번호", "환자명", "성별", "나이", "방문일자", "방문타입", "진료과", "대분류명", "중분류명", "질문", "보기", "답변"};
                Excel.ExcelExport(response, request, header, excelModel, list);
            } else {
                System.out.println("없다!!");
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}
