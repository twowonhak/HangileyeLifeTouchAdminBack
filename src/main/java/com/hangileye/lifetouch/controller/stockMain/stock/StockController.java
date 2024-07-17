package com.hangileye.lifetouch.controller.stockMain.stock;

import com.hangileye.lifetouch.model.ErrorModel;
import com.hangileye.lifetouch.model.stockMain.asset.AssetModel;
import com.hangileye.lifetouch.model.stockMain.stock.StockModel;
import com.hangileye.lifetouch.model.stockMain.stock.TeamModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.stockMain.stock.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/stock/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("/listSelectApi")
    public ResponseData listSelect(@RequestBody StockModel stockModel, HttpServletRequest request) {
        return stockService.listSelect(stockModel, request).getBody();
    }


    /*
     * @Description : 공통코드
     * */
    @RequestMapping("/cdListSelectApi")
    public ResponseData cdListSelect(HttpServletRequest request) {
        return stockService.cdListSelect(request).getBody();
    }


    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(@RequestBody StockModel stockModel, HttpServletRequest request) {
        return stockService.insert(stockModel, request).getBody();
    }

    /*
     * @Description : 상세
     * */
    @RequestMapping("/detailSelectApi")
    public ResponseData detailSelect(@RequestBody StockModel stockModel, HttpServletRequest request) {
        return stockService.detailSelect(stockModel.getId(), request).getBody();
    }

    /*
     * @Description : 수정
     * */
    @RequestMapping("/updateApi")
    public ResponseData update(@RequestBody StockModel stockModel, HttpServletRequest request) {
        return stockService.update(stockModel, request).getBody();
    }

    /*
     * @Description : 삭제
     * */
    @RequestMapping("/deleteApi")
    public ResponseData delete(@RequestBody StockModel stockModel, HttpServletRequest request) {
        return stockService.delete(stockModel, request).getBody();
    }

    /*
     * @Description : 회수
     * */
    @RequestMapping("/clearApi")
    public ResponseData clear(@RequestBody StockModel stockModel, HttpServletRequest request) {
        return stockService.clear(stockModel, request).getBody();
    }

    /*
     * @Description : 사용
     * */
    @RequestMapping("/useApi")
    public ResponseData use(@RequestBody StockModel stockModel, HttpServletRequest request) {
        return stockService.use(stockModel, request).getBody();
    }
}
