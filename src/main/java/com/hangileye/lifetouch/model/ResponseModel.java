package com.hangileye.lifetouch.model;

import lombok.Data;

/*
 * TB : TB_F008_RESPONSE
 * COMMENT : 문진_답변
 * */

@Data
public class ResponseModel {

    private String chartNo;             // 차트번호
    private String appDat;              // 예약 일자
    private String diagCd;              // 진료과 코드
    private String doct;                // 진료의 코드
    
    private String patCase;             // 환자 케이스 키
    private String key;              // 질문 키
    private String queTxt;              // 질문 내용
    private String exaKey;              // 보기 키
    private String exaTxt;              // 보기 내용
    private String resTxt;              // 답변 내용

    private String diviceTy;
    private String osNm;
    private String browserNm;

    private String crDiviceTy;          // 등록 운영체제
    private String crOsNm;              // 등록 브라우저정보
    private String crbrowserNm;           // 등록 브라우저정보
    private String crdTime;             // 등록 일시
    private String crUserIp;            // 등록 IP

}
