package com.hangileye.lifetouch.model.questionMain;

import lombok.Data;

/*
 * TB : TB_Q001_QUESTION
 * COMMENT : 문진_질문_케이스
 * */

@Data
public class QueCodeModel {

    private String key;
    private String lrgCtgCd;
    private String lrgCtgNm;
    private String sort;
    private String lrgCtgSort;
    private String lrgCtgUseYn;

    private String midCtgCd;
    private String midCtgNm;
    private String midCtgSort;
    private String midCtgUseYn;

    private String crDtime;
    private String crUserId;
    private String crUserIp;
    private String upDtime;
    private String upUserId;
    private String upUserIp;


}
