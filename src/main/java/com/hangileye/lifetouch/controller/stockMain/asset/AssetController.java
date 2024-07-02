package com.hangileye.lifetouch.controller.stockMain.asset;

import com.hangileye.lifetouch.model.stockMain.asset.AssetModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.stockMain.asset.AssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/stock/asset")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }


    /*
     * @Description : 목록 조회
     * */
    @RequestMapping("/listSelectApi")
    public ResponseData listSelect() {
        return assetService.listSelect().getBody();
    }

    /*
     * @Description : 저장
     * */
    @RequestMapping("insertApi")
    public ResponseData insert(@RequestBody AssetModel assetModel) {
        return assetService.insert(assetModel).getBody();
    }
}
