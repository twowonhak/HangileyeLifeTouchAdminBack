package com.hangileye.lifetouch.model.questionMain;

import lombok.Data;

/*
 * TB : TB_Q001_QUESTION
 * COMMENT : 문진_질문_케이스
 * */

@Data
public class QuestionModel {

    private String key;
    private String lrgCtgCd;
    private String midCtgCd;

    private String queTxt;
    private String useStrDat;
    private String useEndDat;
    private String sort;

    private String useYn;
    private String crDtime;
    private String crUserId;
    private String crUserIp;
    private String upDtime;
    private String upUserId;
    private String upUserIp;

    private String searchDate;




}
