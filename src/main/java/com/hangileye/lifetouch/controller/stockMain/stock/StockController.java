package com.hangileye.lifetouch.controller.stockMain.stock;

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
    public ResponseData listSelect(@RequestBody StockModel stockModel) {
        return stockService.listSelect(stockModel).getBody();
    }


    /*
     * @Description : 공통코드
     * */
    @RequestMapping("/cdListSelectApi")
    public ResponseData cdListSelect() {
        return stockService.cdListSelect().getBody();
    }


    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(@RequestBody StockModel stockModel) {
        return stockService.insert(stockModel).getBody();
    }

    /*
     * @Description : 상세
     * */
    @RequestMapping("/detailSelectApi")
    public ResponseData detailSelect(@RequestBody StockModel stockModel) {
        return stockService.detailSelect(stockModel.getId()).getBody();
    }

    /*
     * @Description : 수정
     * */
    @RequestMapping("/updateApi")
    public ResponseData update(@RequestBody StockModel stockModel) {
        return stockService.update(stockModel).getBody();
    }

    /*
     * @Description : 삭제
     * */
    @RequestMapping("/deleteApi")
    public ResponseData delete(@RequestBody StockModel stockModel) {
        return stockService.delete(stockModel).getBody();
    }

    /*
     * @Description : 회수
     * */
    @RequestMapping("/clearApi")
    public ResponseData clear(@RequestBody StockModel stockModel) {
        return stockService.clear(stockModel).getBody();
    }

    /*
     * @Description : 사용
     * */
    @RequestMapping("/useApi")
    public ResponseData use(@RequestBody StockModel stockModel) {
        return stockService.use(stockModel).getBody();
    }
}
