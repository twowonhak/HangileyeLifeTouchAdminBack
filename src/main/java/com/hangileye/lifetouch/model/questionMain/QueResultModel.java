package com.hangileye.lifetouch.model.questionMain;

import lombok.Data;

import java.util.Map;

/*
 * COMMENT : 환자 최종 문진 조회
 * */

@Data
public class QueResultModel {

    private String[] lrgCtgCdArr;
    private Map<String,String>[] midCtgCdArr;

    private String lrgCtgCd;
    private String midCtgCd;

}
