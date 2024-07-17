package com.hangileye.lifetouch.model.questionMain;

import lombok.Data;

/*
 * TB : TB_Q002_EXAMPLE
 * COMMENT : 문진_보기
 * */

@Data
public class ResultModel {

    private String key;
    private String chartNo;
    private String vistDat;
    private String appoType;
    private String diagCd;
    private String doctCd;
    private String queKey;
    private String lrgCtgCd;
    private String lrgCtgNm;
    private String midCtgCd;
    private String midCtgNm;
    private String smaCtgCd;
    private String smaCtgNm;
    private String queTxt;
    private String extKey;
    private String extTxt;
    private String resTxt;

    private String crDevice;
    private String crOs;
    private String crBrowser;

}
