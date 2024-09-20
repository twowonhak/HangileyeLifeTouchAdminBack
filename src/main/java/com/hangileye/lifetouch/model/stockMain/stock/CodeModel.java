package com.hangileye.lifetouch.model.stockMain.stock;

import lombok.Data;

/*
 * TB : TB_D004_CODE
 * COMMENT : 코드
 * */


@Data
public class CodeModel {
    private String  codeNm;
    private String  optionNm;
    private String  count;

    private String  totalCount;
    private String  useCount;

    private String  notUseCount;



}
