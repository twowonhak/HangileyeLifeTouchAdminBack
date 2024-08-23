package com.hangileye.lifetouch.model.stockMain.asset;

import lombok.Data;

/*
 * TB : TB_D002_ASSETCODE
 * COMMENT : 재고분류코드
 * */

@Data
public class AssetModel {

    private String assMainKey;
    private String assMainNm;
    private String assSubKey;
    private String assSubNm;

    private String totalCount;
    private String useCount;
    private String notUseCount;


}
